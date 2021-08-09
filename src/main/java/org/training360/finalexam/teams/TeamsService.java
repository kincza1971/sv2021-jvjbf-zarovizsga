package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.reposytories.PlayersRepository;
import org.training360.finalexam.reposytories.TeamsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamsService {

    TeamsRepository teamsRepository;
    PlayersRepository playersRepository;
    ModelMapper modelMapper;

    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamsRepository.findAll();
        return teams.stream().map(t -> modelMapper.map(t, TeamDTO.class)).toList();
    }

    @Transactional
    public TeamDTO saveTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());
        teamsRepository.save(team);
        System.out.println(team);
        return modelMapper.map(team, TeamDTO.class);
    }


    @Transactional
    public TeamDTO addNewPlayerToTeamById(long id, CreatePlayerCommand command) {
        Team team = teamsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("teams"));
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        team.addPlayer(player);
        return modelMapper.map(team, TeamDTO.class);
    }
}

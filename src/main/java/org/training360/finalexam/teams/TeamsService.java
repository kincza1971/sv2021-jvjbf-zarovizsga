package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PlayerDTO;
import org.training360.finalexam.players.PlayersRepository;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TeamsService {

    TeamsRepository teamsRepository;
    PlayersRepository playersRepository;
    ModelMapper modelMapper;

    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamsRepository.findAll();
        return teams.stream().map(t -> modelMapper.map(t, TeamDTO.class)).toList();
    }

    @Transactional
    public TeamDTO saveTeam(TeamCreateCommand command) {
        Team team = new Team(command.getName());
        teamsRepository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }


    @Transactional
    public TeamDTO savePlayerToTeam(Long id, CreatePlayerCommand command) {
        Team team = teamsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find team with this id: " + id));
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition(), team);
        playersRepository.save(player);
        return modelMapper.map(team, TeamDTO.class);
    }
}

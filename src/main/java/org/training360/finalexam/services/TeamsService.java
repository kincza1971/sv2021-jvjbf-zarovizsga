package org.training360.finalexam.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.commands.CreatePlayerCommand;
import org.training360.finalexam.commands.UpdateWithExistingPlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.reposytories.PlayersRepository;
import org.training360.finalexam.reposytories.TeamsRepository;
import org.training360.finalexam.commands.CreateTeamCommand;
import org.training360.finalexam.teams.EntityNotFoundException;
import org.training360.finalexam.teams.Team;
import org.training360.finalexam.teams.TeamDTO;

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


    private boolean isTransferable(Team team,Player player) {
        if (player.getTeam() == null) {
            long count = team.getPlayers().stream()
                    .filter(player1 -> player1.getPosition().equals(player.getPosition()))
                    .count();
            return count < 2;
        }
        return false;
    }

    @Transactional
    public TeamDTO addExistingPlayerToTeamById(long id, UpdateWithExistingPlayerCommand command) {
        Team team  = teamsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("teams"));
        Player player = playersRepository.findById(command.getPlayerId())
                .orElseThrow(() -> new EntityNotFoundException("players"));
        if (isTransferable(team, player)) {
            team.addPlayer(player);
        } else {
            throw new IllegalArgumentException("A játékos leigazolása sikertelen.");
        }
        return modelMapper.map(team, TeamDTO.class);
    }



}

package org.training360.finalexam.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.commands.CreatePlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PlayerDTO;
import org.training360.finalexam.reposytories.PlayersRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayersService {

    private PlayersRepository repository;

    private ModelMapper modelMapper;

    @Transactional
    public PlayerDTO savePlayer(CreatePlayerCommand command) {
        Player player = new Player(
                command.getName(),
                command.getBirthDate(),
                command.getPosition()
        );
        repository.save(player);
        PlayerDTO playerDTO = modelMapper.map(player,PlayerDTO.class);
        return modelMapper.map(player,PlayerDTO.class);
    }

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players=  repository.findAll();
        List<PlayerDTO> playerDTOS = players.stream().map(p -> modelMapper.map(p, PlayerDTO.class)).toList();
        return  playerDTOS;
    }

    @Transactional
    public void deletePlayerByid(long id) {
        repository.deleteById(id);
    }
}

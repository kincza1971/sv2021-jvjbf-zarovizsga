package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@AllArgsConstructor
public class PlayersController {

    private PlayersService service;

    @GetMapping
    public List<PlayerDTO> getPlayers() {
        return service.getAllPlayers();
    }

    @PostMapping()
    public PlayerDTO savePlayer(@Valid @RequestBody CreatePlayerCommand command) {
        return service.savePlayer(command);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable long id) {
        service.deletePlayerByid(id);
    }

}

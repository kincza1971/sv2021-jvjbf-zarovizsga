package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.players.CreatePlayerCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams/")
@AllArgsConstructor
public class TeamsController {

    TeamsService teamsService;

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamsService.getAllTeams();
    }

    @PostMapping
    public TeamDTO saveTeam(@Valid @RequestBody TeamCreateCommand command) {
        return teamsService.saveTeam(command);
    }

    @PostMapping("/{id}/players")
    public TeamDTO savePlayerToTeam(@PathVariable long id, @Valid @RequestBody CreatePlayerCommand command) {
        return teamsService.savePlayerToTeam(id, command);
    }
}

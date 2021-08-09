package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.commands.CreatePlayerCommand;
import org.training360.finalexam.commands.CreateTeamCommand;
import org.training360.finalexam.commands.UpdateWithExistingPlayerCommand;
import org.training360.finalexam.services.TeamsService;
import org.zalando.problem.Problem;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor
public class TeamsController {

    private TeamsService teamsService;
    private EntityNotFoundExceptionHandler handler;


    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamsService.getAllTeams();
    }

    @PostMapping
    public TeamDTO saveTeam(@Valid @RequestBody CreateTeamCommand command) {
        return teamsService.saveTeam(command);
    }

    @PostMapping("/{id}/players")
    public TeamDTO addNewPlayerToTeam(@PathVariable long id, @Valid @RequestBody CreatePlayerCommand command) {
        return teamsService.addNewPlayerToTeamById(id, command);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException iae) {
        return handler.handleNotFound(iae,"/recipe/entity-not-found", "Entity Not Found");
    }

    @PutMapping("/{id}/players")
    public TeamDTO addExistingPlayerToTeamById(@PathVariable long id, @RequestBody @Valid UpdateWithExistingPlayerCommand command) {
        return teamsService.addExistingPlayerToTeamById(id, command);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        teamsService.deleteById(id);
    }



}

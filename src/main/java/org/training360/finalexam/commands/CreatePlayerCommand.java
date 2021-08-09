package org.training360.finalexam.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.players.PositionType;
import org.training360.finalexam.teams.Team;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerCommand {
    @NotBlank
    private String name;

    private LocalDate birthDate;

    private PositionType position;

    public CreatePlayerCommand(String name) {
        this.name = name;
    }
}
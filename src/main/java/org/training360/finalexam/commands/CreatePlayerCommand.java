package org.training360.finalexam.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.enums.PositionType;

import javax.validation.constraints.NotBlank;
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
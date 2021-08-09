package org.training360.finalexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.dtos.PlayerDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeamDTO {
    private Long id;

    private String name;

    private List<PlayerDTO> players;

}

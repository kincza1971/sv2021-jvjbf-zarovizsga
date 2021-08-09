package org.training360.finalexam.commands;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.players.Player;

import javax.validation.constraints.NotNull;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UpdateWithExistingPlayerCommand {

        @NotNull
        private Long playerId;
    }
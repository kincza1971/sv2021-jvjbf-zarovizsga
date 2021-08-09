package org.training360.finalexam.commands;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UpdateWithExistingPlayerCommand {

        @NotNull
        private Long playerId;
    }
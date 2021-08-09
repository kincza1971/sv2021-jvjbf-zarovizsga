package org.training360.finalexam.teams;


import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class EntityNotFoundException extends AbstractThrowableProblem {

    public EntityNotFoundException(String entity) {
        super(URI.create(entity + "/not-found"),
                "Not found",
                Status.NOT_FOUND,
                entity + " not found"
        );
    }
}
package pl.ingsolution.greencode.atm.service.dtos;

import jakarta.validation.Valid;

import java.util.List;

public record ServiceTasks(
        List<@Valid Task> tasks
) {
}

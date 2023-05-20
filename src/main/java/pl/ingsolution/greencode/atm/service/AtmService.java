package pl.ingsolution.greencode.atm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ingsolution.greencode.atm.service.dtos.ATM;
import pl.ingsolution.greencode.atm.service.dtos.Task;

import java.util.List;

@Service
@Slf4j
public class AtmService {

    public final List<ATM> calculateOrder(final List<Task> serviceTasks) {
        log.debug("Calculating order of ATM service");
        return serviceTasks.stream()
                .sorted()
                .map(task -> new ATM(task.region(), task.atmId()))
                .distinct()
                .toList();
    }
}

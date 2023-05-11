package pl.ingsolution.greencode.atm.service;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.atm.service.dtos.ATM;
import pl.ingsolution.greencode.atm.service.dtos.RequestType;
import pl.ingsolution.greencode.atm.service.dtos.Task;

import java.util.ArrayList;
import java.util.List;

@RestController
public record AtmController(
        AtmService atmService
) {

    @GetMapping("/atms")
    public List<Task> generateData() {
        Faker faker = new Faker();
        List<Task> tasks = new ArrayList<>();
        RequestType[] requestTypes = {RequestType.STANDARD, RequestType.PRIORITY, RequestType.FAILURE_RESTART, RequestType.SIGNAL_LOW};
        for (int i = 0; i < 100_000; i++) {
            tasks.add(new Task(faker.number().numberBetween(1, 1000), requestTypes[faker.number().numberBetween(0, 3)], faker.number().numberBetween(1, 1000)));
        }
        return tasks;
    }

    @PostMapping("/atms")
    public List<ATM> calculateOrder(@RequestBody final List<Task> serviceTasks) {
        return atmService.calculateOrder(serviceTasks);
    }
}

package pl.ingsolution.greencode.atm.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.atm.service.dtos.ATM;
import pl.ingsolution.greencode.atm.service.dtos.Task;

import java.util.List;

@RestController
public record AtmController(
        AtmService atmService
) {

    @PostMapping("/atms/calculateOrder")
    public List<ATM> calculateOrder(@RequestBody final List<Task> tasks) {
        return atmService.calculateOrder(tasks);
    }
}

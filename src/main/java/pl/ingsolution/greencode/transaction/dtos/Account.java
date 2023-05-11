package pl.ingsolution.greencode.transaction.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Size(min = 26, max = 26)
    private String account;
    @Min(0)
    private int debitCount;
    @Min(0)
    private int creditCount;
    private double balance;
}

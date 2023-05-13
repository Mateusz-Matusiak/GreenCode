package pl.ingsolution.greencode.transaction.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String account;
    private int debitCount;
    private int creditCount;
    private double balance;
}

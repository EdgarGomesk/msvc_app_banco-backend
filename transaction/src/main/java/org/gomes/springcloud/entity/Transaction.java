package org.gomes.springcloud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "The reference field cannot be empty")
    private String reference;

    @NotBlank(message = "The accountIban field cannot be empty")
    private String accountIban;

    @NotBlank(message = "The date field cannot be empty")
    private LocalDate date;

    @NotNull(message = "The amount field cannot be empty")
    private Double amount;

    @NotNull(message = "The fee field cannot be empty")
    private Double fee;

    private String description;

    @NotBlank(message = "The status field cannot be empty")
    private String status;

    @NotBlank(message = "The channel field cannot be empty")
    private String channel;
}

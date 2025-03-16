package ru.otus.java.pro.mt.core.transfers.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Запрос на исполнение перевода")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ExecuteTransferDtoRq {
    @Schema(
            description = "Id клиента - получателя перевода",
            example = "1000000001",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 10,
            maxLength = 10
    )
    private String targetClientId;
    @Schema(
            description = "Отправитель перевода",
            example = "100000000001",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 10,
            maxLength = 10
    )
    private String sourceAccount;
    @Schema(
            description = "Получатель перевода",
            example = "100000000002",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 10,
            maxLength = 10
    )
    private String targetAccount;
    @Schema(
            description = "Сообщение перевода",
            example = "тестовое сообщение",
            requiredMode = Schema.RequiredMode.REQUIRED,
            maxLength = 255
    )
    private String message;
    @Schema(
            description = "Сумма перевода",
            example = "100000.00",
            requiredMode = Schema.RequiredMode.REQUIRED,
            format = "double",
            minimum = "0.01",
            maximum = "999999.99"
    )
    private BigDecimal amount;
}
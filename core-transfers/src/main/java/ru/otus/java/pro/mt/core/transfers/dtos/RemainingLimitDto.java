package ru.otus.java.pro.mt.core.transfers.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Лимиты клиента")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemainingLimitDto {
    @Schema(
            description = "Оставшийся лимит",
            example = "1000",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 4,
            maxLength = 4
    )
    private BigDecimal remainingLimit;
}

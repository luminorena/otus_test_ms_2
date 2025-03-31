package ru.otus.java.pro.mt.core.transfers.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Schema(description = "Перевод клиента")
@NoArgsConstructor
@Data
@AllArgsConstructor
public final class TransfersPageDto {
    @Schema(
            description = "Список переводов",
            example = "List<TransferDto>",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private List<TransferDto> entries;


}
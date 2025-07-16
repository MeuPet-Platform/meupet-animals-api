package com.animals.api.dto.vacina;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoVacinaDTO {

    @NotBlank(message = "O tipo da vacina não pode estar em branco.")
    private String tipoVacina;

    @NotNull(message = "A data da vacina é obrigatória.")
    @PastOrPresent(message = "A data da vacina não pode ser no futuro.")
    private LocalDate dataVacina;

    private LocalDate revacina;
}
package com.meupet.api.dto.vacina;

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

    private String tipoVacina;
    private LocalDate dataVacina;
    private LocalDate revacina;

}

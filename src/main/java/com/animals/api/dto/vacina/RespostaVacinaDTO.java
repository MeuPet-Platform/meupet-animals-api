package com.animals.api.dto.vacina;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RespostaVacinaDTO {
    private Long id;
    private String tipoVacina;
    private LocalDate dataVacina;
    private LocalDate revacina;
}
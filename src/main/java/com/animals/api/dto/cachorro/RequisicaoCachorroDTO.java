package com.animals.api.dto.cachorro;

import com.animals.api.dto.animal.RequisicaoAnimalDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoCachorroDTO extends RequisicaoAnimalDTO {

    @NotNull(message = "O campo 'manso' é obrigatório.")
    private boolean manso;

    @NotNull(message = "O campo 'necessitaFocinheira' é obrigatório.")
    private boolean necessitaFocinheira;
}
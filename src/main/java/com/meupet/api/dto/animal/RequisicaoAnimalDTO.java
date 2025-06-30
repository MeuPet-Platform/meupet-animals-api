package com.meupet.api.dto.animal;

import com.meupet.api.enums.PorteEnum;
import com.meupet.api.enums.SexoAnimalEnum;
import com.meupet.api.enums.StatusVacinacaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class RequisicaoAnimalDTO {

    @NotBlank(message = "O nome não pode estar em branco.")
    protected String nome;

    protected String raca;

    @Positive(message = "O peso deve ser um valor positivo.")
    protected double peso;

    @NotNull(message = "O sexo do animal deve ser informado.")
    protected SexoAnimalEnum sexo;

    @NotNull(message = "O porte do animal deve ser informado.")
    private PorteEnum porte;

    @NotNull(message = "O ID do tutor é obrigatório.")
    private Long idTutor;
}
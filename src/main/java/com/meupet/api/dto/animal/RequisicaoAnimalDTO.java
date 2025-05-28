package com.meupet.api.dto.animal;

import com.meupet.api.enums.PorteEnum;
import com.meupet.api.enums.SexoAnimalEnum;
import com.meupet.api.enums.StatusVacinacaoEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class RequisicaoAnimalDTO {

    protected String nome;
    protected String raca;
    protected double peso;
    protected SexoAnimalEnum sexo;
    protected StatusVacinacaoEnum vacinado;
    private PorteEnum porte;

}

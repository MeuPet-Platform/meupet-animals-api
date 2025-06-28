package com.meupet.api.dto.animal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meupet.api.dto.ave.RespostaAveDTO;
import com.meupet.api.dto.cachorro.RespostaCachorroDTO;
import com.meupet.api.dto.gato.RespostaGatoDTO;
import com.meupet.api.dto.usuario.RespostaUsuarioResumoDTO;
import com.meupet.api.dto.vacina.RespostaVacinaDTO;
import com.meupet.api.enums.PorteEnum;
import com.meupet.api.enums.SexoAnimalEnum;
import com.meupet.api.enums.StatusVacinacaoEnum;
import lombok.Data;
import java.util.List;

// Estas anotações ensinam o Jackson a lidar com a herança
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipoAnimal" // Adiciona um campo "tipoAnimal" ao JSON
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RespostaCachorroDTO.class, name = "Cachorro"),
        @JsonSubTypes.Type(value = RespostaGatoDTO.class, name = "Gato"),
        @JsonSubTypes.Type(value = RespostaAveDTO.class, name = "Ave")
})
@Data
public abstract class RespostaAnimalDTO {
    private Long id;
    private String nome;
    private String raca;
    private double peso;
    private SexoAnimalEnum sexo;
    private StatusVacinacaoEnum vacinado;
    private PorteEnum porte;
    private RespostaUsuarioResumoDTO tutor;
    private List<RespostaVacinaDTO> historicoVacinacao;
    private String tipoAnimal;
}
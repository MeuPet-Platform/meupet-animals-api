package com.meupet.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexoAnimalEnum {

    MACHO("Macho"),
    FEMEA("Fêmea"),
    NAO_INFORMADO("Não Informado");

    private final String descricao;

    SexoAnimalEnum(String descricao) {
        this.descricao = descricao;
    }


    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static SexoAnimalEnum fromDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            return NAO_INFORMADO;
        }
        for (SexoAnimalEnum sexo : SexoAnimalEnum.values()) {
            if (sexo.descricao.equalsIgnoreCase(descricao.trim())) {
                return sexo;
            }
        }

        throw new IllegalArgumentException("Descrição de sexo inválida: '" + descricao + "'. Valores esperados: 'Macho', 'Fêmea', 'Não Informado'.");
    }
}

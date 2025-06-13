package com.meupet.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PorteEnum {

    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande"),
    GIGANTE("Gigante"),
    NAO_INFORMADO("Não Informado");

    private final String descricao;

    PorteEnum(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static PorteEnum getPorte(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            return NAO_INFORMADO;
        }

        if ("Medio".equalsIgnoreCase(descricao.trim())) {
            return MEDIO;
        }

        for (PorteEnum porte : PorteEnum.values()) {
            if (porte.descricao.equalsIgnoreCase(descricao.trim())) {
                return porte;
            }
        }
        throw new IllegalArgumentException("Porte inválido: '" + descricao + "'. Valores esperados: 'Pequeno', 'Médio', 'Grande', 'Gigante', 'Não Informado'.");
    }

}

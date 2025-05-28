package com.meupet.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusVacinacaoEnum {

    VACINADO("Vacinado"),
    NAO_VACINADO("Não Vacinado"),
    VACINACAO_PENDENTE("Vacinação Pendente"),
    DESCONHECIDO("Desconhecido");

    private final String descricao;

    StatusVacinacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }


    @JsonCreator
    public static StatusVacinacaoEnum fromDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            return DESCONHECIDO;
        }
        for (StatusVacinacaoEnum status : StatusVacinacaoEnum.values()) {
            if (status.descricao.equalsIgnoreCase(descricao.trim())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status de vacinação inválido: '" + descricao + "'. Valores esperados: 'Vacinado', 'Não Vacinado', 'Vacinação Pendente', 'Desconhecido'.");
    }
}

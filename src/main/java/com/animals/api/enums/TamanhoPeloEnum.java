package com.animals.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TamanhoPeloEnum {
    CURTO("Curto"),
    MEDIO("Médio"),
    LONGO("Longo"),
    SEM_PELO("Sem Pelo"),
    DESCONHECIDO("Desconhecido");

    private final String descricao;

    TamanhoPeloEnum(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TamanhoPeloEnum fromDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            return DESCONHECIDO;
        }
        for (TamanhoPeloEnum tamanho : TamanhoPeloEnum.values()) {
            if (tamanho.descricao.equalsIgnoreCase(descricao.trim())) {
                return tamanho;
            }
        }

        throw new IllegalArgumentException("Tamanho de pelo inválido: '" + descricao + "'. Valores esperados: 'Curto', 'Médio', 'Longo', 'Sem Pelo', 'Desconhecido'.");
    }
}
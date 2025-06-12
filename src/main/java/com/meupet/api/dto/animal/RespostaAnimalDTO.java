package com.meupet.api.dto.animal;

import lombok.Data;

@Data
public class RespostaAnimalDTO {

    private Long id;
    private String nome;
    private String tipo; // Ex: "Cachorro", "Gato", "Ave"
}
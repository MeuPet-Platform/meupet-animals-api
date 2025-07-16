package com.animals.api.dto.ave;


import com.animals.api.dto.animal.RespostaAnimalDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RespostaAveDTO extends RespostaAnimalDTO {

    private boolean asaCortada;
    private boolean emGaiola;
    private boolean exotico;

}

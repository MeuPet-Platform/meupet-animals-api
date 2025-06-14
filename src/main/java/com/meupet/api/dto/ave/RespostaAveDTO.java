package com.meupet.api.dto.ave;


import com.meupet.api.dto.animal.RespostaAnimalDTO;
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

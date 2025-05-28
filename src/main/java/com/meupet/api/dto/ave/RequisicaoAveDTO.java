package com.meupet.api.dto.ave;

import com.meupet.api.dto.animal.RequisicaoAnimalDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoAveDTO extends RequisicaoAnimalDTO {

    private boolean asaCortada;
    private boolean emGaiola;
    private boolean exotico;

}

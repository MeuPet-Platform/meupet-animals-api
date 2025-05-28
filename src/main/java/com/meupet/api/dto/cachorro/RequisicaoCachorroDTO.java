package com.meupet.api.dto.cachorro;

import com.meupet.api.dto.animal.RequisicaoAnimalDTO;
import com.meupet.api.enums.PorteEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoCachorroDTO extends RequisicaoAnimalDTO {

    private boolean manso;
    private boolean necessitaFocinheira;
    private PorteEnum porte;
}

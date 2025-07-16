package com.animals.api.mapper;

import com.animals.api.dto.vacina.RequisicaoVacinaDTO;
import com.animals.api.dto.vacina.RespostaVacinaDTO;
import com.animals.api.entity.VacinaEntity;
import org.mapstruct.*;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VacinaMapper {

    RespostaVacinaDTO toRespostaDTO(VacinaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animal", ignore = true)
    VacinaEntity toEntity(RequisicaoVacinaDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animal", ignore = true)
    void updateEntityFromDTO(RequisicaoVacinaDTO dto, @MappingTarget VacinaEntity entity);
}
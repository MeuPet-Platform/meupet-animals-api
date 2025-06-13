package com.meupet.api.mapper;

import com.meupet.api.dto.vacina.RequisicaoVacinaDTO;
import com.meupet.api.dto.vacina.RespostaVacinaDTO;
import com.meupet.api.entity.VacinaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VacinaMapper {

    RespostaVacinaDTO toRespostaDTO(VacinaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animal", ignore = true)
    VacinaEntity toEntity(RequisicaoVacinaDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animal", ignore = true)
    void updateEntityFromDTO(RequisicaoVacinaDTO dto, @MappingTarget VacinaEntity entity);
}
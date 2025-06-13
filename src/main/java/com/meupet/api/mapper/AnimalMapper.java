package com.meupet.api.mapper;

import com.meupet.api.dto.ave.RequisicaoAveDTO;
import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.gato.RequisicaoGatoDTO;
import com.meupet.api.entity.AveEntity;
import com.meupet.api.entity.CachorroEntity;
import com.meupet.api.entity.GatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnimalMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    CachorroEntity toCachorroEntity(RequisicaoCachorroDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    GatoEntity toGatoEntity(RequisicaoGatoDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    AveEntity toAveEntity(RequisicaoAveDTO dto);



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    void updateCachorroFromDTO(RequisicaoCachorroDTO dto, @MappingTarget CachorroEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    void updateGatoFromDTO(RequisicaoGatoDTO dto, @MappingTarget GatoEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "tutor", ignore = true)
    void updateAveFromDTO(RequisicaoAveDTO dto, @MappingTarget AveEntity entity);
}
package com.meupet.api.mapper;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import com.meupet.api.dto.ave.RequisicaoAveDTO;
import com.meupet.api.dto.ave.RespostaAveDTO;
import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.cachorro.RespostaCachorroDTO;
import com.meupet.api.dto.gato.RequisicaoGatoDTO;
import com.meupet.api.dto.gato.RespostaGatoDTO;
import com.meupet.api.dto.usuario.RespostaUsuarioResumoDTO;
import com.meupet.api.entity.*;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "jakarta", uses = VacinaMapper.class)
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

    default RespostaAnimalDTO toRespostaDTO(AnimalEntity entity) {
        if (entity instanceof CachorroEntity) {
            return toCachorroRespostaDTO((CachorroEntity) entity);
        }
        if (entity instanceof GatoEntity) {
            return toGatoRespostaDTO((GatoEntity) entity);
        }
        if (entity instanceof AveEntity) {
            return toAveRespostaDTO((AveEntity) entity);
        }
        return null; // Ou lançar uma exceção
    }

    // MÉTODOS AUXILIARES QUE O MAPSTRUCT IMPLEMENTARÁ
    RespostaCachorroDTO toCachorroRespostaDTO(CachorroEntity cachorro);
    RespostaGatoDTO toGatoRespostaDTO(GatoEntity gato);
    RespostaAveDTO toAveRespostaDTO(AveEntity ave);
    RespostaUsuarioResumoDTO toTutorResumoDTO(UsuarioEntity usuario);
}
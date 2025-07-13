package com.meupet.api.mapper;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import com.meupet.api.dto.ave.RequisicaoAveDTO;
import com.meupet.api.dto.ave.RespostaAveDTO;
import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.cachorro.RespostaCachorroDTO;
import com.meupet.api.dto.gato.RequisicaoGatoDTO;
import com.meupet.api.dto.gato.RespostaGatoDTO;
import com.meupet.api.entity.AnimalEntity;
import com.meupet.api.entity.AveEntity;
import com.meupet.api.entity.CachorroEntity;
import com.meupet.api.entity.GatoEntity;
import org.mapstruct.*;

@Mapper(uses = VacinaMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnimalMapper {

    // Mapeamentos para criar entidades a partir de DTOs
    // O MapStruct mapeia 'idTutor' automaticamente porque o nome é o mesmo na origem e no destino.
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    CachorroEntity toCachorroEntity(RequisicaoCachorroDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    GatoEntity toGatoEntity(RequisicaoGatoDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    AveEntity toAveEntity(RequisicaoAveDTO dto);


    // Mapeamentos para atualizar entidades a partir de DTOs
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "idTutor", ignore = true) // Não permitimos a troca de tutor em uma atualização
    void updateCachorroFromDTO(RequisicaoCachorroDTO dto, @MappingTarget CachorroEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "idTutor", ignore = true)
    void updateGatoFromDTO(RequisicaoGatoDTO dto, @MappingTarget GatoEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "historicoVacinacao", ignore = true)
    @Mapping(target = "idTutor", ignore = true)
    void updateAveFromDTO(RequisicaoAveDTO dto, @MappingTarget AveEntity entity);


    // --- Mapeamentos para DTOs de Resposta ---

    // Este método default continua o mesmo, ele delega para os métodos específicos abaixo.
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
        return null;
    }

    // Métodos específicos que agora mapeiam 'idTutor' em vez do objeto 'tutor'
    @Mapping(target = "tipoAnimal", constant = "Cachorro")
    RespostaCachorroDTO toCachorroRespostaDTO(CachorroEntity cachorro);

    @Mapping(target = "tipoAnimal", constant = "Gato")
    RespostaGatoDTO toGatoRespostaDTO(GatoEntity gato);

    @Mapping(target = "tipoAnimal", constant = "Ave")
    RespostaAveDTO toAveRespostaDTO(AveEntity ave);

}

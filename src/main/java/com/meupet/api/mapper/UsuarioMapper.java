package com.meupet.api.mapper;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
import com.meupet.api.dto.usuario.RespostaUsuarioDTO;
import com.meupet.api.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animais", ignore = true)
    UsuarioEntity toEntity(RequisicaoUsuarioDTO dto);

    // Este método agora terá uma implementação customizada
    // para lidar com a conversão da lista de animais.
    default RespostaUsuarioDTO toRespostaDTO(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        RespostaUsuarioDTO dto = new RespostaUsuarioDTO();
        dto.setId(entity.id);
        dto.setNome(entity.nome); //
        dto.setEmail(entity.email); //

        // Lógica customizada para mapear a lista de animais
        if (entity.animais != null) {
            dto.setAnimais(entity.animais.stream()
                    .map(this::animalEntityToResumoDTO) // Chama o método auxiliar abaixo
                    .collect(Collectors.toList()));
        } else {
            dto.setAnimais(new ArrayList<>());
        }

        return dto;
    }

    // Método auxiliar para converter um AnimalEntity em um Resumo
    default RespostaAnimalDTO animalEntityToResumoDTO(AnimalEntity animal) {
        RespostaAnimalDTO resumo = new RespostaAnimalDTO();
        resumo.setId(animal.id);
        resumo.setNome(animal.getNome()); // O campo 'nome' vem da AnimalEntity

        // Lógica para definir o tipo do animal
        if (animal instanceof CachorroEntity) {
            resumo.setTipo("Cachorro");
        } else if (animal instanceof GatoEntity) {
            resumo.setTipo("Gato");
        } else if (animal instanceof AveEntity) {
            resumo.setTipo("Ave");
        } else {
            resumo.setTipo("Desconhecido");
        }
        return resumo;
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animais", ignore = true)
    void updateEntityFromDTO(RequisicaoUsuarioDTO dto, @MappingTarget UsuarioEntity entity);
}
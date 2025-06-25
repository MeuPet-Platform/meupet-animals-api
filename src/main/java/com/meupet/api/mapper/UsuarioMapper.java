package com.meupet.api.mapper;

import com.meupet.api.dto.usuario.RequisicaoUsuarioDTO;
import com.meupet.api.dto.usuario.RespostaUsuarioDTO;
import com.meupet.api.entity.UsuarioEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = AnimalMapper.class)
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animais", ignore = true)
    UsuarioEntity toEntity(RequisicaoUsuarioDTO dto);

    @Mapping(source = "animais", target = "animais")
    RespostaUsuarioDTO toRespostaDTO(UsuarioEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "animais", ignore = true)
    void updateEntityFromDTO(RequisicaoUsuarioDTO dto, @MappingTarget UsuarioEntity entity);
}

package com.meupet.api.resource;

import com.meupet.api.dto.usuario.*;
import com.meupet.api.entity.UsuarioEntity;
import com.meupet.api.mapper.UsuarioMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Usuários", description = "Operações para gerenciamento de usuários.")
public class UsuarioResource {

    @Inject
    UsuarioMapper mapper;

    @GET
    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.")
    @APIResponse(responseCode = "200", description = "Lista de usuários", content = @Content(schema = @Schema(implementation = RespostaUsuarioDTO[].class)))
    public List<RespostaUsuarioDTO> listar() {
        List<UsuarioEntity> usuarios = UsuarioEntity.listAll();
        return usuarios.stream()
                .map(mapper::toRespostaDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário específico pelo seu ID.")
    @APIResponse(responseCode = "200", description = "Usuário encontrado", content = @Content(schema = @Schema(implementation = RespostaUsuarioDTO.class)))
    @APIResponse(responseCode = "404", description = "Usuário não encontrado")
    public Response buscarPorId(@PathParam("id") Long id) {
        // A busca é feita na entidade específica
        return UsuarioEntity.findByIdOptional(id)
                .map(UsuarioEntity.class::cast)
                .map(mapper::toRespostaDTO)
                .map(dto -> Response.ok(dto).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    @Operation(summary = "Criar novo usuário", description = "Cadastra um novo usuário no sistema.")
    @APIResponse(responseCode = "21", description = "Usuário criado com sucesso", content = @Content(schema = @Schema(implementation = RespostaUsuarioDTO.class)))
    public Response criar(@Valid RequisicaoUsuarioDTO dto) {
        UsuarioEntity entity = mapper.toEntity(dto);
        //TODO Adicionar criptografia de senha
        entity.persist();
        return Response.status(Response.Status.CREATED).entity(mapper.toRespostaDTO(entity)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente.")
    @APIResponse(responseCode = "200", description = "Usuário atualizado com sucesso", content = @Content(schema = @Schema(implementation = RespostaUsuarioDTO.class)))
    @APIResponse(responseCode = "404", description = "Usuário não encontrado")
    public Response atualizar(@PathParam("id") Long id, RequisicaoUsuarioDTO dto) {
        return UsuarioEntity.<UsuarioEntity>findByIdOptional(id)
                .map(entity -> {
                    mapper.updateEntityFromDTO(dto, entity);
                    entity.persist();
                    return Response.ok(mapper.toRespostaDTO(entity)).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Deletar usuário", description = "Remove um usuário do sistema pelo seu ID.")
    @APIResponse(responseCode = "204", description = "Usuário deletado com sucesso (sem conteúdo)")
    @APIResponse(responseCode = "404", description = "Usuário não encontrado")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = UsuarioEntity.deleteById(id);
        if (deletado) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
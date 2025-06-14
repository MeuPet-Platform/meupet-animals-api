package com.meupet.api.resource;

import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.gato.RequisicaoGatoDTO;
import com.meupet.api.dto.ave.RequisicaoAveDTO;
import com.meupet.api.entity.AnimalEntity;
import com.meupet.api.entity.CachorroEntity;
import com.meupet.api.entity.GatoEntity;
import com.meupet.api.entity.AveEntity;
import com.meupet.api.enums.StatusVacinacaoEnum;
import com.meupet.api.mapper.AnimalMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.List;

@Path("/animais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Animais", description = "Operações para gerenciamento de todos os tipos de animais.")
public class AnimalResource {

    @Inject
    AnimalMapper mapper;

    @POST
    @Path("/cachorro")
    @Transactional
    @Operation(summary = "Criar novo cachorro")
    @APIResponse(responseCode = "201", description = "Cachorro criado com sucesso")
    public Response criarCachorro(@Valid RequisicaoCachorroDTO dto) {
        CachorroEntity cachorro = mapper.toCachorroEntity(dto);

        cachorro.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        cachorro.setHistoricoVacinacao(new ArrayList<>());

        cachorro.persist();
        return Response.status(Response.Status.CREATED).entity(cachorro).build();
    }

    @POST
    @Path("/gato")
    @Transactional
    @Operation(summary = "Criar novo gato")
    @APIResponse(responseCode = "201", description = "Gato criado com sucesso")
    public Response criarGato(@Valid RequisicaoGatoDTO dto) {
        GatoEntity gato = mapper.toGatoEntity(dto);

        gato.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        gato.setHistoricoVacinacao(new ArrayList<>());

        gato.persist();
        return Response.status(Response.Status.CREATED).entity(gato).build();
    }

    @POST
    @Path("/ave")
    @Transactional
    @Operation(summary = "Criar nova ave")
    @APIResponse(responseCode = "201", description = "Ave criada com sucesso")
    public Response criarAve(@Valid RequisicaoAveDTO dto) {
        AveEntity ave = mapper.toAveEntity(dto);

        ave.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        ave.setHistoricoVacinacao(new ArrayList<>());

        ave.persist();
        return Response.status(Response.Status.CREATED).entity(ave).build();
    }

    @GET
    @Operation(summary = "Listar todos os animais", description = "Retorna uma lista de todos os animais, independentemente do tipo.")
    public List<AnimalEntity> listarTodos() {
        return AnimalEntity.listAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar animal por ID")
    @APIResponse(responseCode = "200", description = "Animal encontrado")
    @APIResponse(responseCode = "404", description = "Animal não encontrado")
    public Response buscarPorId(@PathParam("id") Long id) {
        return AnimalEntity.findByIdOptional(id)
                .map(animal -> Response.ok(animal).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/cachorro/{id}")
    @Transactional
    @Operation(summary = "Atualizar um cachorro existente", description = "Atualiza os dados de um cachorro específico pelo seu ID.")
    @APIResponse(responseCode = "200", description = "Cachorro atualizado com sucesso")
    @APIResponse(responseCode = "404", description = "Cachorro não encontrado")
    public Response atualizarCachorro(@PathParam("id") Long id, RequisicaoCachorroDTO dto) {
        return CachorroEntity.<CachorroEntity>findByIdOptional(id)
                .map(cachorro -> {
                    mapper.updateCachorroFromDTO(dto, cachorro);
                    cachorro.persist();
                    return Response.ok(cachorro).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/gato/{id}")
    @Transactional
    @Operation(summary = "Atualizar um gato existente")
    @APIResponse(responseCode = "200", description = "Gato atualizado com sucesso")
    @APIResponse(responseCode = "404", description = "Gato não encontrado")
    public Response atualizarGato(@PathParam("id") Long id, RequisicaoGatoDTO dto) {
        return GatoEntity.<GatoEntity>findByIdOptional(id)
                .map(gato -> {
                    mapper.updateGatoFromDTO(dto, gato);
                    gato.persist();
                    return Response.ok(gato).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/ave/{id}")
    @Transactional
    @Operation(summary = "Atualizar uma ave existente")
    @APIResponse(responseCode = "200", description = "Ave atualizada com sucesso")
    @APIResponse(responseCode = "404", description = "Ave não encontrada")
    public Response atualizarAve(@PathParam("id") Long id, RequisicaoAveDTO dto) {
        return AveEntity.<AveEntity>findByIdOptional(id)
                .map(ave -> {
                    mapper.updateAveFromDTO(dto, ave);
                    ave.persist();
                    return Response.ok(ave).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Deletar animal")
    @APIResponse(responseCode = "204", description = "Animal deletado com sucesso")
    @APIResponse(responseCode = "404", description = "Animal não encontrado")
    public Response deletar(@PathParam("id") Long id) {
        if (AnimalEntity.deleteById(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
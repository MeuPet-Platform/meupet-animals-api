package com.animals.api.resource;

import com.aayushatharva.brotli4j.common.annotations.Internal;
import com.animals.api.client.UsuarioRestClient;
import com.animals.api.dto.animal.RespostaAnimalDTO;
import com.animals.api.dto.ave.RequisicaoAveDTO;
import com.animals.api.dto.cachorro.RequisicaoCachorroDTO;
import com.animals.api.dto.gato.RequisicaoGatoDTO;
import com.animals.api.entity.AnimalEntity;
import com.animals.api.entity.AveEntity;
import com.animals.api.entity.CachorroEntity;
import com.animals.api.entity.GatoEntity;
import com.animals.api.enums.StatusVacinacaoEnum;
import com.animals.api.mapper.AnimalMapper;
import io.vertx.core.cli.annotations.Hidden;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
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
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/animais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Animais", description = "Operações para gerenciamento de todos os tipos de animais.")
@RolesAllowed({"USER", "ADMIN"})
public class AnimalResource {


    private final AnimalMapper mapper = Mappers.getMapper(AnimalMapper.class);

    @Inject
    @RestClient
    UsuarioRestClient usuarioRestClient;

    @POST
    @Path("/cachorro")
    @Transactional
    @Operation(summary = "Criar novo cachorro")
    @APIResponse(responseCode = "201", description = "Cachorro criado com sucesso")
    public Response criarCachorro(@Valid RequisicaoCachorroDTO dto) {

        // 1. Valida se o tutor existe fazendo uma chamada de API para o users-api
        Response respostaTutor = usuarioRestClient.buscarPorId(dto.getIdTutor());
        if (respostaTutor.getStatus() != 200) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Tutor com ID " + dto.getIdTutor() + " não encontrado.").build();
        }

        // 2. A lógica de criação continua, agora com a certeza de que o tutor é válido
        CachorroEntity cachorro = mapper.toCachorroEntity(dto);
        // O ID do tutor já é mapeado diretamente do DTO

        cachorro.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        cachorro.setHistoricoVacinacao(new ArrayList<>());
        cachorro.persist();

        RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(cachorro);
        return Response.status(Response.Status.CREATED).entity(respostaDTO).build();
    }

    @POST
    @Path("/gato")
    @Transactional
    @Operation(summary = "Criar novo gato")
    @APIResponse(responseCode = "201", description = "Gato criado com sucesso")
    public Response criarGato(@Valid RequisicaoGatoDTO dto) {

        // 1. Valida se o tutor existe fazendo uma chamada de API para o users-api
        Response respostaTutor = usuarioRestClient.buscarPorId(dto.getIdTutor());
        if (respostaTutor.getStatus() != 200) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Tutor com ID " + dto.getIdTutor() + " não encontrado.").build();
        }

        // 2. A lógica de criação continua, agora com a certeza de que o tutor é válido
        GatoEntity gato = mapper.toGatoEntity(dto);
        // O ID do tutor já é mapeado diretamente do DTO

        gato.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        gato.setHistoricoVacinacao(new ArrayList<>());
        gato.persist();

        RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(gato);
        return Response.status(Response.Status.CREATED).entity(respostaDTO).build();
    }

    @POST
    @Path("/ave")
    @Transactional
    @Operation(summary = "Criar nova ave")
    @APIResponse(responseCode = "201", description = "Ave criada com sucesso")
    public Response criarAve(@Valid RequisicaoAveDTO dto) {

        // 1. Valida se o tutor existe fazendo uma chamada de API para o users-api
        Response respostaTutor = usuarioRestClient.buscarPorId(dto.getIdTutor());
        if (respostaTutor.getStatus() != 200) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Tutor com ID " + dto.getIdTutor() + " não encontrado.").build();
        }

        // 2. A lógica de criação continua, agora com a certeza de que o tutor é válido
        AveEntity ave = mapper.toAveEntity(dto);
        // O ID do tutor já é mapeado diretamente do DTO

        ave.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        ave.setHistoricoVacinacao(new ArrayList<>());
        ave.persist();

        RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(ave);
        return Response.status(Response.Status.CREATED).entity(respostaDTO).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar animal por ID")
    public Response buscarPorId(@PathParam("id") Long id) {
        return AnimalEntity.findByIdOptional(id)
                .map(AnimalEntity.class::cast)
                .map(animal -> Response.ok(mapper.toRespostaDTO(animal)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Operation(summary = "Listar animais",
            description = "Retorna uma lista de todos os animais. Pode ser filtrado por ID do tutor para listar apenas os animais daquele tutor.")
    @APIResponse(responseCode = "200", description = "Lista de animais",
            content = @Content(schema = @Schema(implementation = RespostaAnimalDTO[].class)))
    public Response listarAnimais(@QueryParam("tutorId") Long tutorId) {

        List<AnimalEntity> animais;

        if (tutorId != null) {
            // CASO 1: Se um tutorId foi fornecido na URL, filtramos a busca.
            // O Panache facilita muito isso com uma query simples.
            animais = AnimalEntity.list("idTutor", tutorId);
        } else {
            // CASO 2: Se nenhum tutorId foi fornecido, lista todos os animais (útil para um admin).
            animais = AnimalEntity.listAll();
        }

        // Mapeia a lista de entidades para uma lista de DTOs para a resposta.
        List<RespostaAnimalDTO> dtos = animais.stream()
                .map(mapper::toRespostaDTO)
                .collect(Collectors.toList());

        return Response.ok(dtos).build();
    }

    @PUT
    @Path("/cachorro/{id}")
    @Transactional
    @Operation(summary = "Atualizar um cachorro existente")
    public Response atualizarCachorro(@PathParam("id") Long id, RequisicaoCachorroDTO dto) {
        return CachorroEntity.<CachorroEntity>findByIdOptional(id)
                .map(cachorro -> {
                    mapper.updateCachorroFromDTO(dto, cachorro);
                    cachorro.persist();
                    RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(cachorro);
                    return Response.ok(respostaDTO).build();
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
                    RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(gato);
                    return Response.ok(respostaDTO).build();
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
                    RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(ave);
                    return Response.ok(respostaDTO).build();
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


    //TODO deixar com mais segurança esse endpoint
    @DELETE
    @Path("/por-tutor/{idTutor}")
    @Transactional
    @PermitAll
    public Response deletarAnimaisPorTutor(@PathParam("idTutor") Long idTutor) {
        List<AnimalEntity> animais = AnimalEntity.list("idTutor", idTutor);

        for (AnimalEntity animal : animais) {
            // Deleta explicitamente os filhos da herança
            if (animal instanceof GatoEntity) {
                GatoEntity.deleteById(animal.id);
            } else if (animal instanceof CachorroEntity) {
                CachorroEntity.deleteById(animal.id);
            } else if (animal instanceof AveEntity) {
                AveEntity.deleteById(animal.id);
            } else {
                AnimalEntity.deleteById(animal.id);
            }
        }

        return Response.noContent().build();
    }
}
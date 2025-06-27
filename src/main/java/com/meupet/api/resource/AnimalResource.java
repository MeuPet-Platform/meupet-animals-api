package com.meupet.api.resource;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import com.meupet.api.dto.cachorro.RequisicaoCachorroDTO;
import com.meupet.api.dto.gato.RequisicaoGatoDTO;
import com.meupet.api.dto.ave.RequisicaoAveDTO;
import com.meupet.api.entity.*;
import com.meupet.api.enums.StatusVacinacaoEnum;
import com.meupet.api.mapper.AnimalMapper;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/animais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Animais", description = "Operações para gerenciamento de todos os tipos de animais.")
@RolesAllowed({"USER", "ADMIN"})
public class AnimalResource {


    private final AnimalMapper mapper = Mappers.getMapper(AnimalMapper.class);

    @Inject
    JsonWebToken jwt;

    @POST
    @Path("/cachorro")
    @Transactional
    @Operation(summary = "Criar novo cachorro")
    @APIResponse(responseCode = "201", description = "Cachorro criado com sucesso")
    public Response criarCachorro(@Valid RequisicaoCachorroDTO dto) {

        Optional<UsuarioEntity> tutorOptional = UsuarioEntity.findByIdOptional(dto.getIdTutor());
        if (tutorOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Tutor com ID " + dto.getIdTutor() + " não encontrado.").build();
        }

        UsuarioEntity tutorEncontrado = tutorOptional.get();
        CachorroEntity cachorro = mapper.toCachorroEntity(dto);

        cachorro.setTutor(tutorEncontrado);

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

        Optional<UsuarioEntity> tutorOptional = UsuarioEntity.findByIdOptional(dto.getIdTutor());
        if (tutorOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Tutor com ID " + dto.getIdTutor() + " não encontrado.").build();
        }

        UsuarioEntity tutorEncontrado = tutorOptional.get();
        GatoEntity gato = mapper.toGatoEntity(dto);

        gato.setTutor(tutorEncontrado);

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

        Optional<UsuarioEntity> tutorOptional = UsuarioEntity.findByIdOptional(dto.getIdTutor());
        if (tutorOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Tutor com ID " + dto.getIdTutor() + " não encontrado.").build();
        }

        UsuarioEntity tutorEncontrado = tutorOptional.get();
        AveEntity ave = mapper.toAveEntity(dto);

        ave.setTutor(tutorEncontrado);

        ave.setVacinado(StatusVacinacaoEnum.NAO_VACINADO);
        ave.setHistoricoVacinacao(new ArrayList<>());

        ave.persist();

        RespostaAnimalDTO respostaDTO = mapper.toRespostaDTO(ave);
        return Response.status(Response.Status.CREATED).entity(respostaDTO).build();
    }

    @GET
    @Operation(summary = "Listar todos os animais")
    public List<RespostaAnimalDTO> listarTodos() {
        List<AnimalEntity> animais = AnimalEntity.listAll();
        return animais.stream()
                .map(mapper::toRespostaDTO)
                .collect(Collectors.toList());
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
}
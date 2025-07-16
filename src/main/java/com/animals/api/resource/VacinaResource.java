package com.animals.api.resource;

import com.animals.api.dto.vacina.RequisicaoVacinaDTO;
import com.animals.api.dto.vacina.RespostaVacinaDTO;
import com.animals.api.entity.AnimalEntity;
import com.animals.api.entity.VacinaEntity;
import com.animals.api.mapper.VacinaMapper;
import com.animals.api.service.AnimalService;
import io.quarkus.hibernate.orm.panache.Panache;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Path("/animais/{idAnimal}/vacinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Vacinas", description = "Gerenciamento do histórico de vacinação de um animal.")
public class VacinaResource {

    private final VacinaMapper mapper = Mappers.getMapper(VacinaMapper.class);


    @Inject // Injeta a nossa classe de serviço
    AnimalService animalService;

    @GET
    @Operation(summary = "Listar todas as vacinas de um animal")
    public Response listarVacinas(@PathParam("idAnimal") Long idAnimal) {
        return AnimalEntity.findByIdOptional(idAnimal)
                .map(AnimalEntity.class::cast)
                .map(animal -> {
                    var listaDeVacinasDTO = animal.historicoVacinacao.stream()
                            .map(mapper::toRespostaDTO)
                            .collect(Collectors.toList());
                    return Response.ok(listaDeVacinasDTO).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Animal não encontrado.").build());
    }

    @POST
    @Transactional
    @Operation(summary = "Adicionar uma nova vacina a um animal")
    public Response adicionarVacina(@PathParam("idAnimal") Long idAnimal, @Valid RequisicaoVacinaDTO dto) {
        return AnimalEntity.<AnimalEntity>findByIdOptional(idAnimal)
                .map(AnimalEntity.class::cast)
                .map(animal -> {
                    VacinaEntity novaVacina = mapper.toEntity(dto);
                    novaVacina.animal = animal; // Estabelece a relação

                    novaVacina.persistAndFlush();

                    Panache.getEntityManager().refresh(animal);

                    animalService.recalcularEAtualizarStatusVacinacao(animal);
                    animal.persist();

                    return Response.status(Response.Status.CREATED).entity(mapper.toRespostaDTO(novaVacina)).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Animal não encontrado.").build());
    }

    @PUT
    @Path("/{idVacina}")
    @Transactional
    @Operation(summary = "Atualizar um registro de vacina")
    public Response atualizarVacina(@PathParam("idAnimal") Long idAnimal,
                                    @PathParam("idVacina") Long idVacina,
                                    RequisicaoVacinaDTO dto) {

        return VacinaEntity.<VacinaEntity>findByIdOptional(idVacina)
                .map(vacina -> {
                    if (!vacina.getAnimal().id.equals(idAnimal)) {
                        return Response.status(Response.Status.CONFLICT).entity("Vacina não pertence ao animal informado.").build();
                    }

                    mapper.updateEntityFromDTO(dto, vacina);
                    animalService.recalcularEAtualizarStatusVacinacao(vacina.getAnimal());

                    return Response.ok(mapper.toRespostaDTO(vacina)).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{idVacina}")
    @Transactional
    @Operation(summary = "Deletar um registro de vacina")
    public Response deletarVacina(@PathParam("idAnimal") Long idAnimal,
                                  @PathParam("idVacina") Long idVacina) {

        return VacinaEntity.<VacinaEntity>findByIdOptional(idVacina)
                .map(vacina -> {
                    if (!vacina.getAnimal().id.equals(idAnimal)) {
                        return Response.status(Response.Status.CONFLICT).entity("Vacina não pertence ao animal informado.").build();
                    }

                    AnimalEntity animal = vacina.getAnimal();
                    animal.getHistoricoVacinacao().remove(vacina);

                    animalService.recalcularEAtualizarStatusVacinacao(animal);

                    return Response.noContent().build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
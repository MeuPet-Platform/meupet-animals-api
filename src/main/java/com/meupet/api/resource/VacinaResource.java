package com.meupet.api.resource;

import com.meupet.api.dto.vacina.RequisicaoVacinaDTO;
import com.meupet.api.dto.vacina.RespostaVacinaDTO;
import com.meupet.api.entity.AnimalEntity;
import com.meupet.api.entity.VacinaEntity;
import com.meupet.api.mapper.VacinaMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.stream.Collectors;

@Path("/animais/{idAnimal}/vacinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Vacinas", description = "Gerenciamento do histórico de vacinação de um animal.")
public class VacinaResource {

    @Inject
    VacinaMapper mapper;

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
    public Response adicionarVacina(@PathParam("idAnimal") Long idAnimal, RequisicaoVacinaDTO dto) {
        return AnimalEntity.<AnimalEntity>findByIdOptional(idAnimal)
                .map(animal -> {
                    VacinaEntity novaVacina = mapper.toEntity(dto);
                    novaVacina.animal = animal;
                    novaVacina.persist();

                    // PONTO CRÍTICO: Após adicionar a vacina, você deve recalcular
                    // e atualizar o campo 'vacinado' (StatusVacinacaoEnum) na entidade 'animal'.
                    // Ex: animal.setVacinado(meuServicoDeCalculo.calcularStatus(animal.historicoVacinacao));
                    //     animal.persist();

                    return Response.status(Response.Status.CREATED).entity(mapper.toRespostaDTO(novaVacina)).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).entity("Animal não encontrado.").build());
    }
}
package com.meupet.api.resource;

import com.meupet.api.dto.vacina.RequisicaoVacinaDTO;
import com.meupet.api.entity.AnimalEntity;
import com.meupet.api.entity.VacinaEntity;
import com.meupet.api.mapper.VacinaMapper;
import com.meupet.api.service.AnimalService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/vacinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Vacinas", description = "Operações diretas em registros de vacinas individuais.")
public class VacinaIndividualResource {

    @Inject
    VacinaMapper mapper;

    @Inject
    AnimalService animalService;

    @PUT
    @Path("/{idVacina}")
    @Transactional
    @Operation(summary = "Atualizar um registro de vacina")
    @APIResponse(responseCode = "200", description = "Registro de vacina atualizado com sucesso")
    @APIResponse(responseCode = "404", description = "Registro de vacina não encontrado")
    public Response atualizarVacina(@PathParam("idVacina") Long idVacina, RequisicaoVacinaDTO dto) {

        return VacinaEntity.<VacinaEntity>findByIdOptional(idVacina)
                .map(vacina -> {
                    mapper.updateEntityFromDTO(dto, vacina);

                    animalService.recalcularEAtualizarStatusVacinacao(vacina.animal);

                    vacina.persist();

                    return Response.ok(mapper.toRespostaDTO(vacina)).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{idVacina}")
    @Transactional
    @Operation(summary = "Deletar um registro de vacina")
    @APIResponse(responseCode = "204", description = "Registro de vacina deletado com sucesso")
    @APIResponse(responseCode = "404", description = "Registro de vacina não encontrado")
    public Response deletarVacina(@PathParam("idVacina") Long idVacina) {
        return VacinaEntity.<VacinaEntity>findByIdOptional(idVacina)
                .map(vacina -> {

                    AnimalEntity animalDoQualPertencia = vacina.animal;

                    animalDoQualPertencia.getHistoricoVacinacao().remove(vacina);

                    animalService.recalcularEAtualizarStatusVacinacao(animalDoQualPertencia);

                    animalDoQualPertencia.persist();

                    return Response.noContent().build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
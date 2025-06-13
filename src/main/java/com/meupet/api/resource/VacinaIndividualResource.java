package com.meupet.api.resource;

import com.meupet.api.dto.vacina.RequisicaoVacinaDTO;
import com.meupet.api.entity.VacinaEntity;
import com.meupet.api.mapper.VacinaMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/vacinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Vacinas", description = "Operações diretas em registros de vacinas individuais.")
public class VacinaIndividualResource {

    @Inject
    VacinaMapper mapper;

    @PUT
    @Path("/{idVacina}")
    @Transactional
    @Operation(summary = "Atualizar um registro de vacina")
    public Response atualizarVacina(@PathParam("idVacina") Long idVacina, RequisicaoVacinaDTO dto) {
        return VacinaEntity.<VacinaEntity>findByIdOptional(idVacina)
                .map(vacina -> {
                    mapper.updateEntityFromDTO(dto, vacina);
                    vacina.persist();

                    // PONTO CRÍTICO: Assim como na criação, após atualizar uma vacina,
                    // o status geral do animal pode ter mudado e precisa ser recalculado.
                    // Ex: meuServicoDeCalculo.atualizarStatus(vacina.animal);

                    return Response.ok(mapper.toRespostaDTO(vacina)).build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{idVacina}")
    @Transactional
    @Operation(summary = "Deletar um registro de vacina")
    public Response deletarVacina(@PathParam("idVacina") Long idVacina) {
        return VacinaEntity.<VacinaEntity>findByIdOptional(idVacina)
                .map(vacina -> {
                    // PONTO CRÍTICO: Antes de deletar, guarde o animal para poder
                    // recalcular seu status depois que a vacina for removida.
                    // var animalParaAtualizar = vacina.animal;

                    vacina.delete();

                    // Ex: meuServicoDeCalculo.atualizarStatus(animalParaAtualizar);

                    return Response.noContent().build();
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
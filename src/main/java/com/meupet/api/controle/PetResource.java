package com.meupet.api.controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.Operation;

import com.meupet.api.modelo.Pet;

@Path("/pets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Pet", description = "Gerenciamento de pets")
public class PetResource {

    @GET
    @Operation(summary = "Listar todos os pets")
    public List<Pet> listar() {
        return Pet.listAll();
    }

    @POST
    @Transactional
    @Operation(summary = "Criar novo pet")
    public Pet criar(Pet pet) {
        pet.persist();
        return pet;
    }
}

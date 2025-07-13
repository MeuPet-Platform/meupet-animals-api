package com.meupet.api.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/usuarios")
@RegisterRestClient
public interface UsuarioRestClient {

    @GET
    @Path("/{id}")
    Response buscarPorId(@PathParam("id") Long id);
}
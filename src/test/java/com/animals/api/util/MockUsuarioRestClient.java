package com.animals.api.util;

import com.animals.api.client.UsuarioRestClient;
import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * Esta é uma implementação "fake" do nosso UsuarioRestClient.
 * A anotação @Mock e @ApplicationScoped diz ao Quarkus para usar esta classe
 * em vez da implementação real do REST Client durante os testes.
 */
@Mock
@ApplicationScoped
@RestClient
public class MockUsuarioRestClient implements UsuarioRestClient {

    @Override
    public Response buscarPorId(Long id) {
        // Simula o comportamento do serviço de usuários
        if (id.equals(1L)) {
            // Se o ID for 1, o tutor existe. Retorna 200 OK.
            return Response.ok().build();
        }
        if (id.equals(99L)) {
            // Se o ID for 99, o tutor não existe. Retorna 404 Not Found.
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Para qualquer outro caso, retorna Not Found por padrão.
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

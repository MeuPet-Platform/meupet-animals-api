package main.controle;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/hello")
@Tag(name = "Hello", description = "Endpoints de teste")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Hello World", description = "Retorna uma saudação simples")
    public String hello() {
        return "Hello, World!";
    }
}

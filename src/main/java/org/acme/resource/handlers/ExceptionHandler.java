package org.acme.resource.handlers;

import org.acme.domain.QuoteResponseDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.status;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        final var quoteResponse = new QuoteResponseDTO();

        quoteResponse.setErro(e.getMessage());
        quoteResponse.setCode(valueOf(INTERNAL_SERVER_ERROR.getStatusCode()));

        return status(INTERNAL_SERVER_ERROR)
                .entity(quoteResponse)
                .build();
    }
}

package org.acme.resource.config;


import org.acme.domain.QuoteResponseDTO;

import javax.ws.rs.core.Response;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.Response.status;

public abstract class BaseResource {

    protected Response toResponse(final Response.Status status, final Object data) {

        final var quoteResponse = new QuoteResponseDTO();

        quoteResponse.setCode(valueOf(status.getStatusCode()));
        quoteResponse.setData(data);

        return status(status)
                .entity(quoteResponse)
                .build();
    }

}

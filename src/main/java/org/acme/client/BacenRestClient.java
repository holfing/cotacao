package org.acme.client;

import org.acme.domain.RespostaTipoCotacaoDolarDTO;
import org.acme.domain.RespostaTipoMoedaDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("v1/odata")
@RegisterRestClient
@Produces(APPLICATION_JSON)
public interface BacenRestClient {

    @GET
    @Path("/Moedas")
    RespostaTipoMoedaDTO getMoedas();

    @GET
    @Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    RespostaTipoCotacaoDolarDTO getCotacaoDolarDia(@QueryParam("@dataCotacao") String dataCotacao);

    @GET
    @Path("/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)")
    RespostaTipoCotacaoDolarDTO getCotacaoDolarPeriodo(@QueryParam("@dataInicial") String dataInicial,
                                                       @QueryParam("@dataFinalCotacao") String dataFinalCotacao);
}

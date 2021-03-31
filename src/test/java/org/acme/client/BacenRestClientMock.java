package org.acme.client;

import io.quarkus.test.Mock;
import org.acme.domain.RespostaTipoCotacaoDolarDTO;
import org.acme.domain.RespostaTipoMoedaDTO;
import org.acme.domain.TipoCotacaoDolarDTO;
import org.acme.domain.TipoMoedaDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

import static java.util.Collections.singletonList;

@Mock
@RestClient
@ApplicationScoped
public class BacenRestClientMock implements BacenRestClient {

    @Override
    public RespostaTipoMoedaDTO getMoedas() {
        final var resposta = new RespostaTipoMoedaDTO();
        final var tipoMoeda = new TipoMoedaDTO();

        tipoMoeda.setNomeFormatado("Dólar australiano");
        tipoMoeda.setSimbolo("AUD");
        tipoMoeda.setTipoMoeda("B");

        resposta.setValue(singletonList(tipoMoeda));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#Moedas");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoDolarDTO getCotacaoDolarDia(final String dataCotacao) {
        final var resposta = new RespostaTipoCotacaoDolarDTO();
        final var tipoCotacaoDolar = new TipoCotacaoDolarDTO();

        tipoCotacaoDolar.setCotacaoCompra(5D);
        tipoCotacaoDolar.setCotacaoVenda(6D);
        tipoCotacaoDolar.setDataHoraCotacao("2020-11-05 13:09:31.961");

        resposta.setValue(singletonList(tipoCotacaoDolar));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoDolarDia");

        return resposta;
    }

    @Override
    public RespostaTipoCotacaoDolarDTO getCotacaoDolarPeriodo(final String dataInicial, final String dataFinalCotacao) {
        final var resposta = new RespostaTipoCotacaoDolarDTO();
        final var tipoCotacaoDolar = new TipoCotacaoDolarDTO();

        tipoCotacaoDolar.setCotacaoVenda(4D);
        tipoCotacaoDolar.setCotacaoCompra(4D);
        tipoCotacaoDolar.setDataHoraCotacao("2020-01-02 13:11:10.762");

        resposta.setValue(singletonList(tipoCotacaoDolar));
        resposta.setDataContext("https://was-p.bcnet.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata$metadata#_CotacaoDolarPeriodo");

        return resposta;
    }
}

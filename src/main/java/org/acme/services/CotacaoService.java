package org.acme.services;


import io.quarkus.cache.CacheResult;
import org.acme.client.BacenRestClient;
import org.acme.domain.TipoCotacaoDolarDTO;
import org.acme.domain.TipoCotacaoMoedaDTO;
import org.acme.resource.config.LabelCache;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class CotacaoService {

    @Inject
    @RestClient
    BacenRestClient bacenRestClient;

    @CacheResult(cacheName = LabelCache.BACEN_COTACAO_DOLAR_DIA_CACHE)
    public List<TipoCotacaoDolarDTO> findCotacaoDolarDiaByDate(final String date) {
        final var cotacaoDolarDia = bacenRestClient.getCotacaoDolarDia(date);
        return cotacaoDolarDia.getValue();
    }

    @CacheResult(cacheName = LabelCache.BACEN_COTACAO_DOLAR_PERIODO_CACHE)
    public List<TipoCotacaoDolarDTO> findCotacaoDolarPeriodoByDataInicialAndDataFinal(final String dataInicial,
                                                                                      final String dataFinal) {

        final var cotacoes = bacenRestClient.getCotacaoDolarPeriodo(dataInicial, dataFinal);
        return cotacoes.getValue();
    }

}

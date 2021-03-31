package org.acme.services;

import io.quarkus.cache.CacheResult;
import org.acme.client.BacenRestClient;
import org.acme.domain.TipoMoedaDTO;
import org.acme.resource.config.LabelCache;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.NOT_SUPPORTED;

@ApplicationScoped
@Transactional(NOT_SUPPORTED)
public class MoedaService {

    @Inject
    @RestClient
    BacenRestClient bacenRestClient;

    @CacheResult(cacheName = LabelCache.BACEN_MOEDAS_CACHE)
    public List<TipoMoedaDTO> findAll() {
        final var moedas = bacenRestClient.getMoedas();
        return moedas.getValue();
    }

}

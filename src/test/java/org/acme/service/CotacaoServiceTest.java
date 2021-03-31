package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.services.CotacaoService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static java.lang.Double.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class CotacaoServiceTest {

    private final static String DATA_COTACAO = "'11-05-2020'";
    private final static String DATA_INICIAL = "'01-01-2020'";
    private final static String DATA_FINAL = "'02-01-2020'";
    private final static String SIMBOLO_MOEDA = "'AUD'";

    @Inject
    CotacaoService cotacaoService;

    @Test
    void testRetornoFindCotacaoDolarDiaByDate() {

        final var cotacaoDolarDia = cotacaoService.findCotacaoDolarDiaByDate(DATA_COTACAO);

        assertNotNull(cotacaoDolarDia);

        final var cotacaoDolar = cotacaoDolarDia.get(0);

        assertNotNull(cotacaoDolarDia);
        assertNotNull(cotacaoDolar.getDataHoraCotacao());
        assertNotNull(cotacaoDolar.getCotacaoCompra());
        assertNotNull(cotacaoDolar.getCotacaoVenda());

        assertEquals(valueOf(5d), cotacaoDolar.getCotacaoCompra());
        assertEquals(valueOf(6d), cotacaoDolar.getCotacaoVenda());
        assertEquals("2020-11-05 13:09:31.961", cotacaoDolar.getDataHoraCotacao());
    }

    @Test
    void testRetornoFindCotacaoDolarPeriodoByDataInicialAndDataFinal() {
        final var cotacaoDolarPeriodo = cotacaoService.findCotacaoDolarPeriodoByDataInicialAndDataFinal(DATA_INICIAL, DATA_FINAL);

        assertNotNull(cotacaoDolarPeriodo);

        final var cotacao = cotacaoDolarPeriodo.get(0);

        assertNotNull(cotacao);
        assertNotNull(cotacao.getDataHoraCotacao());
        assertNotNull(cotacao.getCotacaoVenda());
        assertNotNull(cotacao.getCotacaoCompra());

        assertEquals(valueOf(4d), cotacao.getCotacaoCompra());
        assertEquals(valueOf(4d), cotacao.getCotacaoVenda());
        assertEquals("2020-01-02 13:11:10.762", cotacao.getDataHoraCotacao());
    }



}

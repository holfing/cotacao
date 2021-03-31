package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.services.MoedaService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class MoedaServiceTest {

    @Inject
    MoedaService moedaService;

    @Test
    void testRetornoFindAllMoedas() {
        final var moedas = moedaService.findAll();

        assertNotNull(moedas);
        assertNotNull(moedas.get(0));
        assertNotNull(moedas.get(0).getSimbolo());
        assertNotNull(moedas.get(0).getTipoMoeda());
        assertNotNull(moedas.get(0).getNomeFormatado());

        assertEquals("AUD", moedas.get(0).getSimbolo());
        assertEquals("B", moedas.get(0).getTipoMoeda());
        assertEquals("Dólar australiano", moedas.get(0).getNomeFormatado());
    }

}

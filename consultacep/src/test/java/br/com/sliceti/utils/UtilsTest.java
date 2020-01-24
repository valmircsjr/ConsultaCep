package br.com.sliceti.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sliceti.entity.Cep;

/**
 * Teste para os metodos utilitários.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {

    private Utils utils = new Utils();

    /* String base para os tests com os dados de um cep */
    String strJsonBase = "{" + "\n" +
                    " \"cep\": \"18035-130\"," + "\n" +
                    " \"logradouro\": \"Rua Antônio Marques Flores\"," + "\n" +
                    " \"complemento\": \"\"," + "\n" +
                    " \"bairro\": \"Centro\"," + "\n" +
                    " \"localidade\": \"Sorocaba\"," + "\n" +
                    " \"uf\": \"SP\"," + "\n" +
                    " \"unidade\": \"\"," + "\n" +
                    " \"ibge\": \"3552205\"," + "\n" +
                    " \"gia\": \"6695\"" + "\n" +
                    "}";

    /**
     * Testa a contrução de um objeto Cep a partir
     * de uma String de Json.
     */
    @Test
    public void fromStrJsonToCepTest() {
        Cep cep = new Cep();
        cep = utils.fromStrJsonToCep(strJsonBase);

        assertEquals(cep.getLocalidade(), "Sorocaba");
    }
    
    /**
     * Testando um Request para o WS da ViaCep
     * com um codigo de cep válido.
     */
    @Test
    public void doRequestGetTest() {
        String strCep = "18035130";
        try {
            Cep cepBase = utils.fromStrJsonToCep(strJsonBase);
            Cep cepExpected = utils.fromStrJsonToCep(utils.doRequestGet(strCep));
            assertEquals(cepBase.getCep(), cepExpected.getCep());
        } catch (IOException ex) {
            fail("Não deve lançar exceção!");
        }
    }
    
    @Test
    public void removeCaracEspStringTest() {
        String strCep = "0!00-00,00";
        String esperada = "0000000";

        strCep = utils.removeCaracEspString(strCep);

        assertEquals(esperada, strCep);
    }
    
    /**
     * Testa a validação da quantidade de digitos do cep.
     */
    @Test
    public void validaCepTest() {
        String strCep = "18035130";
        utils.validaCep(strCep);
    }

    /**
     * Deve lançar uma IllegalArgumentException de cep inválido.
     */
    @Test
    public void validaCepIllegalArgumentExceptionTest() {
        String strcep = "1803513000";

        try {
            utils.validaCep(strcep); 
            fail("Falha. Uma exceção deve ser lançada!");
        } catch (IllegalArgumentException ex) {
            assertEquals("Cep invalido!", ex.getMessage());
        }
    }

}
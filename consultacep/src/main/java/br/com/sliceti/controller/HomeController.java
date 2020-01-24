package br.com.sliceti.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sliceti.entity.Cep;
import br.com.sliceti.utils.Utils;

/**
 * Controller da pagina inical. 
 */
@Controller
public class HomeController {

    private static Utils utils = new Utils();

    private static final String MSG_CEP_INVALIDO = "Cep inválido!";

    /**
     * Pagina inicial
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Buscar no ws os dados do cep 
     * @param strCep String com o cep.
     * @return ModelAndView da pagina home com os dados do cep.
     */
    @GetMapping("/busca")
    public ModelAndView buscaCep(@RequestParam("cep") String strCep) {
        ModelAndView mad = new ModelAndView("home");

        Cep cep = new Cep();
        String json = "";

        try {
            strCep = utils.removeCaracEspString(strCep);
            utils.validaCep(strCep);

            json = utils.doRequestGet(strCep);

            cep = utils.fromStrJsonToCep(json);

            utils.GeneratorPDF(cep.toString());

            mad.addObject("ceps", cep);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            mad.addObject("error", MSG_CEP_INVALIDO);
        } 
        return mad;
    }
}
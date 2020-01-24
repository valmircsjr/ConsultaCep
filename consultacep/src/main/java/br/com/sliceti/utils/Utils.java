package br.com.sliceti.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.google.gson.Gson;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import br.com.sliceti.entity.Cep;

/**
 * Contém utilitários para a mmanipulação de objetos.
 */
public class Utils {

	/**
	 * Converte a string json em um objeto de Cep.
	 * @param json String json com os dados do cep.
	 * @return Obj Cep. 
	 */
	public Cep fromStrJsonToCep(String json) {
		Gson gson = new Gson();
		Cep cep = gson.fromJson(json, Cep.class);
		return cep;
	}

	/**
	 * Gera um pdf com os dados recebidos.
	 * @param data Dados que serão colocados no documento.
	 */
	public void GeneratorPDF(String data) {
		String fileName = "consultacep/src/main/resources/docs/DadosCep.pdf";
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(fileName));
			doc.open();
			Paragraph p = new Paragraph (data);
			p.setAlignment (Element.ALIGN_JUSTIFIED);
			doc.add (p);
		} catch (DocumentException d) {
			System.err.println(d.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		doc.close();
	}

	/**
	 * Realiza a requisição GET para o WS do viacep.com
	 * @param strCep String que representa o cep do local.
	 * @return Corpo da resposta com os dados.
	 * @throws IOException
	 */
	public String doRequestGet(final String strCep) throws IOException {
		HttpClient httpClient = new HttpClient();
		GetMethod httpGet = new GetMethod("http://viacep.com.br/ws/" + strCep + "/json/");
		httpClient.executeMethod(httpGet);
		String responseBody = httpGet.getResponseBodyAsString();
		return responseBody;
	}

	/**
	 * Remoção dos caracteres especiais.
	 * Base regex: https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
	 * @param strCep String com o cep.
	 */
	public String removeCaracEspString(String strCep) {
		strCep = strCep.replaceAll("[^a-zZ-Z0-9]", "");
		return strCep;
	}
	
	/**
	 * validação do cep.
	 * @param strcep String com o cep.
	 */
	public void validaCep(String strcep) {
		if (!strcep.matches("\\d{8}")) {
			throw new IllegalArgumentException("Cep invalido!");
		}
	} 
}
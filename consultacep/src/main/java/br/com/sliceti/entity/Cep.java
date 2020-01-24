package br.com.sliceti.entity;

/**
 * Entidade baseada nos dados do WS do viacep.com
 */
public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;
    private String gia;

    public Cep() {
        cep = "Sem dados";
        logradouro = "Sem dados";
        complemento = "Sem dados";
        bairro = "Sem dados";
        localidade = "Sem dados";
        uf = "Sem dados";
        unidade = "Sem dados";
        ibge = "Sem dados";
        gia = "Sem dados";
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Dados do Cep: " + '\n' +
                "Cep: '" + cep + '\'' + '\n' +
                "Logradouro: '" + logradouro + '\'' + '\n' +
                "Complemento: '" + complemento + '\'' + '\n' +
                "Bairro: '" + bairro + '\'' + '\n' +
                "Localidade: '" + localidade + '\'' + '\n' +
                "Uf: '" + uf + '\'' + '\n' +
                "Unidade: '" + unidade + '\'' + '\n' +
                "Ibge: '" + ibge + '\'' + '\n' +
                "Gia: '" + gia + '\'' ;
    }
}
package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;

import java.util.Optional;

@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    // Construtor padrão explícito
    public Endereco() {
    }

    // Construtor com todos os atributos
    public Endereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
    }

    // Construtor com DadosEndereco
    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    // Getters e Setters
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void atualizarInformacoes(DadosEndereco endereco) {


        Optional.ofNullable(endereco.logradouro()).ifPresent(valor -> this.logradouro = valor);
        Optional.ofNullable(endereco.bairro()).ifPresent(valor -> this.bairro = valor);
        Optional.ofNullable(endereco.cep()).ifPresent(valor -> this.cep = valor);
        Optional.ofNullable(endereco.uf()).ifPresent(valor -> this.uf = valor);
        Optional.ofNullable(endereco.cidade()).ifPresent(valor -> this.cidade = valor);
        Optional.ofNullable(endereco.numero()).ifPresent(valor -> this.numero = valor);
        Optional.ofNullable(endereco.complemento()).ifPresent(valor -> this.complemento = valor);
        }

    }


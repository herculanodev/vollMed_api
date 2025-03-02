package med.voll.api.domain.entities.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
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


package med.voll.api.domain.entities.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.entities.endereco.Endereco;

import java.util.Objects;
import java.util.Optional;

@Table(name = "pacientes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    // Construtor com DadosCadastroPaciente
    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    // Método para atualizar informações com Optional
    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        Optional.ofNullable(dados.nome()).ifPresent(valor -> this.nome = valor);
        Optional.ofNullable(dados.telefone()).ifPresent(valor -> this.telefone = valor);
        Optional.ofNullable(dados.endereco()).ifPresent(this.endereco::atualizarInformacoes);
    }

    public void excluir() {
        this.ativo = false;
    }

}

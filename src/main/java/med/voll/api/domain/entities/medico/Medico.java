package med.voll.api.domain.entities.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.entities.endereco.Endereco;
import med.voll.api.domain.enums.Especialidade;

import java.util.Optional;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo = true;

    // Construtor com DadosCadastroMedico
    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = Especialidade.valueOf(dados.especialidade());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        Optional.ofNullable(dados.nome()).ifPresent(valor -> this.nome = valor);
        Optional.ofNullable(dados.telefone()).ifPresent(valor -> this.telefone = valor);
        Optional.ofNullable(dados.endereco()).ifPresent(this.endereco::atualizarInformacoes);
    }

    public void desativar() {
        this.ativo = false;
    }
}

package med.voll.api.domain.entities.paciente;

import med.voll.api.domain.entities.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String telefone, String cpf, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}

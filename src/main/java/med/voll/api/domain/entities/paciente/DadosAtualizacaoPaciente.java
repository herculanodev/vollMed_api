package med.voll.api.domain.entities.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.entities.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}

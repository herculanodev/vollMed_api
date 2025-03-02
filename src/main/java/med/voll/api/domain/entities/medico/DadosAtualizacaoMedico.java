package med.voll.api.domain.entities.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.entities.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String telefone,

        String nome,

        DadosEndereco endereco) {
}

package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "CRM deve conter entre 4 e 6 dígitos.")
        String crm,

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String telefone,


        @NotBlank
        String especialidade,

        @NotNull
        DadosEndereco endereco
) {
}

package cop.projeto.Model.Turma.DTO;

import jakarta.validation.constraints.NotNull;
import cop.projeto.Model.Turma.*;

public record DadosCadastroTurma(

        @NotNull
        Dias dias,
        @NotNull
        Horario horario,
        @NotNull
        Faixa faixa,
        @NotNull
        Naipe naipe,
        @NotNull
        Modalidade modalidade,
        @NotNull
        Integer quantidadeVagas

) {
}

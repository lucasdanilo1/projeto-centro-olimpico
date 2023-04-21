package cop.projeto.Model.Turma.DTO;

import cop.projeto.Model.Turma.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosTurmaDTO {

    private Dias dias;
    private Horario horario;
    private Faixa faixa;
    private Naipe naipe;
    private Modalidade modalidade;
    private Integer quantidadeVagas = 0;

}

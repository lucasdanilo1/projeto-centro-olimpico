package cop.projeto.Model.Turma.DTO;

import cop.projeto.Model.Aluno.Status;
import cop.projeto.Model.Turma.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroTurmas {

    String nome;
    Status status;
    Modalidade modalidade;
    Horario horario;
    Faixa faixa;
    Dias dias;
    Naipe naipe;

}

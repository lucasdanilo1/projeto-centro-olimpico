package cop.projeto.Model.Aluno.DTO;

import cop.projeto.Model.Aluno.*;
import cop.projeto.Model.Turma.Modalidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroAlunos {

    String nome;
    Etnia etnia;
    Sexo sexo;
    Modalidade modalidade;
    Status status;


}

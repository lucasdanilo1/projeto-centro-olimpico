package cop.projeto.Model.Aluno.DTO;

import cop.projeto.Model.Aluno.Etnia;
import cop.projeto.Model.Aluno.Naturalidade;
import cop.projeto.Model.Aluno.Regiao;
import cop.projeto.Model.Aluno.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class DadosPessoaisParaAtualizacao {

    private String nome;
    private Sexo sexo;
    private Integer anoNascimento;
    private String cpf;
    @NotNull
    private Naturalidade naturalidade;
    @NotNull
    private Etnia etnia;
    private String nomeDaMae;
    private String email;
    private String telefone;
    @NotNull
    private Regiao regiao;
    private String endereco;

}

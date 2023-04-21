package cop.projeto.Model.Aluno.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import cop.projeto.Model.Aluno.Etnia;
import cop.projeto.Model.Aluno.Naturalidade;
import cop.projeto.Model.Aluno.Regiao;
import cop.projeto.Model.Aluno.Sexo;

@Getter
@Setter
public class DadosPessoaisDTO {

    @NotBlank
    private String nome;
    @NotNull
    private Sexo sexo;
    @NotNull
    private Integer anoNascimento;
    @NotBlank
    @CPF(message = "cpf inválido")
    private String cpf;
    @NotNull
    private Naturalidade naturalidade;
    @NotNull
    private Etnia etnia;
    @NotBlank
    private String nomeDaMae;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotNull
    private Regiao regiao;
    @NotBlank
    private String endereco;

}

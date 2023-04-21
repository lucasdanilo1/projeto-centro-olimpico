package cop.projeto.Model.Turma;

import cop.projeto.Model.Turma.DTO.DadosAtualizaTurma;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import cop.projeto.Model.Aluno.Aluno;
import cop.projeto.Model.Turma.DTO.DadosCadastroTurma;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "Turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private DadosTurma dadosTurma;
    @Column
    private StatusTurma status;
    @OneToMany(mappedBy = "turma")
    private List<Aluno> inscritos = new ArrayList<>();
    @Transient
    private List<Aluno> matriculados = new ArrayList<>();
    static private int numeroTurma = 1;


    public Turma(DadosCadastroTurma dados){
        this.nome = String.format("T-%03d", numeroTurma++);
        this.status = StatusTurma.TURMA_ABERTA;
        this.dadosTurma = new DadosTurma(dados);
    }

    //    public static List<Aluno> getMatriculados() {
//        return matriculados;
//    }

    public void atualizaInformacoes(DadosAtualizaTurma dados){
        if(dados.getDadosTurma() != null){
            this.dadosTurma.checaCampos(dados);
        }
    }


    public List<Aluno> getInscritos() {
        return inscritos;
    }

}


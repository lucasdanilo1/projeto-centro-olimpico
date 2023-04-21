package cop.projeto.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cop.projeto.Model.Aluno.Aluno;
import cop.projeto.Model.Aluno.DTO.DadosCadastroAluno;
import cop.projeto.Model.Aluno.Repository.AlunoRepository;
import cop.projeto.Model.Exceptions.AlunoJaCadastradoException;
import cop.projeto.Model.Turma.Repository.TurmaRepository;
import cop.projeto.Model.Turma.Turma;

import java.util.List;

@Controller
@RequestMapping("sigecop")
public class HomeController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping("inicio")
    public String PaginaInicial(){
        return "paginaInicial";
    }

    @GetMapping("formulario")
    public String formulario(DadosCadastroAluno dados, Model model){
        List<Turma> turmas = turmaRepository.findAll();
        model.addAttribute("turmas", turmas);
        return "Inscrito/formulario";
    }

    @Transactional
    @PostMapping("cadastro")
    public String cadastrar(@Valid DadosCadastroAluno dados){
        if(alunoRepository.existsByDadosPessoaisCpf(dados.getDadosPessoais().getCpf())){
            throw new AlunoJaCadastradoException();
        }else {
            Turma turma = turmaRepository.findById(dados.getTurmaId()).orElseThrow(() -> new NullPointerException("Turma não encontrada"));
            Aluno aluno = new Aluno(dados);
            aluno.setTurma(turma);
            alunoRepository.save(aluno);
        }
        return "redirect:/sigecop/inicio";
    }

}

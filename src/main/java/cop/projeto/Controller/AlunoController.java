package cop.projeto.Controller;

import cop.projeto.Model.Aluno.Status;
import cop.projeto.Model.Turma.Turma;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cop.projeto.Model.Aluno.Aluno;
import cop.projeto.Model.Aluno.DTO.DadosAtualizaAluno;
import cop.projeto.Model.Aluno.Repository.AlunoRepository;

@Controller
@RequestMapping("sistema/inscritos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @Transactional
    @PostMapping("/{id}")
    public String atualiza(@PathVariable Long id, Model model, @Valid DadosAtualizaAluno dados){
        Aluno aluno = repository.getReferenceById(id);
        aluno.atualizaInformacoes(dados);
        return "redirect:/sistema/inscritos/" + id;
    }

    @Transactional
    @PostMapping("selecionar/{id}")
    public String seleciona(@PathVariable Long id){
        Aluno aluno = repository.getReferenceById(id);
        aluno.selecionaAluno();
        System.out.println(id);
        return "redirect:/sistema/turmas/" + aluno.getTurma().getId();
    }

    @Transactional
    @PostMapping("inativar/{id}")
    public String InativaAtiva(@PathVariable Long id){
        Aluno aluno = repository.getReferenceById(id);
        if(aluno.getStatusAluno() == Status.INATIVADO){
            aluno.ativaAluno();
        }else{
            aluno.inativaAluno();
        }
        return "redirect:/sistema/listaInscritos";
    }

    @Transactional
    @PostMapping("inativar/emTurma/{id}")
    public String InativaAtivaEmTurma(@PathVariable Long id){
        Aluno aluno = repository.getReferenceById(id);
        Long idTurma = aluno.getTurma().getId();
        if(aluno.getStatusAluno() == Status.INATIVADO){
            aluno.ativaAluno();
        }else{
            aluno.inativaAluno();
        }
        return "redirect:/sistema/turmas/" + idTurma;
    }

    @GetMapping("/{id}")
    public String detalhar(@PathVariable Long id, Model model, DadosAtualizaAluno dados){
        Aluno aluno = repository.getReferenceById(id);
        Turma turma = aluno.getTurma();
        model.addAttribute("aluno", aluno);
        model.addAttribute("turma", turma);
        return "Inscrito/inscrito";
    }


}


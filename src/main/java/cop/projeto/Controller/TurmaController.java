package cop.projeto.Controller;

import cop.projeto.Model.Aluno.Aluno;
import cop.projeto.Model.Aluno.Repository.AlunoRepository;
import cop.projeto.Model.Turma.*;
import cop.projeto.Model.Turma.DTO.DadosAtualizaTurma;
import cop.projeto.Model.Turma.DTO.FiltroTurmas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cop.projeto.Model.Turma.Repository.TurmaRepository;

import java.util.List;

@Controller
@RequestMapping("sistema/turmas")
public class TurmaController {

    @Autowired
    TurmaRepository repository;
    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/{id}")
    public String turmaDetalhada(@PathVariable Long id, Model model, DadosAtualizaTurma dados, FiltroTurmas filtros){
        Turma turma = repository.getReferenceById(id);
        List<Aluno> alunos = alunoRepository.findAllByTurmaId(id);
        model.addAttribute("alunos", alunos);
        model.addAttribute("turma", turma);
        return "Turma/turma";
    }

    @PostMapping("turmafiltrada/{id}")
    public String listaFiltrada(@PathVariable Long id, Model model, FiltroTurmas filtros, DadosAtualizaTurma dados){
        Turma turma = repository.getReferenceById(id);
        List<Aluno> alunos = alunoRepository.findByIdNomeModalidadeStatus(id, filtros.getNome(), turma.getDadosTurma().getModalidade(), filtros.getStatus());
        model.addAttribute("alunos", alunos);
        model.addAttribute("turma", turma);
        return "Turma/turma";
    }

    @Transactional
    @PostMapping("/{id}")
    public String editarTurma(@PathVariable Long id, @Valid DadosAtualizaTurma dados){
        Turma turma = repository.getReferenceById(id);
        turma.atualizaInformacoes(dados);
        return "redirect:/sistema/turmas/" + id;
    }

}

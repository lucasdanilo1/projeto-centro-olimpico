package cop.projeto.Controller;

import cop.projeto.Model.Aluno.Aluno;
import cop.projeto.Model.Aluno.DTO.FiltroAlunos;
import cop.projeto.Model.Aluno.Repository.AlunoRepository;
import cop.projeto.Model.Turma.*;
import cop.projeto.Model.Turma.DTO.DadosCadastroTurma;
import cop.projeto.Model.Turma.DTO.FiltroTurmas;
import cop.projeto.Model.Turma.Repository.TurmaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("sistema")
public class ServidoresController {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    TurmaRepository turmaRepository;

    @GetMapping("listaTurmas")
    public String listaTurma(Model model, DadosCadastroTurma dados, FiltroTurmas filtro) {
        List<Turma> turmas = turmaRepository.findAll();
        model.addAttribute("turmas", turmas);
        return "Turma/listaTurmas";
    }

    @PostMapping("listaTurmas")
    public String listaTurmasFiltrada(Model model, DadosCadastroTurma dados, FiltroTurmas filtros){
        List<Turma> turmas = turmaRepository.findByFiltros(filtros.getModalidade(), filtros.getDias(), filtros.getFaixa(), filtros.getHorario(), filtros.getNaipe());
        model.addAttribute("turmas", turmas);
        return "Turma/listaTurmas";
    }

    @Transactional
    @PostMapping("novaTurma")
    public String cadastrar(@Valid DadosCadastroTurma dados) {
        Turma turma = new Turma(dados);
        turmaRepository.save(turma);
        return "redirect:/sistema/listaTurmas";
    }
    

    @GetMapping("listaInscritos")
    public String listaInscritos(Model model, FiltroAlunos dados) {
        List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
        return "Inscrito/listaInscritos";
    }

    @PostMapping("listaInscritos")
    public String listaInscritosFiltrada(Model model, FiltroAlunos dados){
        List<Aluno> alunos = alunoRepository.findByTodosFiltros(dados.getNome(), dados.getModalidade(), dados.getStatus(), dados.getEtnia(), dados.getSexo());
        model.addAttribute("alunos", alunos);
        return "Inscrito/listaInscritos";
    }

}

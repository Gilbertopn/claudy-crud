package com.claudyjob.person.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.claudyjob.person.entity.Pessoa;
// import com.claudyjob.person.repository.PessoaRepository;
import com.claudyjob.person.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping("/pessoa/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String cadastrar(@RequestBody Pessoa novaPessoa) {
        if(novaPessoa == null){
            return String.format("Não existem Informações para novo aluno.", HttpStatus.BAD_REQUEST);
        }else{
            Pessoa pessoaCad = pessoaService.cadastrar(novaPessoa);
            if(pessoaCad == null || pessoaCad.getId() <= 0){
                return String.format("Não foi possível cadastrar o novo aluno.", HttpStatus.BAD_GATEWAY);
            }
            return String.format("Novo aluno cadastrado.", HttpStatus.CREATED);
        }
    }

    @GetMapping("/pessoa/all")
    public List<Pessoa> listarAlunos() {
        return pessoaService.listar();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa buscarPorId(@PathVariable Long idPessoa) {
        var aluno = pessoaService.buscarPorId(idPessoa);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno  não encontrado para o id informado.");
        }
        return (Pessoa) aluno;
    }

    @DeleteMapping("/pessoa/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirAlunoPorId(@PathVariable Long id) {
       pessoaService.excluirPorId(id);
    }

    @PutMapping("/pessoa/{id}")
    public Pessoa atualizarAlunoPorId(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        var alunoAtualizado = pessoaService.atualizarPorId(id, pessoa);
        if (alunoAtualizado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return alunoAtualizado;

    }
}
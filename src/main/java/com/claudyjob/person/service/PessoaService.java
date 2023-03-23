package com.claudyjob.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.claudyjob.person.entity.Pessoa;
import com.claudyjob.person.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa cadastrar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        var aluno = pessoaRepository.findById(id);
        if (aluno.isEmpty()) {
            return null;
        }
        return aluno.get();
    }

    public void excluirPorId(Long id) {
        var pessoa = pessoaRepository.findById(id);
        if (pessoa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cadastro do aluno não encontrado.");
        }
        pessoaRepository.delete(pessoa.get());
        throw new ResponseStatusException(HttpStatus.OK,"Cadastro do aluno removido.");
    }

    public Pessoa atualizarPorId(Long id,Pessoa pessoa) {
        var pessoaAtualizado = pessoaRepository.findById(id);
        if (pessoaAtualizado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro do aluno não encontrado.");
        }
        pessoa.setId(id);
        return pessoaRepository.save(pessoa);
    }

    
}
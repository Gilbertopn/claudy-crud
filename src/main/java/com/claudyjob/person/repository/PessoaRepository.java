package com.claudyjob.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.claudyjob.person.entity.*;



public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}



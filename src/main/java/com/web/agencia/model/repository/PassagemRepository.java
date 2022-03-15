package com.web.agencia.model.repository;

import com.web.agencia.model.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

    List<Passagem> findByCpfPassageiro(String cpf);
}

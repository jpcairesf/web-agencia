package com.web.agencia.model.repository;

import com.web.agencia.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {

    List<Voo> findByData(LocalDate data);
}

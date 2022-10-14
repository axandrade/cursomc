package com.alex.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.cursomc.dominio.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}

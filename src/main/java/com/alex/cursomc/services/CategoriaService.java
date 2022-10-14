package com.alex.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.cursomc.dominio.Categoria;
import com.alex.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		
		Categoria obj = categoriaRepository.findById(id).get();
		
		return obj;
	}

}

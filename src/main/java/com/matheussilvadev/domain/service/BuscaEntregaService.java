package com.matheussilvadev.domain.service;

import org.springframework.stereotype.Service;

import com.matheussilvadev.domain.exception.EntidadeNaoEncontradaException;
import com.matheussilvadev.domain.model.Entrega;
import com.matheussilvadev.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	

	EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository
				.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

}

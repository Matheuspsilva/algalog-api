package com.matheussilvadev.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheussilvadev.domain.exception.NegocioException;
import com.matheussilvadev.domain.model.Entrega;
import com.matheussilvadev.domain.model.StatusEntrega;
import com.matheussilvadev.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	
	}

}

package com.matheussilvadev.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matheussilvadev.domain.model.Cliente;
import com.matheussilvadev.domain.repository.ClienteRepository;
import com.matheussilvadev.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	//Não é necessário usar autowired pois é feita injeção de dependência pelo método construtor
	private ClienteRepository clienteRepository;
	
	private CatalogoClienteService catalogoClienteService;
	
	@GetMapping()
	public List<Cliente> listarclientes() {
		
		return clienteRepository.findAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		
		return catalogoClienteService.salvar(cliente);
	}
	
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> listarCliente(@PathVariable Long clienteId) {
		
		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
//		
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizarCliente(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(clienteId)) {
			ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = catalogoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
	
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long clienteId) {
		
		if(!clienteRepository.existsById(clienteId)) {
			ResponseEntity.notFound().build();
		}
	
		catalogoClienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();
	
	}

}

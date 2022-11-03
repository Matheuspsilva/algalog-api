package com.matheussilvadev.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheussilvadev.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNome("Joao1");
		cliente.setTelefone("999999999");
		cliente.setEmail("joao@email.com");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("989999999");
		cliente2.setEmail("maria@email.com");
		
		return Arrays.asList(cliente, cliente2);
	}

}

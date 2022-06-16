package com.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.entity.Cliente;
import com.enterprise.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	
	public List<Cliente> listaClientes() {
		return repositorio.findAll();
	}

	public Cliente clienteById(Long id) {
		return repositorio.findById(id).get();
	}

	public Cliente guardarCliente(Cliente cliente) {
		return repositorio.save(cliente);
	}

	public Cliente actualizarCliente(Cliente cliente) {
		return repositorio.saveAndFlush(cliente);
	}

	public void eliminaCliente(Long id) {
		repositorio.deleteById(id);
	}

}

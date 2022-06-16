package com.enterprise.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.entity.Cliente;
import com.enterprise.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;

	@GetMapping({"/clientes","/"})
	public ResponseEntity<List<Cliente>> listaClientes(){
		List<Cliente> list = new ArrayList<Cliente>();
		list = servicio.listaClientes();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> agregarCliente(@RequestBody final Cliente cliente) {
		Cliente usuarioCliente = new Cliente();
		usuarioCliente = servicio.guardarCliente(cliente);
		return new ResponseEntity(usuarioCliente, HttpStatus.CREATED);
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> clientePorId(@PathVariable("id") Long id) {
		Cliente cliente = new Cliente();
		cliente = servicio.clienteById(id);
		return new ResponseEntity(cliente, HttpStatus.OK);
	}
	
	@PutMapping(value="/clientes/{id}")
	public ResponseEntity<Cliente> actualizaCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteExistente = new Cliente();
		clienteExistente = servicio.clienteById(id);
		clienteExistente.setNombre(cliente.getNombre());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setTelefono(cliente.getTelefono());
		
		servicio.guardarCliente(clienteExistente);

		return new ResponseEntity(clienteExistente, HttpStatus.OK);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Cliente> eliminaCliente(@PathVariable("id") Long id){
		servicio.eliminaCliente(id);
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}

}

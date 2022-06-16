package com.enterprise.service;

import java.util.List;
import com.enterprise.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> listaClientes();
	
	public Cliente clienteById(Long id);
	
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente actualizarCliente(Cliente cliente);
	
	public void eliminaCliente(Long id);

}

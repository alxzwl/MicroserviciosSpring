package com.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{ 
}

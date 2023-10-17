package com.example.frontendcliconsi.repository;

import com.example.frontendcliconsi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Query(value = "select * from selectclientes()", nativeQuery = true)
    List<Cliente> getAll();

    @Query(value = "select * from insertclientes(:activo,:nombre, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)", nativeQuery = true)
    Object saveCliente(@Param("activo") String activo,@Param("nombre") String name);
}

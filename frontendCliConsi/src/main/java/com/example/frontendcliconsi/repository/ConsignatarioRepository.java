package com.example.frontendcliconsi.repository;

import com.example.frontendcliconsi.entity.Cliente;
import com.example.frontendcliconsi.entity.Consignatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsignatarioRepository extends JpaRepository<Consignatario, Integer> {
    @Query(value = "select * from selectconsignatario()", nativeQuery = true)
    List<Consignatario> getAll();

    @Query(value = "select * from insertconsignatario(:clienteid,:consignatarioid,:consignatarioactivo,:consignatarionombre, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)", nativeQuery = true)
    Object saveConsignatario(@Param("consignatarioid") Integer consignatarioid,
                             @Param("clienteid") Integer clienteid,
                             @Param("consignatarioactivo") String consignatarioactivo,
                             @Param("consignatarionombre") String consignatarionombre);
}

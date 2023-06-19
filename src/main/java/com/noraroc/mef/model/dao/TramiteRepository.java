package com.noraroc.mef.model.dao;

import com.noraroc.mef.model.entity.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface TramiteRepository extends JpaRepository<Tramite, Long> {

    @Query(value = "SELECT * FROM Tramite " +
            "WHERE ((id = :id OR :id IS NULL)" +
            " AND (LOWER(codigo) LIKE LOWER(CONCAT('%', :codigo, '%')) OR :codigo IS NULL)" +
            " AND (LOWER(nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) OR :nombre IS NULL)" +
            " AND (LOWER(numero_comprobante) LIKE LOWER(CONCAT('%', :numeroComprobante, '%')) OR :numeroComprobante IS NULL)" +
            " AND (LOWER(resumen) LIKE LOWER(CONCAT('%', :resumen, '%')) OR :resumen IS NULL)" +
            " AND (monto = :monto OR :monto IS NULL))" ,
            nativeQuery = true)
    List<Tramite> buscarPorParametros(@Param("id") Long id,
                                      @Param("codigo") String codigo,
                                      @Param("nombre") String nombre,
                                      @Param("numeroComprobante") String numeroComprobante,
                                      @Param("resumen") String resumen,
                                      @Param("monto") Double monto
                                    );
}





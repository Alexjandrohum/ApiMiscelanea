/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMiscelanea.ApiMiscelanea.dao;

import ApiMiscelanea.ApiMiscelanea.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alexjandrohum
 */
public interface ProductoDao extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT p.id_producto, p.estado, p.fecha_creado, p.fecha_modificado, p.nombre_producto, p.precio FROM producto p WHERE p.estado = 'activo'", nativeQuery = true)
    List<Producto> obtenerProductos();

}

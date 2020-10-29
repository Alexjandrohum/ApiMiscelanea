/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMiscelanea.ApiMiscelanea.dao;

import ApiMiscelanea.ApiMiscelanea.model.Producto;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author alexjandrohum
 */
public interface ProductoDao extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT p.id_producto, p.estado, p.fecha_creado, p.fecha_modificado, p.nombre_producto, p.precio FROM producto p WHERE p.estado = 'activo'", nativeQuery = true)
    List<Producto> obtenerProductos();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto(id_producto, estado, fecha_creado, fecha_modificado, nombre_producto, precio) VALUES (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    void createProduct(int idProducto, String estado, Date fechaCreado, Date fechaModificado, String nombreProducto, float precio);

    @Modifying
    @Transactional
    @Query(value = "insert into producto (id_producto, estado, fecha_creado, fecha_modificado, nombre_producto, precio) "
            + "VALUES (:#{#p.idProducto},:#{#p.estado},  :#{#p.fechaCreado} ,:#{#p.fechaModificado}, :#{#p.nombreProducto}, :#{#p.precio} )", nativeQuery = true)
    void createProduct2(@Param("p") Producto p);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto p set p.estado='desactivado' WHERE p.id_producto=?1", nativeQuery = true)
    void deleteProduct(int id_producto);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE producto p set p.nombre_producto=?1, p.precio=?2, p.fecha_modificado=?3 WHERE p.id_producto=?4", nativeQuery = true)
    void updateProduct(String nombre, float precio, Date modificacion, int id);
    
    @Query(value = "SELECT p.id_producto, p.estado, p.fecha_creado, p.fecha_modificado, p.nombre_producto, p.precio FROM producto p WHERE p.id_producto =?1", nativeQuery = true)
    Producto findProduct(int id);

}

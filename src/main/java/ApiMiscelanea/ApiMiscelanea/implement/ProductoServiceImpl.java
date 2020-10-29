/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMiscelanea.ApiMiscelanea.implement;

import ApiMiscelanea.ApiMiscelanea.dao.ProductoDao;
import ApiMiscelanea.ApiMiscelanea.model.Producto;
import ApiMiscelanea.ApiMiscelanea.service.ProductoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexjandrohum
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> listProduct() {
        return productoDao.obtenerProductos();
    }

    @Override
    public Producto createProduct(Producto producto) {
        producto.setFechaCreado(new Date());
        producto.setFechaModificado(new Date());
        producto.setEstado("activo");
        return productoDao.save(producto);
    }

    @Override
    public void updateProduct(String nombre, float precio, int id) {
        productoDao.updateProduct(nombre, precio, new Date(), id);
    }

    @Override
    public Producto findProduct(int id) {
        return productoDao.findProduct(id);
    }

    @Override
    public void deleteProduct(int id) {

        productoDao.deleteProduct(id);
    }

}

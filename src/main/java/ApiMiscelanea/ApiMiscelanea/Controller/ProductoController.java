/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMiscelanea.ApiMiscelanea.Controller;

import ApiMiscelanea.ApiMiscelanea.dao.ProductoDao;
import ApiMiscelanea.ApiMiscelanea.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author alexjandrohum
 */
@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoDao productoDao;

    @GetMapping("/listarProductos")
    public List<Producto> listarProductos() {
        return productoDao.obtenerProductos();
    }

    @PostMapping("/crearProducto")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoDao.save(producto);
    }

}

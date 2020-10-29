/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMiscelanea.ApiMiscelanea.Controller;

import ApiMiscelanea.ApiMiscelanea.model.Producto;
import ApiMiscelanea.ApiMiscelanea.service.ProductoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author alexjandrohum
 */
@RestController
@RequestMapping("productos")
@Slf4j
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listarProductos")
    public List<Producto> listarProductos() {
        return productoService.listProduct();
    }

    @PostMapping("/crearProducto")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.createProduct(producto);
    }

    @GetMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productoService.deleteProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Producto producto) {
        productoService.updateProduct(producto.getNombreProducto(), producto.getPrecio(), id);
    }

    @GetMapping("/findProduct/{id}")
    public Producto findProduct(@PathVariable("id") int id) {

        return productoService.findProduct(id);

    }

}

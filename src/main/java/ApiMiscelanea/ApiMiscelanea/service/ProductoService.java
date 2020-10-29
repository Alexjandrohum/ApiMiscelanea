/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiMiscelanea.ApiMiscelanea.service;

import ApiMiscelanea.ApiMiscelanea.model.Producto;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface ProductoService {
    
    List<Producto> listProduct();
    
    Producto createProduct(Producto producto);
        
    void updateProduct(String nombre, float precio, int id);
    
    void deleteProduct(int id);
    
    Producto findProduct(int id);
    
}

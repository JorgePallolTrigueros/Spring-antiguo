/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Product;
import com.pallol.novela.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CASA PALLOL
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Product> muestraProducto() {
        List<Product> lstProducto = productoRepository.findAll();
        return lstProducto;
    }

    public Product muestraproductoConDetallesPorId(Integer productoId) {
        Product producto = null;
        try {
            producto = productoRepository.getOne(productoId);
        } catch (Exception ex) {

        }
        if (producto != null) {

        }
        return producto;
    }

    public Product creaOActualizaProducto(Product producto) {
        return productoRepository.save(producto);
    }

    public void eliminaProducto(Product producto) {
        productoRepository.delete(producto);
    }



}

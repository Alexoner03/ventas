package com.aortiz.ventas.controllers;

import com.aortiz.ventas.models.Producto;
import com.aortiz.ventas.models.Venta;
import com.aortiz.ventas.services.contracts.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String index(Model model) {

        List<Producto> productos = productoService.listar();
        model.addAttribute("productos", productos);

        return "productos/index";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/create";
    }

    @PostMapping("/store")
    public String guardar(Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/{idproducto}/editar")
    public String editar(@PathVariable("idproducto") Long idproducto, Model model) {
        Producto producto = productoService.buscar(idproducto);
        model.addAttribute("producto", producto);
        return "productos/edit";
    }

}

package com.aortiz.ventas.controllers;

import com.aortiz.ventas.models.DetalleVenta;
import com.aortiz.ventas.models.Venta;
import com.aortiz.ventas.services.contracts.ProductoService;
import com.aortiz.ventas.services.contracts.VentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller()
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String index(Model model) {

        List<Venta> ventas = ventaService.listar();
        model.addAttribute("ventas", ventas);

        return "ventas/index";
    }

    @GetMapping("/crear")
    public String create(Model model) {
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("venta", new Venta());
        return "ventas/create";
    }


    @PostMapping("/guardar")
    public String guardar(@Valid Venta venta, Errors errors) {

        if(errors.hasErrors()){
            return "redirect:/ventas/crear";
        }

        ventaService.guardar(venta);

        return "redirect:/ventas";
    }

    @GetMapping(value = "/{idventa}/detalles", produces = "application/json")
    @ResponseBody
    public List<DetalleVenta> detalles(@PathVariable("idventa") Long idventa){
        return ventaService.detalleById(idventa);
    }

}

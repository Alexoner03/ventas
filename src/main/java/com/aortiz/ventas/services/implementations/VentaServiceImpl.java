package com.aortiz.ventas.services.implementations;

import com.aortiz.ventas.dao.DetalleVentaDAO;
import com.aortiz.ventas.dao.ProductoDAO;
import com.aortiz.ventas.dao.UsuarioDAO;
import com.aortiz.ventas.dao.VentaDAO;
import com.aortiz.ventas.models.*;
import com.aortiz.ventas.services.contracts.AuthHelper;
import com.aortiz.ventas.services.contracts.VentaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaDAO ventaDAO;

    @Autowired
    private DetalleVentaDAO detalleVentaDAO;

    @Autowired
    private ProductoDAO productoDAO;

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listar() {
        return ventaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Venta venta) {
        int total = 0;
        Usuario seller = usuarioDAO.findById(authHelper.getID()).orElse(null);
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        venta.setUsuario(seller);
        venta.setFecha(date);

        for (DetalleVenta detalle : venta.getDetalle()) {
            total += detalle.getPrecio() * detalle.getCantidad();
        }

        venta.setTotal(total);
        Venta ventaSaved = ventaDAO.save(venta);

        for (DetalleVenta detalle : ventaSaved.getDetalle()) {
            detalle.setId(new DetalleVentaKey());
            detalle.setVenta(ventaSaved);
            detalleVentaDAO.save(detalle);
            restarExistencias(detalle.getProducto(),detalle.getCantidad());
        }

    }

    @Override
    public List<DetalleVenta> detalleById(Long id) {
        return Objects.requireNonNull(ventaDAO.findById(id).orElse(null)).getDetalle();
    }

    private void restarExistencias(@NotNull Producto p, int cantidad) {
        Producto producto = productoDAO.findById(p.getId()).orElse(null);
        assert producto != null;
        producto.setStock( producto.getStock() - cantidad);
        productoDAO.save(producto);
    }
}

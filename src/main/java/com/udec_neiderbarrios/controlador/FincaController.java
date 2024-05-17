package com.udec_neiderbarrios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.udec_neiderbarrios.modelo.Finca;
import com.udec_neiderbarrios.service.FincaService;

import java.util.List;

@Controller
@RequestMapping("/finca")
public class FincaController {

    private final FincaService fincaService;


    public FincaController(FincaService fincaService) {
        this.fincaService = fincaService;
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("finca", new Finca());
        // Aquí puedes agregar lógica para pasar cualquier otro dato necesario al formulario
        return "Finca/agregar";
    }

    @PostMapping("/agregar")
    public String agregarFinca(@ModelAttribute("finca") Finca finca) {
        fincaService.guardarFinca(finca);
        return "redirect:/finca/agregar";
    }

    @GetMapping("/listar")
    public String listarFincas(Model model) {
        List<Finca> fincas = fincaService.obtenerTodasFincas();
        model.addAttribute("fincas", fincas);
        return "Finca/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Finca finca = fincaService.obtenerFincaPorId(id);
        if (finca != null) {
            model.addAttribute("finca", finca);
            // Aquí puedes agregar lógica para pasar cualquier otro dato necesario al formulario
            return "Finca/editar";
        }
        return "redirect:/finca/listar";
    }

    @PostMapping("/editar")
    public String editarFinca(@ModelAttribute("finca") Finca finca) {
        fincaService.actualizarFinca(finca);
        return "redirect:/finca/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFinca(@PathVariable("id") Integer id) {
        fincaService.eliminarFinca(id);
        return "redirect:/finca/listar";
    }
}

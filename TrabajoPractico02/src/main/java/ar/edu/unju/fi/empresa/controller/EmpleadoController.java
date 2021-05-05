package ar.edu.unju.fi.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.empresa.model.Empleado;
import ar.edu.unju.fi.empresa.service.IEmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	IEmpleadoService empleadoService;
	
	@GetMapping("/empleado/nuevo")
	public String getEmpleadoFormPage(Model model) {
		model.addAttribute("empleado", empleadoService.getEmpleado());
		return "nuevo-empleado";
	}
	
	@PostMapping("/empleado/guardar")
	public String getEmpleadoResultPage(@ModelAttribute("empleado") Empleado unEmpleado) {
		empleadoService.addEmpleado(unEmpleado);
		return "resultado-empleado";
	}
	
	@GetMapping("/empleado/ultimo")
	public ModelAndView getUltimoEmpleadoPage() {
		ModelAndView modelView = new ModelAndView("ultimo-empleado");
		
		modelView.addObject("empleado", empleadoService.getUltimoEmpleado());
		return modelView;
	}
	
	@GetMapping("/empleado/listar")
	public String getEmpleadosPage(Model model) {
		model.addAttribute("empleados", empleadoService.getAllEmpleados());
		return "lista-empleado";
	}
	
}

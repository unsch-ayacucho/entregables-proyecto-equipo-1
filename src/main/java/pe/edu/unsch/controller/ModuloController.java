package pe.edu.unsch.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unsch.entities.Modulo;
import pe.edu.unsch.service.ModuloService;
import pe.edu.unsch.util.DataTablesParam;
import pe.edu.unsch.util.DataTablesParamUtility;
import pe.edu.unsch.util.JsonResponse;
import pe.edu.unsch.util.ManagerDatatables;

@Controller
@RequestMapping("/admin")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	private JsonResponse jsonResponse;

	@GetMapping("/modulo")
	public String mainGet(Model model) {
		model.addAttribute("Titulo", "Modulo | Nombramiento Docente");
		return "views/admin/modulo/index";
	}

	@GetMapping("/modulosJSON")
	@ResponseBody
	public ManagerDatatables obtenerModulosJSON(HttpServletRequest request, HttpServletResponse response) {
		return obtenerModuloDatatables(request, response);
	}

	private ManagerDatatables obtenerModuloDatatables(HttpServletRequest request, HttpServletResponse response) {
		
		ManagerDatatables managerDatatables = new ManagerDatatables();
		DataTablesParam datatablesParam = DataTablesParamUtility.getParam(request);
		List<Modulo> modulos = moduloService.encontrarTodo();
		
		managerDatatables.setiTotalRecords(0);
		
		for (int i = 0; i <= modulos.size() - 1; ++i) {
			Modulo p = modulos.get(i);
			if (String.valueOf(p.getIdmodulo()).toLowerCase().contains(datatablesParam.sSearch.toLowerCase())
					|| p.getNombre().toLowerCase().contains(datatablesParam.sSearch.toLowerCase())
					|| p.getEstado().toString().toLowerCase().contains(datatablesParam.sSearch.toLowerCase())) {
			} else {
				modulos.remove(i);
				i = i - 1;
			}
		}
		
		final int sortColumnIndex = datatablesParam.iSortColumnIndex;
	
		
		final int sortDireccion = datatablesParam.sSortDirection.equals("desc") ? -1 : 1;
		
		
		Collections.sort(modulos, new Comparator<Modulo>() {
			
			@Override
			public int compare(Modulo o1, Modulo o2) {
				switch (sortColumnIndex) {
				case 0:
							
					return ((Integer) o1.getIdmodulo()).compareTo(o2.getIdmodulo()) * sortDireccion;

				case 1:
					return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase()) * sortDireccion;
				case 2:
					return o1.getEstado().toString().toLowerCase().compareTo(o2.getEstado().toString().toLowerCase()) * sortDireccion;
				}
				
				return 0;
			}
		});
		
		managerDatatables.setiTotalDisplayRecords(modulos.size());
		
		if(modulos.size() < datatablesParam.iDisplayStart + datatablesParam.iDisplayLength) {
			modulos = modulos.subList(datatablesParam.iDisplayStart, modulos.size());
		} else {
			modulos = modulos.subList(datatablesParam.iDisplayStart, datatablesParam.iDisplayStart + datatablesParam.iDisplayLength);
		}
		
		managerDatatables.setsEcho(datatablesParam.sEcho);
		managerDatatables.setAaData(modulos);
		
		return managerDatatables;
	}
	
	public JsonResponse registrarModulo(@RequestBody Modulo modulo) {
		try {
			moduloService.insertar(modulo);
			jsonResponse = new JsonResponse();
			jsonResponse.respuestaInsertar();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return jsonResponse;
	}
}

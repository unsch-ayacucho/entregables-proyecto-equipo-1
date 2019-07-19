package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.entities.Submodulo;

public interface SubModuloService {
	public List<Submodulo> listarPorPerfil(String usuario);
}

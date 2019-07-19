package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.entities.Modulo;

public interface ModuloService {
	public List<Modulo> listarPorPerfil(String usuario);
	public List<Modulo> encontrarTodo();
	public void insertar(Modulo modulo);
}

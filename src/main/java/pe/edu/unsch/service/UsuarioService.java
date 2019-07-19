package pe.edu.unsch.service;

import pe.edu.unsch.entities.Usuario;

public interface UsuarioService {
	public Usuario login(String usuario, String password);
}

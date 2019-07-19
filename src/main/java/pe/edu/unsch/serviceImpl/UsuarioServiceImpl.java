package pe.edu.unsch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.UsuarioDao;
import pe.edu.unsch.entities.Usuario;
import pe.edu.unsch.service.UsuarioService;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario login(String usuario, String password) {
		// TODO Auto-generated method stub
		return usuarioDao.login(usuario, password);
	}

}

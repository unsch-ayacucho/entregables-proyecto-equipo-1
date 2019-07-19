package pe.edu.unsch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.ModuloDao;
import pe.edu.unsch.entities.Modulo;
import pe.edu.unsch.service.ModuloService;

@Service("moduloService")
@Transactional
public class ModuloServiceImpl implements ModuloService{

	@Autowired
	private ModuloDao moduloDao;

	@Override
	public List<Modulo> listarPorPerfil(String usuario) {
		// TODO Auto-generated method stub
		return moduloDao.listarPorPerfil(usuario);
	}

	@Override
	public List<Modulo> encontrarTodo() {
		// TODO Auto-generated method stub
		return moduloDao.encontrarTodo();
	}

	@Override
	public void insertar(Modulo modulo) {
		// TODO Auto-generated method stub
		moduloDao.insertar(modulo);
	}
	
	
}

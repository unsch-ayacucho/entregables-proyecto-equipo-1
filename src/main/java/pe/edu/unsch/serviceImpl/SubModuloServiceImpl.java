package pe.edu.unsch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.SubModuloDao;
import pe.edu.unsch.entities.Submodulo;
import pe.edu.unsch.service.SubModuloService;

@Service("subModuloService")
@Transactional
public class SubModuloServiceImpl implements SubModuloService {

	@Autowired
	private SubModuloDao subModuloDao;
	
	@Override
	public List<Submodulo> listarPorPerfil(String usuario) {
		// TODO Auto-generated method stub
		return subModuloDao.listarPorPerfil(usuario);
	}
	
}

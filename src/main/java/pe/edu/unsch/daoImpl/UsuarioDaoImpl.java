package pe.edu.unsch.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.dao.UsuarioDao;
import pe.edu.unsch.entities.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Usuario login(String usuario, String password) {
		// TODO Auto-generated method stub
		return (Usuario) entityManager.createQuery("from Usuario where usuario = :usuario and password = :password")
				.setParameter("usuario", usuario)
				.setParameter("password", password)
				.getSingleResult();
	}

}

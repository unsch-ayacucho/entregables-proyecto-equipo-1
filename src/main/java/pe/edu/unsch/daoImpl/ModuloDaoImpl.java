package pe.edu.unsch.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.dao.ModuloDao;
import pe.edu.unsch.entities.Modulo;

@Repository("moduloDao")
public class ModuloDaoImpl implements ModuloDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Modulo> listarPorPerfil(String usuario) {
		// TODO Auto-generated method stub
		return (List<Modulo>) entityManager.createQuery("select new Modulo(m.idmodulo as idmodulo, m.nombre as nombre, m.icono as icono)"
				+ " from PerfilOpcion po"
				+ " inner join po.opcion o"
				+ " inner join o.submodulo s"
				+ " inner join s.modulo m"
				+ " where po.perfil = some(select p.idperfil from Perfil as p"
				+ " inner join p.usuarioPerfils up"
				+ " inner join up.usuario u"
				+ " where u.nombre = :usuario)"
				+ " group by m.idmodulo", Modulo.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}

	@Override
	public List<Modulo> encontrarTodo() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select new Modulo(m.idmodulo as idmodulo, m.nombre as nombre, m.icono as icono, m.estado as estado) from Modulo m", Modulo.class).getResultList();
	}

	@Override
	public void insertar(Modulo modulo) {
		// TODO Auto-generated method stub
		entityManager.persist(modulo);
	}
	
	
	
}

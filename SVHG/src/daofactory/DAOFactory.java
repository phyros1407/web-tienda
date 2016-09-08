package daofactory;

import dao.interfaces.EmpresaDao;
import dao.interfaces.PedidoDao;
import dao.interfaces.PersonaDao;
import dao.interfaces.ProductoDao;
import dao.interfaces.ProveedorDao;
import dao.interfaces.UsuarioDao;

public abstract class DAOFactory {
	
	public static final int MYSQL=1;
	public static final int SQLSERVER=2;
	public static final int ORACLE=3;
	
	
	public abstract ProveedorDao getProveedorDao();
	public abstract ProductoDao getProductoDao();
	public abstract UsuarioDao getUsuarioDao();
	public abstract EmpresaDao getEmpresaDAO(); 
	public abstract PedidoDao getPedidoDAO();
	public static DAOFactory getDaoFactory(int factory){
		
		switch (factory) {
		case MYSQL:
			return new MySqlDAOFactory();
		

		default:
			return null;
		}
		
	}
	// usuario
			public abstract PersonaDao getPersonaDAO(); 	
			public static DAOFactory getDaoFactory1(int factory){
				switch(factory){
				case MYSQL:
					return new MySqlDAOFactory();
				default:
					return null;
				}
			}
			
			
	
}

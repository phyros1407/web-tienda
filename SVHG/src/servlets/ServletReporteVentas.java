package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.CategoriaBean;
import beans.DetalleTransaccionBean;
import beans.PersonaBean;
import beans.ProductoBean;
import dao.interfaces.DetalleTransaccionDao;
import dao.interfaces.PersonaDao;
import dao.interfaces.ProductoDao;
import daofactory.DAOFactory;
import util.ResponseObject;

/**
 * Servlet implementation class ServletReporteVentas
 */
@WebServlet("/ServletReporteVentas")
public class ServletReporteVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReporteVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("ServletServletReporteVentas get");
		DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		ProductoDao productodao = dao.getProductoDao();

			try {
				
				ArrayList<ProductoBean> productos = new ArrayList<ProductoBean>();
				productos = productodao.listarTodos();
				request.setAttribute("productos", productos);
				getServletContext().getRequestDispatcher("/reporteVentas.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion=request.getParameter("accion");
		
		if(accion.equals("reporte1")){		
			try {
				DetalleTransaccionBean detalleTransaccion = new DetalleTransaccionBean();
				DAOFactory dao= DAOFactory.getDaoFactory(DAOFactory.MYSQL);
				DetalleTransaccionDao idetalleTransacciondao = dao.geDetalleTransaccionDao();
				
				String anio=request.getParameter("anio");
				int idProducto=Integer.parseInt(request.getParameter("producto"));
				System.out.println("idProducto: "+idProducto);
			
				ArrayList<DetalleTransaccionBean> listaDetalleTransaccion = idetalleTransacciondao.listarReporte1(anio, idProducto) ;
				
				ResponseObject responseobj=null;
				if(listaDetalleTransaccion!=null){
					responseobj=new ResponseObject();
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					responseobj.setSuccess(true);
					responseobj.setObject(listaDetalleTransaccion);
				}
				response.getWriter().write(new Gson().toJson(responseobj));
				System.out.println("json" + new Gson().toJson(responseobj));
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}

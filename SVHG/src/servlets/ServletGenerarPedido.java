package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletGenerarPedido
 */
@WebServlet("/ServletGenerarPedido")
public class ServletGenerarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGenerarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//USUARIO
		int id = Integer.parseInt(request.getParameter("usuario_generar_pedido"));

		//ARRAYS DE LOS PRODUCTOS SELECCIONADOS
		String ids [] = request.getParameterValues("productosIds");
		String cantidades [] = request.getParameterValues("productosCantidad");
		String importes [] = request.getParameterValues("productosImporte");
		
		
		String tipo_entrega = request.getParameter("tipo_entrega_pedido");
		String fecha = request.getParameter("fecha_generar_pedido");
		
		
		String facturacion = request.getParameter("facturacion_generar_pedido");
		String ruc = request.getParameter("ruc_entrega_pedido");
		String rus = request.getParameter("rs_entrega_pedido");
		
		String departamento = request.getParameter("departamento_entrega_pedido");
		String provincia = request.getParameter("provincia_entrega_pedido");
		String distrito = request.getParameter("distrito_entrega_pedido");
		String direccion = request.getParameter("distrito_entrega_pedido");
		String referencia = request.getParameter("referencia_entrega_pedido");
		String telefono = request.getParameter("telefono_entrega_pedido");
		String telefono2 = request.getParameter("telefono_entrega_pedido2");
		
		int cuotas = Integer.parseInt(request.getParameter("cuotas_entrega_pedido"));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

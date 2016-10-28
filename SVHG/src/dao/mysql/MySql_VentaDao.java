package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.BoletaBean;
import beans.ComprobanteBean;
import beans.TransaccionBean;
import dao.interfaces.VentaDao;
import daofactory.MySqlDAOFactory;

public class MySql_VentaDao extends MySqlDAOFactory implements VentaDao {

	@Override
	public boolean registrarVenta(int idUsuario, String numeroTran,
			String fechaEntrega, String[] productoId, int[] productoCantidad,
			double[] productoImporte, String tipoFac) throws Exception {
		
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt= con.createStatement();
			Statement stmtS= con.createStatement();
			int maxId=1;
			
			String query="insert  into transaccion(id_usuario,ide,num,est,fec_ent,usu_crea_regi,fec_crea_regi,ult_usu_mod_regi,fec_ult_mod_regi) "
								 + "values('"+idUsuario+"','V','"+numeroTran+"','P','"+fechaEntrega+"','USER',now(),'USER',now());";
			
			System.out.println("query: "+query);
			int filas = stmt.executeUpdate(query);
			
			if(filas>0){
				String query2="select max(id) as maxid from transaccion;";
				ResultSet rs=stmtS.executeQuery(query2);
				while(rs.next()){
					maxId=Integer.parseInt(rs.getString("maxid"));
				}
				
			/*Statement stmt2= con.createStatement();
				String query3="(VEN_ID,TIPO,RUC,RAZ_SOC,NUM_COM,IGV,FEC_CAN,USU_CREA_REGI,FEC_CREA_REGI,ULT_USU_MOD_REGI,FEC_ULT_MOD_REGI)"
								+ "VALUES("+maxId+","+tipoFac+","+ruc+","+razon+","+numCom+","+igv+","+fechaEntrega+",'USER',now(),'USER',now());";
				stmt2.executeUpdate(query3);*/
				
				
				
				for(int i=0;i<productoId.length;i++){
					
					System.out.println("entra al for: "+productoId.length);
					Connection con1 = MySqlDAOFactory.obtenerConexion();
					Statement stmt1= con1.createStatement();
					//System.out.println(cantidad+" "+descuento);
					//double impAfe=(productoP[i-1])*cantidad*descuento/100;
					//System.out.println("importe afectado"+impAfe);
					System.out.println("llega al query 4");
					String query4="insert into detalle_transaccion(ven_id, pro_id, can, imp, usu_crea_regi, fec_crea_regi, ult_usu_mod_regi, fec_ult_mod_regi)"
														+"values("+maxId+","+productoId[i]+","+productoCantidad[i]+","+productoImporte[i]+",'USER',now(),'USER',now());";
					System.out.println("query4: "+query4);
					int filas1=stmt1.executeUpdate(query4);
					if(filas1>0){
						System.out.println("dio insert");
					}else{
						System.out.println("fallo un insert");
						return false;
					}
				}
				return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return false;
	}

	
	@Override
	public String generarNumeroTransaccion(String num) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		try{
			Connection con=MySqlDAOFactory.obtenerConexion();
			
			Statement stmt=con.createStatement();
			
			String query = "SELECT NUM FROM transaccion ORDER BY NUM DESC LIMIT 1";
			
			ResultSet rs = stmt.executeQuery(query);
			TransaccionBean trans=null;
			while(rs.next()){
				trans= new TransaccionBean();
				num = rs.getString("NUM");
				
				trans.setNum(num);
				
			}
			
			
		}catch(Exception e){
			e.getMessage();
		}
		
		return num;
	}
	
	
	@Override
	public boolean guardarComprobante(ComprobanteBean comprobante) throws Exception {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		int maxId=1;
		try{
			
			Connection con=MySqlDAOFactory.obtenerConexion();
			Statement stmt=con.createStatement();
			/*Statement stmtS=con.createStatement();
			
				String query2="select max(id) from transaccion;";
				ResultSet rs=stmtS.executeQuery(query2);
				while(rs.next()){
					maxId=Integer.parseInt(rs.getString("maxid"));
				}*/
				
			String query = " INSERT INTO comprobante_pago (VEN_ID ,TIPO ,RUC ,RAZ_SOC ,NUM_COM ,IGV ,FEC_EMI ,FEC_CAN ) "
					+ " VALUES ( (select max(id) from transaccion) , '"+comprobante.getTipo()+"','"+comprobante.getRuc()+"','"+comprobante.getRaz_soc()+"','"+comprobante.getNum_com()+"',"+comprobante.getIgv()+","+comprobante.getFec_emi()+","+comprobante.getFec_can()+" )";
			
			System.out.println("QUERY PARA GUARDAR COMPROBANTE ---> "+query);
			
			int filas = stmt.executeUpdate(query);
			
			if(filas == 1){
				System.out.println("SE GUARDO CON EXITO :DDDDD");
				flag = true;
			}
			
			
		}catch(Exception e){
			
			System.out.println("ERROR :"+e.getMessage());
			
		}
		
		return flag;
	}
	
	
	@Override
	public String obtenerUltimoNumeroComprobantexTipo(String tipo) throws Exception {
		// TODO Auto-generated method stub
		
		String num_com = "";
		
		try{
			Connection con=MySqlDAOFactory.obtenerConexion();
			Statement stmt=con.createStatement();
			String query = "";
			//String query = "SELECT NUM_COM FROM comprobante_pago WHERE TIPO = '"+tipo+"' ORDER BY NUM_COM DESC LIMIT 1";
			if(tipo.equalsIgnoreCase("boleta")){
				 query = "SELECT NUM_COM FROM comprobante_pago WHERE TIPO = '"+tipo+"' AND substr(NUM_COM,1,2) = 'BV' ORDER BY NUM_COM DESC LIMIT 1";
			}else{
				 query = "SELECT NUM_COM FROM comprobante_pago WHERE TIPO = '"+tipo+"' AND substr(NUM_COM,1,2) = 'FV' ORDER BY NUM_COM DESC LIMIT 1";
			}
			
			System.out.println("QUERY PARA OBTENER EL ULTIMO NUMERO DE COMPROBANTE ---->"+query);
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.isBeforeFirst()){
				
				if(rs.next()){
					
					num_com = rs.getString("NUM_COM");
					
				}
				
			}
			
			
		}catch(Exception e){
			System.out.println("ERROR :"+e.getMessage());
		}
		
		
		return num_com;
	}
	
	
	@Override
	public ArrayList<BoletaBean> buscarComprobanteGenerado(String numeroTransaccion) {
		// TODO Auto-generated method stub
		
		ArrayList<BoletaBean> boleta = new ArrayList<BoletaBean>();
		
		try{
			
			Connection con=MySqlDAOFactory.obtenerConexion();
			Statement stmt=con.createStatement();
			
			String query="SELECT  tr.NUM AS NUMERO_TRANSACCION,                            	"
					+ "CONCAT(pe.APE_PAT,' ',pe.APE_PAT,' ',pe.NOM) AS NOMBRE_CLIENTE,      "
					+ "	cp.TIPO AS TIPO_COMPROBANTE,								   "
					+ "   tr.IDE AS IDENTIFICADOR,                                       "
					+ "DATE_FORMAT(cp.FEC_EMI,'%d-%m-%Y') AS FECHA_EMISION,       "
					+ "DATE_FORMAT(cp.FEC_CAN,'%d-%m-%Y') AS FECHA_CANCELACION,"
					+ "DATE_FORMAT(tr.FEC_ENT,'%d-%m-%Y') AS FECHA_ENTREGA,"
					+ "pr.CODPRO AS CODIGO_PRODUCTO,     "
					+ "pr.NOM AS NOMBRE_PRODUCTO,                                   "
					+ "pr.PRE AS PRECIO,                                        	"
					+ "dt.CAN AS CANTIDAD, "
					+ "ROUND((dt.IMP/1.19),2) AS IMPORTE,                         "
					+ "of.DSC AS DESCUENTO                                    "
					+ "FROM                                                   "
					+ "transaccion tr                                         "
					+ "INNER JOIN comprobante_pago cp ON tr.ID = cp.VEN_ID    "
					+ "INNER JOIN detalle_transaccion dt ON tr.ID = dt.VEN_ID "
					+ "INNER JOIN usuario us ON tr.ID_USUARIO = us.ID           "
					+ "INNER JOIN persona pe ON us.PER_ID = pe.ID                "
					+ "INNER JOIN producto pr ON dt.PRO_ID = pr.ID             "
					+ "LEFT JOIN detalle_oferta df ON pr.ID = df.PRO_ID        "
					+ "LEFT JOIN ofertas of ON of.ID =df.OFE_ID                "
					+ "WHERE                                                   "
					+ "tr.NUM = '"+numeroTransaccion+"';";
							
			
			System.out.println("QUERY EN EJECUCION PARA BOLETA ----> " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			BoletaBean detalleB = null;
			
			while(rs.next()){
				detalleB = new BoletaBean();
				detalleB.setNum_com(rs.getString("NUMERO_TRANSACCION"));
				detalleB.setIde(rs.getString("IDENTIFICADOR"));
				detalleB.setNom_cli(rs.getString("NOMBRE_CLIENTE"));
				detalleB.setTip_com(rs.getString("TIPO_COMPROBANTE"));
				detalleB.setFec_emi(rs.getString("FECHA_EMISION"));
				detalleB.setFec_can(rs.getString("FECHA_CANCELACION"));
				detalleB.setFec_ent(rs.getString("FECHA_ENTREGA"));
				//detalleB.setDir(rs.getString("DIRECCION"));
				detalleB.setCod_pro(rs.getString("CODIGO_PRODUCTO"));
				detalleB.setNom_pro(rs.getString("NOMBRE_PRODUCTO"));
				detalleB.setPre(rs.getDouble("PRECIO"));
				detalleB.setCan(rs.getInt("CANTIDAD"));
				detalleB.setImporte(rs.getDouble("IMPORTE"));
				detalleB.setDescuento(rs.getDouble("DESCUENTO"));
				boleta.add(detalleB);
				
			}
			
			
		}catch(Exception e){
			
			System.out.println("ERROR -----> "+e.getMessage());
			
		}
		
		return boleta;
	}
	
	
	
}

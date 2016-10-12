package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.TransaccionBean;
import dao.interfaces.VentaDao;
import daofactory.MySqlDAOFactory;

public class MySql_VentaDao extends MySqlDAOFactory implements VentaDao {

	@Override
	public boolean registrarOferta(int idUsuario, String numeroTran,
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
}
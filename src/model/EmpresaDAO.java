package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import view.ExcluirEmpresaGUI;
import view.JanelaAlterar;
import view.JanelaConsultar;
public class EmpresaDAO {

		private Connection con;
		private Empresa empresa;	
		public ResourceBundle bn = null;
		
		public EmpresaDAO()
		{
			new ConexaoMYSQL();
//			ConexaoMYSQL con = new ConexaoMYSQL();
//			con.getConexaoMySQL();
			this.con = ConexaoMYSQL.getConexaoMySQL();
		}
		
		public boolean inserirEmpresa(Empresa empresa)
		{
			boolean var = false;
	         String sql = "INSERT INTO EMPRESA(CNPJ,RAZAO_SOCIAL, CONJUNTO, HORARIOOPEN, HORARIOEXIT) "
	         			+ "VALUES (?,?,?,?,?)";
	         try{
	    
	         PreparedStatement stmt = con.prepareStatement(sql);
	         stmt.setString(1,empresa.getCnpj() );
	         stmt.setString(2,empresa.getRazaoSocial() );
	         stmt.setString(3,empresa.getConjunto() );
	         stmt.setString(4,empresa.getEntrada() );
	         stmt.setString(5,empresa.getSaida() );
	         
	         stmt.execute();//Executa o INSERT
	         var = true;
	         stmt.close();//Fecha Statement
	         } catch (Exception u){
	        	 JOptionPane.showMessageDialog(null, u.getMessage());
	        	 
	         }
			return var;
			
		}
		
		public void consultarEmpresa(Empresa empresa)
		{
			String sql = "SELECT * FROM Empresa WHERE CNPJ = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,empresa.getCnpj());
				ResultSet r = stmt.executeQuery();
				while(r.next())
				{
					empresa.setRazaoSocial(r.getString(2));
					empresa.setConjunto(r.getString(3));
					empresa.setEntrada(r.getString(4));
					empresa.setSaida(r.getString(5));
				}
				stmt.close();
			} catch (Exception u){
				JOptionPane.showMessageDialog(null, u.getMessage());
	         }
		}
		
		public void alterarEmpresa(Empresa empresa)
		{
			String sql = "UPDATE Empresa SET RAZAO_SOCIAL = ?, CONJUNTO = ?,"
					+ " HORARIOOPEN = ?, HORARIOEXIT = ? "
					+ "WHERE CNPJ = ?";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(5,empresa.getCnpj() );
				stmt.setString(1,empresa.getRazaoSocial());
				stmt.setString(2,empresa.getConjunto());
				stmt.setString(3,empresa.getEntrada() );
				stmt.setString(4,empresa.getSaida());
				stmt.execute();
				stmt.close();
			}catch (Exception u){
	        	 JOptionPane.showMessageDialog(null, u.getMessage());
	         }
		}
		
		public void deletarEmpresa(Empresa empresa)
		{
			String sql = "DELETE FROM Empresa WHERE CNPJ = ?";
			try{
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,empresa.getCnpj() );
				stmt.execute();
				stmt.close();
			}catch (Exception u){
				JOptionPane.showMessageDialog(null, u.getMessage());
	         }
		}
		

}

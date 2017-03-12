package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class AtendenteDAO {

	private Connection con;
	private Funcionario funcionario;	
	public ResourceBundle bn = null;
	
	public AtendenteDAO()
	{
		new ConexaoMYSQL();
//		ConexaoMYSQL con = new ConexaoMYSQL();
//		con.getConexaoMySQL();
		this.con = ConexaoMYSQL.getConexaoMySQL();
	}
	
	public void inserirAtendente(Atendente atendente)
	{
         String sql = "INSERT INTO Atendente(NOME, SOBRENOME, CPF, DATA) "
         			+ "VALUES (?,?,?,?)";
         try{
    
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(3, atendente.getCpf() );
         stmt.setString(1, atendente.getNome() );
         stmt.setString(4, atendente.getData() );
         stmt.setString(2, atendente.getSobreNome());
         
         stmt.execute();//Executa o INSERT
         stmt.close();//Fecha Statement
         } catch (Exception u){
        	 JOptionPane.showMessageDialog(null, u.getMessage());
        	 
         }
	}
	
	public void consultarAtendente(Atendente atendente)
	{
		String sql = "SELECT * FROM Atendente WHERE CPF = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,atendente.getCpf());
			ResultSet r = stmt.executeQuery();
			while(r.next())
			{
				atendente.setCpf(r.getString(1));
				atendente.setNome(r.getString(2));
				atendente.setSobreNome(r.getString(3));
				atendente.setData(r.getString(4));
			}
			stmt.close();
		} catch (Exception u){
			JOptionPane.showMessageDialog(null, u.getMessage());
         }
	}
	
	public void alterarAtendente(Atendente atendente)
	{
		String sql = "UPDATE Atendente SET Nome = ?, SOBRENOME = ?,"
				+ " data = ? "
				+ "WHERE CPF = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(5,atendente.getCpf() );
			stmt.setString(1,atendente.getNome());
			stmt.setString(2,atendente.getSobreNome());
			stmt.setString(3,atendente.getData() );
			stmt.execute();
			stmt.close();
		}catch (Exception u){
        	 JOptionPane.showMessageDialog(null, u.getMessage());
         }
	}
	
	public void deletarAtendente(Atendente atendente)
	{
		String sql = "DELETE FROM Atendente WHERE CPF = ?";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,atendente.getCpf() );
			stmt.execute();
			stmt.close();
		}catch (Exception u){
			JOptionPane.showMessageDialog(null, u.getMessage());
         }
	}
}

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
public class FuncionarioDAO {
	
	private Connection con;
	private Funcionario funcionario;	
	public ResourceBundle bn = null;
	
	public FuncionarioDAO()
	{
		new ConexaoMYSQL();
//		ConexaoMYSQL con = new ConexaoMYSQL();
//		con.getConexaoMySQL();
		this.con = ConexaoMYSQL.getConexaoMySQL();
	}
	
	public boolean inserirFuncionario(Funcionario funcionario)
	{
		boolean var = false;
         String sql = "INSERT INTO FUNCIONARIO(CPF,NOME, NASCIMENTO, HORARIOENTRADA, HORARIOSAIDA, RAZAO_SOCIAL) "
         			+ "VALUES (?,?,?,?,?,?)";
         try{
    
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, funcionario.getCpf() );
         stmt.setString(2, funcionario.getNome() );
         stmt.setString(3, funcionario.getNascimento() );
         stmt.setString(4, funcionario.getHorarioEntrada() );
         stmt.setString(5, funcionario.getHorarioSaida() );
         stmt.setString(6, funcionario.getEmpresa());
         
         stmt.execute();//Executa o INSERT
         var = true;
         stmt.close();//Fecha Statement
         } catch (Exception u){
        	 JOptionPane.showMessageDialog(null, u.getMessage());
        	 
         }
         return var;
		
	}
	
	public void consultarFuncionario(Funcionario funcionario)
	{
		String sql = "SELECT * FROM Funcionario WHERE CPF = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,funcionario.getCpf());
			ResultSet r = stmt.executeQuery();
			while(r.next())
			{
				funcionario.setCpf(r.getString(1));
				funcionario.setNome(r.getString(2));
				funcionario.setNascimento(r.getString(3));
				funcionario.setHorarioEntrada(r.getString(4));
				funcionario.setHorarioSaida(r.getString(5));
				funcionario.setEmpresa1(r.getString(6));
			}
			stmt.close();
		} catch (Exception u){
			JOptionPane.showMessageDialog(null, u.getMessage());
         }
	}
	
	public void alterarFuncionario(Funcionario funcionario)
	{
		String sql = "UPDATE Funcionario SET Nome = ?, Nascimento = ?,"
				+ " HorarioEntrada = ?, HorarioSaida = ?, RAZAO_SOCIAL = ? "
				+ "WHERE CPF = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(6,funcionario.getCpf() );
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getNascimento());
			stmt.setString(3,funcionario.getHorarioEntrada() );
			stmt.setString(4,funcionario.getHorarioSaida());
			stmt.setString(5, funcionario.getEmpresa());
			stmt.execute();
			stmt.close();
		}catch (Exception u){
        	 JOptionPane.showMessageDialog(null, u.getMessage());
         }
	}

	public void deletarFuncionario(Funcionario funcionario)
	{
		String sql = "DELETE FROM Funcionario WHERE CPF = ?";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,funcionario.getCpf() );
			stmt.execute();
			stmt.close();
		}catch (Exception u){
			JOptionPane.showMessageDialog(null, u.getMessage());
         }
	}
	public boolean consultarNomeEmpresa(Funcionario funcionario)
	{
		boolean teste = false;
		String sql = "SELECT * FROM Empresa WHERE RAZAO_SOCIAL = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,funcionario.getEmpresa());
			ResultSet r = stmt.executeQuery();
			
			while(r.next())
			{
				funcionario.setEmpresa1(r.getString(2));
				teste = true;
				System.out.println(teste);
//				empresa.setConjunto(r.getString(3));
//				empresa.setEntrada(r.getString(4));
//				empresa.setSaida(r.getString(5));
			}
			stmt.close();
		} catch (Exception u){
			JOptionPane.showMessageDialog(null, u.getMessage());
         }
		return teste;
	}
}

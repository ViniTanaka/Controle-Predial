package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoMYSQL {

	public static String status = "Não conectou...";

	public ConexaoMYSQL() {

	}
	// Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null;

		try {
			// Configurando a nossa conexão com um banco de dados//
			String serverName = "localhost:3306"; // caminho do servidor do BD
			String mydatabase = "Projeto"; // nome do seu banco de dados
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "alunos"; // nome de um usuário de seu BD
			String password = "alunos"; // sua senha de acesso

			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				status = ("STATUS--Conectado com sucesso!");
			} else {
				status = ("STATUS--Não foi possivel realizar conexão");
			}
			return connection;
		} catch (SQLException e) { // Nao conectar ao banco,cai neste Exception
			JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}// METODO get CONEXAOMYSQL

	public static boolean FecharConexao() {

		try {
			ConexaoMYSQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}// FecharConexao
}

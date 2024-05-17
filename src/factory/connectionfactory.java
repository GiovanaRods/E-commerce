package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionfactory {

	// Nome do usuário no MySQL
	private static final String USERNAME = "root";
	// Senha do MySQL
	private static final String PASSWORD = "root";
	// Caminho para acessar o banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_kimonosage";

	// Conexão com MySQL
	public static Connection createConnectionToMySQL() throws Exception {
		try {
			// Tentativa de carregar o driver JDBC do MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver JDBC do MySQL carregado com sucesso!");
		} catch (ClassNotFoundException e) {
			// Se ocorrer uma exceção, imprima o stack trace
			e.printStackTrace();
			System.err.println("Erro ao carregar o driver JDBC do MySQL: " + e.getMessage());

		}
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}

	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kimonosage", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Testar se a conexão não é nula
		if (con != null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}

}

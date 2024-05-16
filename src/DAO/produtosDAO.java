package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ecommerce.controller.EcommerceController;
import ecommerce.model.Ecommerce;
import factory.connectionfactory;

public class produtosDAO {

	public void save(Ecommerce produto) throws SQLException {

		String sql = "INSERT INTO tb_produtoskimono(nome, tamanho, cor, codigo) VALUES(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, produto.getProduto());
			pstm.setString(2, produto.getTamanho());
			pstm.setString(3, produto.getCor());
			pstm.setInt(4, produto.getCodIDProduto());

			pstm.execute();

			System.out.println("Produto salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Ecommerce produto) {
		String sql = "UPDATE tb_produtoskimono SET nome = ?, tamanho = ?, cor = ?, codigo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Criar conexão com banco de dados
			conn = connectionfactory.createConnectionToMySQL();

			// Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar os valores a serem atualizados
			pstm.setString(1, produto.getProduto());
			pstm.setString(2, produto.getTamanho());
			pstm.setString(3, produto.getCor());
			pstm.setInt(4, produto.getCodIDProduto());

			// Qual id do registro que deseja atualizar
			pstm.setInt(4, produto.getCodIDProduto());

			// Executar a query
			pstm.execute();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByCodigo(int codigo) {
		String sql = "DELETE FROM tb_produtoskimono WHERE codigo = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionfactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(4, codigo);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Ecommerce> getProdutos() throws SQLException {
		String sql = "SELECT * FROM tb_produtoskimono";
		List<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();
		

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = connectionfactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Ecommerce ecommerce = new Ecommerce();

				ecommerce.setProduto(rset.getString("nome"));
				ecommerce.setTamanho(rset.getString("tamanho"));
				ecommerce.setCor(rset.getString("cor"));
				ecommerce.setCodIDProduto(rset.getInt("código do produto"));

				listaProdutos.add(ecommerce);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return listaProdutos;

	}
}

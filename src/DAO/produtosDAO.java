package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ecommerce.model.Ecommerce;
import factory.connectionfactory;

public class produtosDAO {

	public void save(Ecommerce produto) throws SQLException {

		String sql = "INSERT INTO tb_produtoskimono(produto, tamanho, cor, codigo) VALUES(?, ?, ?, ?)";
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

	public static List<Ecommerce> select() {
		String sql = "SELECT * FROM tb_produtoskimono";
		List<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();

		try (Connection conn = connectionfactory.createConnectionToMySQL();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Ecommerce produtoL = new Ecommerce(sql, sql, sql, 0);
				produtoL.setProduto(rs.getString("produto"));
				produtoL.setTamanho(rs.getString("tamanho"));
				produtoL.setCor(rs.getString("cor"));
				produtoL.setCodIDProduto(rs.getInt("codigo"));
				listaProdutos.add(produtoL);
			}

			System.out.println("Aqui está a lista: ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProdutos;

	}


	public static List<Ecommerce> selectByCodigo(int codigo) throws Exception {
		String sql = "SELECT * FROM tb_produtoskimono WHERE codigo = ?";
		List<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();

		try (Connection conn = connectionfactory.createConnectionToMySQL();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, codigo);
			
			 try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                    Ecommerce produtoL = new Ecommerce(sql, sql, sql, codigo);
	                    produtoL.setProduto(rs.getString("produto"));
	                    produtoL.setTamanho(rs.getString("tamanho"));
	                    produtoL.setCor(rs.getString("cor"));
	                    produtoL.setCodIDProduto(rs.getInt("codigo"));
	                    listaProdutos.add(produtoL);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listaProdutos;
	    }

	public void update(Ecommerce produto) {
		String sql = "UPDATE tb_produtoskimono SET nome = ?, tamanho = ?, cor = ?, codigo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionfactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, produto.getProduto());
			pstm.setString(2, produto.getTamanho());
			pstm.setString(3, produto.getCor());
			pstm.setInt(4, produto.getCodIDProduto());

			pstm.setInt(4, produto.getCodIDProduto());

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
				Ecommerce ecommerce = new Ecommerce(sql, sql, sql, 0);

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

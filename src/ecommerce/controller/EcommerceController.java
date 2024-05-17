package ecommerce.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DAO.produtosDAO;
import ecommerce.repository.EcommerceRepository;
import ecommerce.util.Cores;
import ecommerce.model.Ecommerce;
import ecommerce.model.EcommerceUsuario;
import DAO.produtosDAO;

public class EcommerceController implements EcommerceRepository {
	Scanner leia = new Scanner(System.in);

	List<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();
	private produtosDAO produtosDao = new produtosDAO();
	int produtos;

	private static ArrayList<EcommerceUsuario> usuarios = new ArrayList<EcommerceUsuario>();
	int usuario;

	@Override
	public void procurarPorID(int codIDProduto) {
		List<Ecommerce> listaProdutos;
		try {
	        listaProdutos = produtosDAO.selectByCodigo(codIDProduto);
	        
	        if (listaProdutos.isEmpty()) {
	            System.out.println("\nO Produto de número: " + codIDProduto + " não foi encontrado!");
	        } else {
	            for (Ecommerce produtoL : listaProdutos) {
	                produtoL.visualizar();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void listarProdutos() {
		List<Ecommerce> produtos = produtosDAO.select();
		for (Ecommerce produtoL : produtos) {
			produtoL.visualizar();
		}
	}

	public void listarUsuarios() {
		for (var usuario : usuarios) {
			usuario.visualizarListaUsuario();
		}
	}

	@Override
	public void cadastrar(Ecommerce produtoDAO) {
		listaProdutos.add(produtoDAO);
		System.out.println("\nO produto número: " + produtoDAO.getCodIDProduto() + " foi criado com sucesso!");
	}

	public void cadastrarUsuario(EcommerceUsuario usuario) {
		usuarios.add(usuario);
		System.out.println("\nO cadastro " + usuario.getUsuario() + " foi criado com sucesso!");

	}

	@Override
	public void atualizar(Ecommerce produtoDAO) {
		var buscaProduto = buscarNaCollection(produtoDAO.getCodIDProduto());
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produtoDAO);
			System.out.println("\nO Produto número: " + produtoDAO.getCodIDProduto() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO Produto número: " + produtoDAO.getCodIDProduto() + " não foi encontrada!");
		}
	}

	public void apagarUsuario(int usuario) {
		var cadastro = buscarNaCollectionUsuario(usuario);

		if (usuario == cadastro.getUsuario()) {
			usuarios.remove(cadastro);
			System.out.println("\nO cadastro numero: " + usuario + " foi deletado com sucesso!");
		} else {
			System.out.println("\nO cadastro numero: " + usuario + " não foi encontrado!");
		}
	}

	@Override
	public void apagarProduto(int codIDProduto) {
		var produto = buscarNaCollection(codIDProduto);

		if (produto != null) {
			if (listaProdutos.remove(produto) == true)
				System.out.println("\nO Produto numero: " + produto.getCodIDProduto() + " foi deletada com sucesso!");
		} else {
			System.out.println("\nO Produto numero: " + produto.getCodIDProduto() + " não foi encontrado!");
		}

	}

	public EcommerceUsuario buscarNaCollectionUsuario(int usuario) {
		for (EcommerceUsuario ecommerceUsuario : usuarios) {
			if (ecommerceUsuario.getUsuario() == usuario) {
				return ecommerceUsuario;
			} else {
				System.out.println("O usuario não foi encontrado!");
			}
		}
		return null;
	}

	public Ecommerce buscarNaCollection(int codIDProduto) {
		for (var produto : listaProdutos) {
			if (produto.getCodIDProduto() == codIDProduto) {
			}
		}
		return null;
	}

	public void exibirMenu(int opcao2) {
		System.out.println(Cores.TEXT_YELLOW + "*****************************************************");
		System.out.println("             	  KIMONOS AGE						");
		System.out.println("                                                    ");
		System.out.println("            1 - Cadastrar Usuario					");
		System.out.println("            2 - Lista de Produtos					");
		System.out.println("            3 - Adicione seu Produto no Carrinho	");
		System.out.println("            4 - Delete seu Produto do Carrinho		");
		System.out.println("            5 - Apagar Usuario  					");
		System.out.println("            6 - Comprar								");
		System.out.println("            7 - Voltar ao Menu						");
		System.out.println("            9 - Sair								");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                     " + Cores.TEXT_RESET);

		try {

		} catch (InputMismatchException e) {
			System.out.println("\nDigite valores inteiros!");
		}

	}

	public int gerarUsuario() {
		return usuario++;
	}

}
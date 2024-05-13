package ecommerce.controller;

import java.util.ArrayList;
import ecommerce.repository.EcommerceRepository;
import ecommerce.util.Cores;
import ecommerce.model.Ecommerce;
import ecommerce.model.EcommerceUsuario;

public class EcommerceController implements EcommerceRepository {

	private static ArrayList<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();
	int codIDProduto;

	private static ArrayList<EcommerceUsuario> usuarios = new ArrayList<EcommerceUsuario>();
	int usuario;

	@Override
	public void procurarPorID(int codIDProduto) {
		var produto = buscarNaCollection(codIDProduto);
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("\nO Produto de número: " + produto.getCodIDProduto() + " não foi encontrada!");
		}

	}

	@Override
	public void listarProdutos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Ecommerce produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto número: " + produto.getCodIDProduto() + " foi criado com sucesso!");
	}

	public void cadastrarUsuario(EcommerceUsuario usuario) {
		usuarios.add(usuario);
		System.out.println("\nO cadastro " + usuario.getUsuario() + " foi criado com sucesso!");

	}

	@Override
	public void atualizar(Ecommerce produto) {
		var buscaProduto = buscarNaCollection(produto.getCodIDProduto());
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO Produto número: " + produto.getCodIDProduto() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO Produto número: " + produto.getCodIDProduto() + " não foi encontrada!");
		}
	}

<<<<<<< HEAD
=======
	public void apagarUsuario(int usuario) {
		var cadastro = buscarNaCollectionUsuario(usuario);

		if (usuario == cadastro.getUsuario()) {
			usuarios.remove(cadastro);
				System.out.println("\nO cadastro numero: " + usuario + " foi deletado com sucesso!");
			} else {
				System.out.println("\nO cadastro numero: " + usuario + " não foi encontrado!");
			}
		}

>>>>>>> 74f86acbc68933b85fc1227243fb576c4e56a790
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

<<<<<<< HEAD
	public void apagarUsuario(int usuario) {
		var cadastro = buscarNaCollectionUsuario(usuario);

		if (usuario == cadastro.getUsuario()) {
			usuarios.remove(cadastro);
			System.out.println("\nO cadastro numero: " + usuario + " foi deletado com sucesso!");
			System.out.println(usuarios.toString());
		} else {
			System.out.println("\nO cadastro numero: " + usuario + " não foi encontrado!");
		}
	}

	public EcommerceUsuario buscarNaCollectionUsuario(int usuario) {
		for (EcommerceUsuario ecommerceUsuario : usuarios) {
			if (ecommerceUsuario.getUsuario() == usuario) {
=======
	public EcommerceUsuario buscarNaCollectionUsuario(int usuario){
		for (EcommerceUsuario ecommerceUsuario : usuarios){
			if (ecommerceUsuario.getUsuario() == usuario){
>>>>>>> 74f86acbc68933b85fc1227243fb576c4e56a790
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
				return produto;
			} else {
				System.out.println("O produto não foi encontrado!");
			}
		}
		return null;

	}

	public void exibirMenu(int opcao) {
		System.out.println(Cores.TEXT_YELLOW + "*****************************************************");
		System.out.println("             	  KIMONOS AGE						");
		System.out.println("                                                    ");
		System.out.println("            1 - Cadastrar Usuario					");
		System.out.println("            2 - Lista de Produtos					");
		System.out.println("            3 - Adicione seu Produto no Carrinho	");
		System.out.println("            4 - Delete seu Produto do Carrinho		");
		System.out.println("            5 - Apagar Cadastro  					");
		System.out.println("            6 - Comprar								");
		System.out.println("            7 - Voltar ao Menu						");
		System.out.println("            9 - Sair								");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                     " + Cores.TEXT_RESET);

	}

	public int gerarUsuario() {
		return usuario++;
	}
}

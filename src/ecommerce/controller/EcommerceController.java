package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.repository.EcommerceRepository;
import ecommerce.model.Ecommerce;
import ecommerce.model.EcommerceProdutos;

public class EcommerceController implements EcommerceRepository {

	private ArrayList<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();
	int codIDProduto;


	@Override
	public void procurarPorID(int codIDProduto) {
		var produto = buscarNaCollection(codIDProduto);
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("\nO Produto de número: " + codIDProduto + " não foi encontrada!");
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
		listaProdutos.add(codIDProduto, produto);
		System.out.println("\nO produto número: " + produto.getCodIDProduto() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Ecommerce produto) {
		var buscaProduto = buscarNaCollection(produto.getCodIDProduto());
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO Produto número: " + produto.getCodIDProduto() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nO Produto número: " + produto.getCodIDProduto() + " não foi encontrada!");
		}
	}

	@Override
	public void apagarProduto(int codIDProduto) {
		var produto = buscarNaCollection(codIDProduto);

		if (produto != null) {
			if (listaProdutos.remove(produto) == true)
				System.out.println("\nO Produto numero: " + produto.getCodIDProduto()  + " foi deletada com sucesso!");
		} else {
			System.out.println("\nO Produto numero: " + produto.getCodIDProduto()  + " não foi encontrado!");
		}	

	}
	public Ecommerce buscarNaCollection(int codIDProduto) {
        for (var produto : listaProdutos){
            if (produto.getCodIDProduto() == codIDProduto) { 
                return produto;
            }
        }

		return null;
	}
	public int gerarcodIDProduto() {
		return ++codIDProduto;
	}
}
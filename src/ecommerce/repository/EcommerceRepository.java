package ecommerce.repository;

import ecommerce.model.Ecommerce;

public interface EcommerceRepository {
	
	public void procurarPorID(int codIDProduto);
	public void cadastrar (Ecommerce codIDProduto);
	public void atualizar(Ecommerce produto);
	public void apagarProduto(int codIDProduto);
	void listarProdutos();
	}
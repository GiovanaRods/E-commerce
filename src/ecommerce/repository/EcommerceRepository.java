package ecommerce.repository;

import ecommerce.model.Ecommerce;

public interface EcommerceRepository {
	
	public void procurarPorID(int codIDProduto);
	public void listarProdutos();
	public void cadastrar (Ecommerce produto);
	public void atualizar(Ecommerce produto);
	public void apagarProduto(int codIDProduto);
	}
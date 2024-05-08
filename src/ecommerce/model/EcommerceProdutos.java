package ecommerce.model;

public class EcommerceProdutos extends Ecommerce {

	private int codIDProduto;
	
	public EcommerceProdutos(String usuario, String email, String produto, String telefone, 
	float valor, int codIDProduto) {
		super(usuario, email, produto, telefone, valor);
		this.codIDProduto = codIDProduto;	}

	public int getCodIDProduto() {
		return codIDProduto;
	}

	public void setCodIDProduto(int codIDProduto) {
		this.codIDProduto = codIDProduto;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Código do Produto: " + codIDProduto);
	}
}

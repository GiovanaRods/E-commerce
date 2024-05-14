package ecommerce.model;

public abstract class Ecommerce {

	private String tamanho;
	private String produto;
	private String cor;
	private int codIDProduto;

	public Ecommerce(String produto, String tamanho, String cor, int codIDProduto) {
		super();
		this.tamanho = tamanho;
		this.produto = produto;
		this.cor = cor;
		this.codIDProduto = codIDProduto;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Ecommerce(int codIDProduto) {
		super();
		this.codIDProduto = codIDProduto;
	}

	public int getCodIDProduto() {
		return codIDProduto;
	}

	public void setCodIDProduto(int codIDProduto) {
		this.codIDProduto = codIDProduto;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	
	}

	public void visualizar() {	
	System.out.println("***********************************************************");
	System.out.println("Cor: " + this.cor);
	System.out.println("Tamanho: " + this.tamanho);
	System.out.println("Produto: " + this.produto);	
	System.out.println("Numero do Produto: " + this.codIDProduto);
	}
}


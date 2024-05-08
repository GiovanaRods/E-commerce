package ecommerce.model;

public abstract class Ecommerce {

	private String tamanho;
	private String produto;
	private String cor;
	private float valor;
	private int codIDProduto;

	public Ecommerce(String produto, String tamanho, String cor, float valor) {
		super();
		this.tamanho = tamanho;
		this.produto = produto;
		this.cor = cor;
		this.valor = valor;
	}

	
	

	public Ecommerce(String tamanho, String cor) {
		super();
		this.tamanho = tamanho;
		this.cor = cor;
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



	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void visualizar() {
	}
	
}

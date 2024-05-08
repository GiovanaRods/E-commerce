package ecommerce.model;

public abstract class Ecommerce {

	private String usuario;
	private String email;
	private String produto;
	private String telefone;
	private float valor;

	public Ecommerce(String usuario, String email, String produto, String telefone, float valor) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.produto = produto;
		this.telefone = telefone;
		this.valor = valor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

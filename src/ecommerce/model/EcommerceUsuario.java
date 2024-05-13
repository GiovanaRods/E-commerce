package ecommerce.model;

public abstract class EcommerceUsuario {

	private String nome;
	private String telefone;
	private String email;
	private int usuario;

	public EcommerceUsuario(String nome, String telefone, String email, int usuario) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.usuario = usuario;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public void visualizar() {
		
		System.out.println("***********************************************************");
		
		}
}

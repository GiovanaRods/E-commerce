package ecommerce.model;

public class EcommercePedidos extends Ecommerce {
	
	private int numeroPedido;

	public EcommercePedidos(String usuario, String email, String produto, String telefone, float valor,
			int numeroPedido) {
		super(usuario, email, produto, telefone, valor);
		this.numeroPedido = numeroPedido;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Numero do Pedido: " + numeroPedido);
	}

}

package ecommerce.model;

import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner (System.in);
		EcommerceController ecommerce = new EcommerceController();
				
		String usuario, produto, email, telefone;
		int codID, numeroPedido, opcao =0;
		float valor;
		
		while (true) {
		
		System.out.println(Cores.TEXT_YELLOW
				+ "*****************************************************");
		System.out.println("             	  KIMONOS AGE						");
		System.out.println("                                                     ");
		System.out.println("            1 - Criar Cadastro						");
		System.out.println("            2 - Listar Itens						");
		System.out.println("            3 - Buscar Produto pelo ID				");
		System.out.println("            4 - Atualizar Dados do Cadastro			");
		System.out.println("            5 - Apagar Produto do Carrinho			");
		System.out.println("            6 - Cancelar Pedido						");
		System.out.println("            7 - Consultar Pedido					");
		System.out.println("            8 - Trocar Produto						");
		System.out.println("            9 - Sair								");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		
		switch (opcao) {
		
		case 1: 
			System.out.println("Criar Cadastro");
			System.out.println("Digite seu nome completo: ");
			usuario = leia.nextLine();
			
			System.out.println("Digite seu e-mail: ");
			email = leia.nextLine();
			
			System.out.println("Digite seu telefone: ");
			telefone = leia.nextLine();
		break;
		
		
		
		default:
			System.out.println("\nOpção Inválida");
			break;
		
		
		
		
		
		}
		
		
		
		
		}
		
	}

}

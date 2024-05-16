package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import ecommerce.controller.EcommerceController;
import ecommerce.model.EcommerceProdutos;
import ecommerce.model.EcommerceUsuario;
import ecommerce.model.EcommerceCadastros;
import ecommerce.util.Cores;

public class MenuUsuario {

	public static void main(String[] args) {

		String nome, email, telefone;
		int usuario = 0;
		EcommerceController menu = new EcommerceController();

		Scanner leia = new Scanner(System.in);

		int opcao2 = 0;

		while (true) {		

			menu.exibirMenu(opcao2);
			opcao2 = leia.nextInt();
			leia.nextLine();
			
			switch (opcao2) {
			case 1:
				usuario++;
				System.out.println("Cadastrar Usuario\n");
				System.out.println("Digite seu nome e sobrenome: ");
				nome = leia.nextLine();
				System.out.println("\nDigite seu e-mail:");
				email = leia.nextLine();
				System.out.println("\nDigite seu telefone para contato: ");
				telefone = leia.nextLine();
				menu.cadastrarUsuario(new EcommerceCadastros (nome, telefone, email, usuario));
				keyPress();
				break;

			case 0:
				System.out.println("Lista de Usuarios\n");
				menu.listarUsuarios();
				keyPress();
				break;
				
			case 2:
				System.out.println("Lista de Produtos\n");
				menu.listarProdutos();
				keyPress();
				break;

			case 3:
				System.out.println("Adicione seu Produto no Carrinho\n");
				keyPress();
				break;

			case 4:
				System.out.println("Delete seu Produto do Carrinho\n");
				keyPress();
				break;

			case 5:
				System.out.println("Apagar Cadastro\n");
				System.out.println("Digite o número do Cadastro: ");
				usuario = leia.nextInt();
				menu.apagarUsuario(usuario);
				keyPress();
				break;

			case 6:
				System.out.println("Comprar\n");
				keyPress();
				break;

			case 7:
				System.out.println("Voltar ao Menu Principal\n");
				break;

			case 9:
				System.out.println("Sair\n");
				System.out.println("Obrigado e volte sempre!");
				System.exit(0);

			default:
				System.out.println("\nOpção Inválida\n");
				keyPress();
				break;
			} 
		}
	}
	

	private static void keyPress() {
		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		} 
	}
}

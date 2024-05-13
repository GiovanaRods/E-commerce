package ecommerce.model;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		EcommerceController ecommerce = new EcommerceController();

		String produto, tamanho, cor;
		int codIDProduto, opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + "*****************************************************");
			System.out.println("             	  KIMONOS AGE						");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto					");
			System.out.println("            2 - Listar Produtos						");
			System.out.println("            3 - Buscar Produto pelo ID				");
			System.out.println("            4 - Atualizar Dados do Produto			");
			System.out.println("            5 - Apagar Produto  					");
			System.out.println("            6 - Formas de Pagamento					");
			System.out.println("            7 - Voltar ao Menu						");
			System.out.println("            9 - Sair								");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nKIMONOS AGE - Agradece o seu contato!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println("Cadastrar Produto\n");

				leia.nextLine();

				System.out.println("Digite o nome do kimono: ");
				produto = leia.nextLine();

				System.out.println("Digite o tamanho: ");
				tamanho = leia.nextLine();

				System.out.println("Digite a cor: ");
				cor = leia.nextLine();

				System.out.println("Digite o código do Produto: ");
				codIDProduto = leia.nextInt();

				ecommerce.cadastrar(new EcommerceProdutos(produto, tamanho, cor, codIDProduto));
				keyPress();
				break;

			case 2:
				System.out.println("Listar Itens");
				ecommerce.listarProdutos();
				keyPress();
				break;

			case 3:
				System.out.println("Buscar Produto pelo ID\n");
				System.out.println("Digite o ID do produto: ");
				codIDProduto = leia.nextInt();
				ecommerce.procurarPorID(codIDProduto);
				keyPress();
				break;

			case 4:

				System.out.println("Atualizar Dados do Produto\n");
				System.out.println("Digite o código do Produto que deseja atualizar: ");
				codIDProduto = leia.nextInt();

				var buscaProduto = ecommerce.buscarNaCollection(codIDProduto);

				if (buscaProduto != null) {

					leia.nextLine();

					System.out.println("Digite o nome do kimono: ");
					produto = leia.nextLine();

					System.out.println("Digite o tamanho: ");
					tamanho = leia.nextLine();

					System.out.println("Digite a cor: ");
					cor = leia.nextLine();

					ecommerce.atualizar(new EcommerceProdutos(produto, tamanho, cor, codIDProduto));
				} else
					System.out.println("\nProduto não encontrado!");
				keyPress();
				break;

			case 5:
				System.out.println("Apagar Produto\n");
				System.out.println("Digite o número do ID do Produto: ");
				codIDProduto = leia.nextInt();
				ecommerce.apagarProduto(codIDProduto);
				keyPress();
				break;

			case 6:
				System.out.println("Formas de Pagamento: \n");
				System.out.println("Cartão de Débito e Crédito");
				System.out.println("Pix");
				System.out.println("Transferência Bancária");
				keyPress();
				break;

			case 9:
				System.out.println("Sair");
				break;

			default:
				System.out.println("\nOpção Inválida");
				break;
			}
		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Giovana Rodrigues");
		System.out.println("Generation Brasil - giovana.saraiva@generation.org");
		System.out.println("github.com/GiovanaRods");
		System.out.println("*********************************************************");
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

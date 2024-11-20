package main;

import DAO.ProdutoDAO;
import Model.Produto;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Scanner scanner = new Scanner(System.in);

		String continuar = "sim";
		while (continuar.equalsIgnoreCase("sim")) {
			// Solicitar dados do usuário
			Produto produto = new Produto();
			System.out.print("Digite o nome do produto: ");
			produto.setNomeProduto(scanner.nextLine());

			System.out.print("Digite o preço do produto: ");
			produto.setPrecoProduto(scanner.nextDouble());
			scanner.nextLine(); // Consumir a quebra de linha

			// Criar o produto
			produtoDAO.criar(produto);

			System.out.print("Deseja adicionar outro produto? (sim/não): ");
			continuar = scanner.nextLine();
		}
		// Listar todos os produtos
		System.out.println("\nLista de produtos no banco de dados:");
		produtoDAO.listarTodos().forEach(p -> System.out.println(p.getNomeProduto() + " - " + p.getPrecoProduto()));

		scanner.close();
	}
}
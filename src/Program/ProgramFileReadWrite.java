package Program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidade.Produto;

public class ProgramFileReadWrite {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		
		List<Produto> list = new ArrayList<>(); 				
		
		System.out.println("Programa para ler o caminho de um arquivo .csv contendo os dados de itens vendidos.");
		System.out.println("Cada item possui um nome, preço unitário e quantidade, separados por vírgula."); 
		System.out.println("Você deve gerar um novo arquivo chamado 'summary.csv', localizado em uma subpasta chamada 'out'");
		System.out.println("a partir da pasta original do arquivo, contendo nome e valortotal para cada item");
		System.out.println("(preço unitário multiplicado pela quantidade).");
		System.out.println();
		
		System.out.println("Entre com o caminho e nome do Arquivo(.CSV): "); 
		String fileEntrada = sc.nextLine(); //Le caminho e nome do arquivo

		File arquivoEntrada = new File(fileEntrada); // Associa o arquivo
		String entradaFolder = arquivoEntrada.getParent(); // pega pasta onde está o arquivo
		
		boolean success = new File(entradaFolder + "\\out").mkdir(); // Cria um Sub-diretorio OUT
		
		String fileDestino = entradaFolder + "\\out\\summary.csv";  // monta o caminho para criar o novo arquivo
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileEntrada))) {

			String itemCsv = br.readLine(); // Le primeira linha do arquivo de entrada
			while (itemCsv != null) {

				String[] fields = itemCsv.split(","); // pega cada um dos campos e coloca numa posicao do fields[]
				String produto = fields[0]; 
				double valor = Double.parseDouble(fields[1]);
				int quantidade = Integer.parseInt(fields[2]);

				list.add(new Produto(produto, valor, quantidade));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileDestino))) {

				for (Produto item : list) {
					bw.write(item.getProduto() + "," + String.format("%.2f", item.ValorTotal()));
					bw.newLine();
				}

				System.out.println(fileDestino + " CREATED!");
				
			} catch (IOException e) {
				System.out.println("Erro na escrita do Arquivo: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Erro na leitura do Arquivo: " + e.getMessage());
		}

		sc.close();
	}
}
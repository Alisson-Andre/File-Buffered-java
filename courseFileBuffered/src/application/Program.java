package application;

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

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//cria uma lista da classe Produto
		List<Product> list = new ArrayList<>();
		
		//leitura do caminho do arquivo "item"
		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		//instancia do arquivo recebendo o caminho
		File sourceFile = new File(sourceFileStr);
		// string recebendo o caminho da pasta onde está o arquivo 
		String sourceFolderStr = sourceFile.getParent();
		
		//criação da pasta chamada "out" no caminho da pasta onde está o arquivo
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		//string do caminho de destino do novo arquivo recebendo o caminho da pasta, a nova pasta e o novo arquivo
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		//leitura do arquivo "item" no caminho que foi informado
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			
			//itemCsv recebendo o valor br diferente de nulo para o enquanto rodar
			String itemCsv = br.readLine();
			//o equanto vai rodar ate o valor do itemCsv ser nulo, adicionando na listas os valores que estão no arquivo,
			// que estão separado por vigula nas variaveis name, price e amoun.
			while (itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int amount = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, amount));
				
				itemCsv = br.readLine();
			}
			//escrevendo no arquivo summary.csv
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				
				for (Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.totalValue()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " CREATED! ," + success);
			
			} 
			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		} 
		catch (IOException e) {
			System.out.println("Error reading  file: " + e.getMessage());
		}
		
		
		sc.close();

	}

}

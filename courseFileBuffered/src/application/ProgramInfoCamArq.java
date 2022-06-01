package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Informações do caminho do arquivo
public class ProgramInfoCamArq {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("getName: " + path.getName());	
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: " + path.getPath());
		System.out.println("getAbsolutePath: " + path.getAbsolutePath());
		System.out.println("getCanonicalPath: " + path.getCanonicalPath());
		System.out.println("getgetFreeSpace: " + path.getFreeSpace());
		System.out.println("getTotalSpace: " + path.getTotalSpace());
		System.out.println("getUsableSpace: " + path.getUsableSpace());
		System.out.println("getAbsoluteFile: " + path.getAbsoluteFile());
		System.out.println("getCanonicalFile: " + path.getCanonicalFile());
			
		sc.close();
	}

}

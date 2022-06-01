package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//File Writer and Buffered writer (escrever)
public class ProgramFileWriterBufferedWriter {

public static void main(String[] args) {
		
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		String parth = "C:\\Workspace-java\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(parth,true))){
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

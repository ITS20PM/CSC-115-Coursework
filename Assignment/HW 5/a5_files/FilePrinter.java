import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter {
	FileWriter fw;
	
	public FilePrinter() {
		fw = null;
		try {
			fw = new FileWriter("A5-output.txt");
		} catch (IOException e) {
			System.out.println("Error setting up A5-output.txt");
			System.exit(-1);
		}
	}
	
	public void println(String toPrint) {
		try { 
			fw.write(toPrint + "\n");
		} catch (IOException e) {
			System.out.println("Could not write to A5-Output.txt");
		}
	}
	
	public void close() {
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("Error closing fileWriter.");
		}	
	}
}	
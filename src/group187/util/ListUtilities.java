package group187.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListUtilities {
	private ListUtilities(){
		
	}
	
	public static void saveListToTextFile(File file) throws IOException{
		if (file == null)
			throw new FileNotFoundException("The file cannot be found");
		
		
		/**
		try {
			if (file.getAbsolutePath().indexOf("customer") != -1){
				String outFilePath = file.getAbsolutePath()
					   .substring(0, file.getPath().lastIndexOf("\\")) + "\\SortedCustomerList.txt";
				File outFile = new File(outFilePath);
				outFile.createNewFile();
				System.out.println(outFile.getAbsolutePath());
				if (outFile.exists()){
					PrintWriter pw = new PrintWriter(outFile);
					System.out.println("File has been created");
				}
				else 
					throw new FileNotFoundException("The customer file does not exist");
				
				//
			}
			}
			
			catch (FileNotFoundException fe){
				System.out.println(fe.getMessage());
			}
		*/
			//String outFilePath = file.getPath().substring(0, file.getPath().lastIndexOf("\\")) + "\\SortedReservationList.txt";
	}
}

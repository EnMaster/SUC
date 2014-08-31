package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DBreader {
	ArrayList<String> line = new ArrayList<String>();
	public ArrayList<String> readDB(String source){
		String read;
		try{
			File file = new File(source);
			FileReader isr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(isr);
			read = buffer.readLine();
			while(read !=null){
				line.add(read);
				read = buffer.readLine();
			}
			isr.close();
			buffer.close();
			return line;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}		
	}
}
package loaderXperiaZ;

import java.util.ArrayList;

import loader.DBreader;
import risorse.ZC6603;

public class WriterC6603 {
	DBreader dBRead = new DBreader();
	ArrayList<ZC6603> phone = new ArrayList<>();
	public ArrayList<ZC6603> writer (String sorgente){
		
		ArrayList<String> line = new ArrayList<>();
		line.addAll(dBRead.readDB(sorgente));
		for(int i =0; i<line.size(); i++){
			String[] parts =line.get(i).split("\\s{2,}");
			for(int c = 0; c<parts.length;c++){					
			}
			phone.add( new ZC6603(parts[0],parts[1],parts[2],parts[3]));
		}
		return phone;
	}
	

}

package loader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import risorse.ZC6603;

public class DBWriter {
	
	public DBWriter(ArrayList<ZC6603> ZC6603){
		String DbFileLoc = new String("./XZDB/ZC6603DB");
		File fileDB = new File(DbFileLoc);
		try{
			if(!fileDB.exists()){
				fileDB.createNewFile();
			}
			FileWriter fw = new FileWriter(fileDB);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i=0;i<ZC6603.size();i++){
				bw.write(String.format("%-25s%-30s%-20s%s\n",ZC6603.get(i).getNation(),ZC6603.get(i).getBrand(),
						ZC6603.get(i).getSerial(),ZC6603.get(i).getNewVersion()));
			}
			bw.close();	
		}catch(IOException e){
			e.printStackTrace();
		}				
	}		
}

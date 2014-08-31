package checkVersion;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import loader.OnlineVersion;
import loaderXperiaZ.WriterC6603;
import org.xml.sax.SAXException;
import risorse.ZC6603;

public class FWCheckVersion {
	public WriterC6603 wrC6603 = new WriterC6603();
	public ArrayList<ZC6603> phC6603 = new ArrayList<>();
	public FWCheckVersion(){
		
		phC6603.addAll(wrC6603.writer("./XZDB/ZC6603DB"));
		ArrayList<String> URLZC6603 = new ArrayList<>();
		for(int i=0;i<phC6603.size();i++){
			URLZC6603.add(phC6603.get(0).getLink() + phC6603.get(i).getSerial());
			try {
				phC6603.get(i).setNewVersion(OnlineVersion.version(URLZC6603.get(i)));
				if(phC6603.get(i).getVersion().equals(phC6603.get(i).getNewVersion())==false){
					phC6603.get(i).setState("/img/check.png");
					phC6603.get(i).setUpdate(true);
				}else{
					phC6603.get(i).setState("/img/uncheck.png");
					phC6603.get(i).setUpdate(false);
				}
			} catch (XPathExpressionException | SAXException | IOException
					| ParserConfigurationException | XMLStreamException e) {
				e.printStackTrace();
			}			
		}
	}
}
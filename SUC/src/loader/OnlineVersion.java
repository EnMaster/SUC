package loader;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OnlineVersion {
	public static String version(String url) throws SAXException, IOException, 
	ParserConfigurationException, XPathExpressionException, XMLStreamException{
		String version = new String();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(url);        
        XPath xPathFactory = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xPathFactory.compile("updateAvailableResponse/releaseList/release/swVersion/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList node = (NodeList) result;
		if (node.item(0)==null){
			version = "!!UPDATING!!";
		}else{
			version = node.item(0).getNodeValue();
		}
		
		return version;
	}

}

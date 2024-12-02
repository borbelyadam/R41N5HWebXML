package domr41n5h1105;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifyR41N5H {
	
	public static void main(String argv[]) {
		
		try {
			File inputFile = new File("hallgatokquery.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(inputFile);
			
			Node hallgatok = doc.getFirstChild();
			
			Node hallgat = doc.getElementsByTagName("hallgato").item(0);
			
			NameNodeMap attr = hallgat.getAttributes();
			Node nodeAttr = attr.getNamedItem("id");
			nodeAttr.setTextContent("02");
			
			NodeList list = hallgat.getChildNodes();
			
			for (int temp = 0; temp < list.getLength(); temp++) {
				Node node = list.item(temp);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					if ("keresztnev".equals(eElement.getNodeName())) {
						if("Piroska".equals(eElement.getTextContent())) {
							eElement.setTetContent("Olivia");
						}
					}
					
					if ("vezeteknev".equals(eElement.getNodeName())) {
						if("Kiss".equals(eElement.getTexContent())) {
							eElement.setTexContent("Vigh");
						}
					}
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			
			System.out.println("---Módosított fájl---");
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

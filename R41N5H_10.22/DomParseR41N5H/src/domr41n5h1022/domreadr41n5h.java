package domr41n5h1022;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class domreadr41n5h {
	
	public static void main(String argv[]) throws SAXException,
	IOEXception, ParserConfigurationException {
		
		File xmlFile = new file("hallgatoR41N5H.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("hallgato");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent element: " + nNode.getNodeName());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				element elem = (Element) nNode;
				
				String uid = elem.getAttribute("id");
				
				Node nodel = elem.getElementsByTagName("firstname").item(0);
				String fname = nodel.getTextContent();
				
				Node node2 = elem.getElementsByTagName("lastname").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getelementsByTagName("profession").item(0);
				String pname = node3.getTextContent();
				
				System.out.printf("User id: %%n", uid);
				System.out.printf("First name: %%n", fname);
				System.out.printf("Last name: %%n", lname);
				System.out.printf("Profession: %%n", pname);
				
			}
		}
	}

}

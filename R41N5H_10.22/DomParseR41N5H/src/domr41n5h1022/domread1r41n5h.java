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

public class domread1r41n5h {

	public static void main(String argv[]) throws SAXException,
	IOEXception, ParserConfigurationException {
		
		File xmlFile = new file("orarendR41N5H.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("ora");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent element: " + nNode.getNodeName());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				element elem = (Element) nNode;
				
				String id = element.getAttribute("id");
                String tipusContent = element.getAttribute("tipus");

                Node targyNode = element.getElementsByTagName("targy").item(0);
                String targyContent = targyNode.getTextContent();

                Node idopontNode = element.getElementsByTagName("idopont").item(0);
                String idopontContent = idopontNode.getTextContent();

                Node helyszinNode = element.getElementsByTagName("helyszin").item(0);
                String helyszinContent = helyszinNode.getTextContent();

                Node oktatoNode = element.getElementsByTagName("oktato").item(0);
                String oktatoContent = oktatoNode.getTextContent();

                Node szakNode = element.getElementsByTagName("szak").item(0);
                String szakContent = szakNode.getTextContent();

                System.out.println("ID: " + id);
                System.out.println("Tipus: " + tipusContent);
                System.out.println("Tárgy: " + targyContent);
                System.out.println("Idopont: " + idopontContent);
                System.out.println("Helyszin: " + helyszinContent);
                System.out.println("Oktato: " + oktatoContent);
                System.out.println("Szak: " + szakContent);
				
			}
		}
	}

}

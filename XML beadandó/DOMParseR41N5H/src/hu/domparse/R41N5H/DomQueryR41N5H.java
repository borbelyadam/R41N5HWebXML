package hu.domparse.R41N5H;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class DomQueryR41N5H {
    public static void main(String[] args) {
        try {
            NodeList nodeList;

            DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            
            Document document=builder.parse(new File("XMLR41N5H.xml"));
            document.getDocumentElement().normalize();

            
            nodeList=document.getElementsByTagName("Product");

            for(int i =0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);

                
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    int price= parseInt(element.getElementsByTagName("Price").item(0).getTextContent());

                    if(price>3000)
                    {
                        System.out.println("\nAktuális elem: " + node.getNodeName());
                        System.out.println("-------");
                        System.out.println("");
                        System.out.println("Product id: " + element.getAttribute("Pid"));
                        System.out.println("Price: " + element.getElementsByTagName("Price").item(0).getTextContent());
                        System.out.println("Descreption: " + element.getElementsByTagName("Descreption").item(0).getTextContent());
                        System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());

                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }
}


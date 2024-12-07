import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriteR41N5H {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        
        Document doc = builder.newDocument();

        
        Element root = doc.createElement("root");
        root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.setAttribute("xsi:noNamespaceSchemaLocation", "XMLSchemaR41N5H.xsd");
        doc.appendChild(root);

        
        Element cars = doc.createElement("cars");
        root.appendChild(cars);
        addCar(doc, cars, "asd123", "001", "Aygo", "Toyota", "2010");
        addCar(doc, cars, "cfg456", "002", "Aygo", "Toyota", "2010");
        addCar(doc, cars, "mnb932", "003", "Swift", "Suzuki", "2008");
        addCar(doc, cars, "kli673", "004", "E60", "BMW", "2015");

        
        Element creditCards = doc.createElement("CreditCards");
        root.appendChild(creditCards);
        addCreditCard(doc, creditCards, "12344567893", "001", "Visa", "23-10", "K and H");
        addCreditCard(doc, creditCards, "45612378934", "002", "Amex", "23-07", "OTP");
        addCreditCard(doc, creditCards, "98712345634", "003", "Visa", "23-08", "ABG");
        addCreditCard(doc, creditCards, "12344567893", "004", "Visa", "23-02", "CA");

        
        Element costumers = doc.createElement("Costumers");
        root.appendChild(costumers);
        addCostumer(doc, costumers, "001", "dean@gmail.com", "hangpass", "Dean", "Winchester", "Magyarorszag", "BAZ", "3530", "Miskolc", "Elet utca", "5");
        addCostumer(doc, costumers, "002", "alal1@yahoo.com", "hunpass", "Bela", "Nagy", "Magyarorszag", "BAZ", "3530", "Miskolc", "Boldog utca", "90");
        addCostumer(doc, costumers, "003", "hamar1@freemail.hu", "alapass", "Alfred", "Gonzalez", "Magyarorszag", "BAZ", "3530", "Miskolc", "Hatalom utca", "10");
        addCostumer(doc, costumers, "004", "nGerg@gmail.com", "nempass", "Gergely", "Németh", "Magyarorszag", "Pest Megye", "1082", "Budapest VIII", "Hock Jánós út", "2");

        
        Element requests = doc.createElement("Requests");
        root.appendChild(requests);
        addRequest(doc, requests, "001", "001", "001", "Személyes", "10000", "0", "KP");
        addRequest(doc, requests, "002", "004", "003", "Futár", "12000", "10", "BK");
        addRequest(doc, requests, "003", "002", "002", "Posta", "33", "2", "UV");

        
        Element rates = doc.createElement("Rates");
        root.appendChild(rates);
        addRate(doc, rates, "001", "001", "Belika", "1");
        addRate(doc, rates, "002", "003", "Dean", "4");
        addRate(doc, rates, "003", "002", "UgraBug", "6");

        
        Element products = doc.createElement("Products");
        root.appendChild(products);
        addProduct(doc, products, "001", "12000", "Komplett motor blokk", "Motor");
        addProduct(doc, products, "002", "500", "Vezérműszíj", "Szíj");
        addProduct(doc, products, "003", "6000", "Toronycsapágy", "Csapágy");
        addProduct(doc, products, "004", "3000", "Jobb normál saru", "Akkumulátor");

        
        Element carTypes = doc.createElement("CarTypes");
        root.appendChild(carTypes);
        addCarType(doc, carTypes, "001", "001", "2014", "Toyota");
        addCarType(doc, carTypes, "002", "002", "2008", "Toyota");
        addCarType(doc, carTypes, "003", "003", "2009", "Suzuki");
        addCarType(doc, carTypes, "004", "004", "2011", "BMW");

        
        Element pictures = doc.createElement("Pictures");
        root.appendChild(pictures);
        addPicture(doc, pictures, "001", "001", "Enng.jpg", "/home/pic/toyota", "Toy");
        addPicture(doc, pictures, "002", "002", "Enng.jpg", "/home/pic/Toyota", "Toyota");
        addPicture(doc, pictures, "003", "003", "Enng.jpg", "/home/pic/suz", "Suz");
        addPicture(doc, pictures, "004", "004", "Enng.jpg", "/home/pic/BMW", "BMW");

        
        Element suppliers = doc.createElement("Suppliers");
        root.appendChild(suppliers);
        addSupplier(doc, suppliers, "001", "BOSCH", "Magyarorszag", "BAZ", "3526", "Miskolc", "Robert Bosch Park", "1");
        addSupplier(doc, suppliers, "002", "AUTOMOTIVE", "England", "AB10", "1JB", "Aberdeen", "Albyn Place", "37");
        addSupplier(doc, suppliers, "003", "SEMA", "Germany", "D77", "87499", "Wildpoldsried", "Dorfmuehlstr", "11");

        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);

        File myFile = new File("R41N5Hout.xml");
        StreamResult file = new StreamResult(myFile);

        transf.transform(source, file);

        System.out.println("XML fájl sikeresen létrehozva: output.xml");
    }

    private static void addCar(Document doc, Element parent, String plateNo, String cid, String brand, String model, String produced) {
        Element car = doc.createElement("car");
        car.setAttribute("PlateNo", plateNo);
        car.setAttribute("CID", cid);

        car.appendChild(createElement(doc, "Modell", model));
        car.appendChild(createElement(doc, "Brand", brand));
        car.appendChild(createElement(doc, "Produced", produced));

        parent.appendChild(car);
    }

    private static void addCreditCard(Document doc, Element parent, String cardNo, String cid, String type, String expire, String bank) {
        Element creditCard = doc.createElement("CreditCard");
        creditCard.setAttribute("CardNO", cardNo);
        creditCard.setAttribute("CID", cid);

        creditCard.appendChild(createElement(doc, "Type", type));
        creditCard.appendChild(createElement(doc, "Expire", expire));
        creditCard.appendChild(createElement(doc, "Bank", bank));

        parent.appendChild(creditCard);
    }

    private static void addCostumer(Document doc, Element parent, String cid, String email, String passwd, String firstName, String lastName, String country, String county, String zip, String city, String street, String streetNo) {
        Element costumer = doc.createElement("Costumer");
        costumer.setAttribute("CID", cid);

        costumer.appendChild(createElement(doc, "email", email));
        costumer.appendChild(createElement(doc, "passwd", passwd));
        costumer.appendChild(createElement(doc, "UserName", firstName));

        Element name = doc.createElement("Name");
        name.appendChild(createElement(doc, "FirstName", firstName));
        name.appendChild(createElement(doc, "LastName", lastName));
        costumer.appendChild(name);

        Element address = doc.createElement("Address");
        address.appendChild(createElement(doc, "Country", country));
        address.appendChild(createElement(doc, "County", county));
        address.appendChild(createElement(doc, "Zip", zip));
        address.appendChild(createElement(doc, "City", city));
        address.appendChild(createElement(doc, "Street", street));
        address.appendChild(createElement(doc, "StreetNo", streetNo));
        costumer.appendChild(address);

        parent.appendChild(costumer);
    }

    private static void addRequest(Document doc, Element parent, String reqId, String cid, String pid, String shipMode, String price, String shipPrice, String payMode) {
        Element request = doc.createElement("Request");
        request.setAttribute("ReqID", reqId);
        request.setAttribute("CID", cid);
        request.setAttribute("PID", pid);

        request.appendChild(createElement(doc, "ShipMode", shipMode));
        request.appendChild(createElement(doc, "Price", price));
        request.appendChild(createElement(doc, "ShipPrice", shipPrice));
        request.appendChild(createElement(doc, "PayMode", payMode));

        parent.appendChild(request);
    }

    private static void addRate(Document doc, Element parent, String rateId, String pid, String who, String rate) {
        Element rateElement = doc.createElement("Rate");
        rateElement.setAttribute("RiD", rateId);
        rateElement.setAttribute("PID", pid);

        rateElement.appendChild(createElement(doc, "Who", who));
        rateElement.appendChild(createElement(doc, "Rate", rate));

        parent.appendChild(rateElement);
    }

    private static void addProduct(Document doc, Element parent, String pid, String price, String description, String name) {
        Element product = doc.createElement("Product");
        product.setAttribute("Pid", pid);

        product.appendChild(createElement(doc, "Price", price));
        product.appendChild(createElement(doc, "Descreption", description));
        product.appendChild(createElement(doc, "Name", name));

        parent.appendChild(product);
    }

    private static void addCarType(Document doc, Element parent, String ctid, String pid, String produced, String brand) {
        Element carType = doc.createElement("CarType");
        carType.setAttribute("CTID", ctid);
        carType.setAttribute("PID", pid);

        carType.appendChild(createElement(doc, "Produced", produced));
        carType.appendChild(createElement(doc, "Brand", brand));

        parent.appendChild(carType);
    }

    private static void addPicture(Document doc, Element parent, String picId, String pid, String title, String filePath, String caption) {
        Element picture = doc.createElement("Picture");
        picture.setAttribute("PicID", picId);
        picture.setAttribute("PID", pid);

        picture.appendChild(createElement(doc, "Title", title));
        picture.appendChild(createElement(doc, "filePath", filePath));
        picture.appendChild(createElement(doc, "Caption", caption));

        parent.appendChild(picture);
    }

    private static void addSupplier(Document doc, Element parent, String sid, String name, String country, String county, String zip, String city, String street, String streetNo) {
        Element supplier = doc.createElement("Supplier");
        supplier.setAttribute("SID", sid);

        supplier.appendChild(createElement(doc, "Name", name));

        Element address = doc.createElement("Address");
        address.appendChild(createElement(doc, "country", country));
        address.appendChild(createElement(doc, "County", county));
        address.appendChild(createElement(doc, "Zip", zip));
        address.appendChild(createElement(doc, "City", city));
        address.appendChild(createElement(doc, "Street", street));
        address.appendChild(createElement(doc, "StreetNo", streetNo));
        supplier.appendChild(address);

        parent.appendChild(supplier);
    }

    private static Element createElement(Document doc, String tagName, String value) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        return element;
    }
}
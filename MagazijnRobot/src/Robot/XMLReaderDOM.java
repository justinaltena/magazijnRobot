
package Robot;

import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import java.time.LocalDate;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class XMLReaderDOM {
    private static ArrayList<Product> Xproducts = new ArrayList<>();
    private static int Xorder_id, Xcustomer_id;
    private static LocalDate Xorder_date;
    private static String filePath;
    
    public static void main(String[] args) {
        
        Properties prop = new Properties();
        
        try {
	  InputStream inputStream = 
	    XMLReaderDOM.class.getClassLoader().getResourceAsStream("Order001.xml");

	  prop.load(inputStream);
	  filePath = prop.getProperty("json.filepath");
		
	} catch (IOException e) {
		e.printStackTrace();
	}
        
        File xmlFile = new File(url.getPath());  //Aanmaken object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            //Ophalen en parsen order_id
            Xorder_id = Integer.parseInt(doc.getElementsByTagName("order_id").item(0).getTextContent());
            //Ophalen en parsen customer_id
            Xcustomer_id = Integer.parseInt(doc.getElementsByTagName("customer_id").item(0).getTextContent());
            //Ophalen en parsen order_date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateText = doc.getElementsByTagName("order_date").item(0).getTextContent();
            Xorder_date = LocalDate.parse(dateText, formatter);
            
            NodeList productList = doc.getElementsByTagName("product");
            //now XML is loaded as Document in memory, lets convert it to Object List
            for (int i = 0; i < productList.getLength(); i++) {
                Xproducts.add(getProduct(productList.item(i)));
            }
            //lets print Employee list information
            for (Product pro : Xproducts) {
                System.out.println(pro.toString());
            }
            
            Order orderFile = new Order(Xcustomer_id, Xorder_id, Xorder_date, Xproducts);
            
            
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }


    private static Product getProduct(Node node) {
        Product product = new Product(0, "BLANK");
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            int Xproduct_id = Integer.parseInt(getTagValue("product_id", element));
            product = null;
            product = new Product(
                    Xproduct_id,
                    getTagValue("product_name", element) );
        }

        return product;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    
}
}

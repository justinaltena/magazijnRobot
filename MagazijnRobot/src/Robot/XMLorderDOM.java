package Robot;

import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import java.time.LocalDate;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class XMLorderDOM {

    private static ArrayList<Product> Xproducts = new ArrayList<>();
    private static int Xorder_id, Xcustomer_id, Xproduct_id;
    private static LocalDate Xorder_date;
    private static File xmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    private static String XSorder_id, XScustomer_id, XSproduct_id;
    public static Order orderFile;

    public static void main(String[] args) {

        try {
            xmlFile = new File("Order001.xml");  //Aanmaken object
            dbFactory = DocumentBuilderFactory.newInstance();
        } catch (Exception e4) {
            e4.printStackTrace();
        }

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            //Ophalen en parsen order_id
            XSorder_id = doc.getElementsByTagName("order_id").item(0).getTextContent();
            Xorder_id = XMLorderDOM.parseCustomInt(XSorder_id);

            //Ophalen en parsen customer_id
            XScustomer_id = doc.getElementsByTagName("customer_id").item(0).getTextContent();
            Xcustomer_id = XMLorderDOM.parseCustomInt(XScustomer_id);

            //Ophalen en parsen order_date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateText = doc.getElementsByTagName("order_date").item(0).getTextContent();
            dateText = dateText.replaceAll("\\s+", "");
            try {
                Xorder_date = LocalDate.parse(dateText, formatter);
            } catch (DateTimeParseException e5) {
                e5.printStackTrace();
            }

            NodeList productList = doc.getElementsByTagName("product");
            //now XML is loaded as Document in memory, lets convert it to Object List
            for (int i = 0; i < productList.getLength(); i++) {
                Xproducts.add(getProduct(productList.item(i)));
            }

//            for (Product pro : Xproducts) {
//                System.out.println(pro.toString());
//            }
            orderFile = new Order(Xcustomer_id, Xorder_id, Xorder_date, Xproducts);

            System.out.println(orderFile);

        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static Product getProduct(Node node) {
        Product product = new Product(0, "BLANK");
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            XSproduct_id = getTagValue("product_id", element);
            Xproduct_id = XMLorderDOM.parseCustomInt(XSproduct_id);
            product = null;
            product = new Product(
                    Xproduct_id,
                    getTagValue("product_name", element));
        }

        return product;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();

    }

    private static int parseCustomInt(String XorderString) {
        int output = 0;
        try {
            XorderString = XorderString.replaceAll("\\s+", "");
            output = Integer.parseInt(XorderString);
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
        return output;
    }

}

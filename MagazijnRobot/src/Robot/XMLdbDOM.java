package Robot;

import java.awt.Point;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;
import java.util.ArrayList;

public class XMLdbDOM {

    private static File xmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    //public static Order order;
    private static ArrayList<Product> productsC = new ArrayList<>();
    private static int Xproduct_id, xcoor, ycoor, size;
    private static String XSproduct_id, xScoor, yScoor, Ssize;
    private static Point coor;

    public static void main(String[] args) {

        try {
            xmlFile = new File("Database.xml");  //Aanmaken object
            dbFactory = DocumentBuilderFactory.newInstance();
        } catch (Exception e4) {
            e4.printStackTrace();
        }

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList productList = doc.getElementsByTagName("product");
            //now XML is loaded as Document in memory, lets convert it to Object List
            for (int i = 0; i < productList.getLength(); i++) {
                productsC.add(getProduct(productList.item(i)));
            }

            // System.out.println(productsC);
            XMLorderDOM.main();
            Order order = XMLorderDOM.orderFile;
            System.out.println(order);

            //COORDINATEN KOPPELEN AAN DE ORDER
            for (Product p : order.getProducts()) {
                for (Product pc : productsC) {
                    if (p.getProduct_id() == pc.getProduct_id() && pc.getChecked() == false) {
                        p.setProduct_position(pc.getProduct_position());
                        p.setChecked(true);
                        //System.out.println(p);
                    }
                }
            }

            System.out.println(order);
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static Product getProduct(Node node) {
        Product product = new Product(0, (new Point()), 0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            XSproduct_id = getTagValue("product_id", element);
            Xproduct_id = XMLdbDOM.parseCustomInt(XSproduct_id);

            //COORDINATEN OPZOEKEN UIT DB
            xScoor = getTagValue("x-coordinate", element);
            xcoor = parseCustomInt(xScoor);
            //System.out.println(xcoor + " xcoor");
            yScoor = getTagValue("y-coordinate", element);
            ycoor = parseCustomInt(yScoor);
            coor = new Point(xcoor, ycoor);

            //SIZE OPZOEKEN UIT DB
            Ssize = getTagValue("size", element);
            size = parseCustomInt(Ssize);

            //AANMAKEN PRODUCT-OBJECT
            product = new Product(Xproduct_id, coor, size);
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

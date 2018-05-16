
package Robot;

import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;

public class XMLReaderDOM {
    private ArrayList<
    
    public static void main(String[] args) {
        String filePath = "Order001.xml";   //Pad naar document
        File xmlFile = new File(filePath);  //Aanmaken object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("order");
            //now XML is loaded as Document in memory, lets convert it to Object List
            products;
            for (int i = 0; i < nodeList.getLength(); i++) {
                empList.add(getEmployee(nodeList.item(i)));
            }
            //lets print Employee list information
//            for (Employee emp : empList) {
//                System.out.println(emp.toString());
//            }
            
            Order orderFile = new Order(Xcustomer_id, Xorder_id, Xorder_date, Xproducts);
            
            
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }


    private static Employee getEmployee(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Employee emp = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setAge(Integer.parseInt(getTagValue("age", element)));
            emp.setGender(getTagValue("gender", element));
            emp.setRole(getTagValue("role", element));
        }

        return emp;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    
}
}

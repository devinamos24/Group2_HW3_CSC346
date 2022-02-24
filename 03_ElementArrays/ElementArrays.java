import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ElementArrays {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            File xmlFile = new File("03_ElementArrays/ElementArrays.xml");
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // TODO: add code for parsing array xml document

            // First we need to grab the node that holds the array
            // In this example that happens to be the root node
            Element root = document.getDocumentElement();

            // After we obtain the Element containing the array, we need to pull the array
            NodeList element_array_raw = root.getElementsByTagName("state");

            for (int i = 0; i < element_array_raw.getLength(); i++)
                System.out.println(element_array_raw.item(i).getChildNodes().getLength());
            // Next we need to parse the array and get the data we want
            // Point out that for each loops are not available for NodeList objects
//            Element currentitem;
//            for (int i = 0; i < element_array.getLength(); i++) {
//                currentitem = (Element) element_array.item(i);
//                System.out.println(currentitem.getElementsByTagName("state").item(0).getTextContent());
//            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}

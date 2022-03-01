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

public class ElementArrays {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            File xmlFile = new File("03_ElementArrays/ElementArrays.xml");
            Document document = builder.parse(xmlFile);

            // TODO: add code for parsing array xml document

            // First we need to grab the node that holds the array
            // In this example that happens to be the root node
            Element root = document.getDocumentElement();
            root.normalize();

            // After we obtain the Element containing the array, we need to pull the first child in the array
            // This allows us to parse each sibling after the child like a Linked List
            Node node = root.getFirstChild();

            // Next we need to parse the array and get the data we want
            // Point out that for each loops are not available for NodeList objects
            // We use a do while loop so that we include the first element we selected before
            // We also must check that the node name matches the name we want, in this case it is "state"
            // There are weird newline nodes between each element, the if statement helps ignore them
            do {
                if (node.getNodeName().equals("state")) {
                    System.out.println(((Element) node).getElementsByTagName("state").item(0).getTextContent());
                    System.out.println(((Element) node).getElementsByTagName("slug").item(0).getTextContent());
                    System.out.println(((Element) node).getElementsByTagName("code").item(0).getTextContent());
                    // I'm too lazy to add the rest, but you get the point
                }
            } while ((node = node.getNextSibling()) != null);

            // Be careful with dom nodes because they don't always have an important meaning
            // For instance, there are nodes between each element that are just there for the newline character

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}

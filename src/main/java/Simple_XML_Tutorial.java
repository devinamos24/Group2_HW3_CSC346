import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Simple_XML_Tutorial {
    public static void main(String[] args) {

        // We already know how to pull information from the into tutorial so do not include this
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        try {
            File xmlFile = new File("src/main/resources/Intro_Tutorial.xml");
            Document document = builder.parse(xmlFile);

            // START TUTORIAL HERE!!!

            // Talk about document normalization and why it is necessary https://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work/13787629
            document.getDocumentElement().normalize();

            // Now talk about how to pull the root element with this command
            Element root = document.getDocumentElement();

            // Next talk about how to pull the sub elements from the root with these commands
            // If you want the types to match what you get you have to cast them
            Element host = (Element) root.getElementsByTagName("host").item(0);
            Element port = (Element) root.getElementsByTagName("port").item(0);
            Element user = (Element) root.getElementsByTagName("user").item(0);
            Element password = (Element) root.getElementsByTagName("password").item(0);

            // Note that you must grab the group of elements then select the 0th element
            // Also note that the object you get is a node and not an element

            // Next talk about how to get attributes from a node/element
            // Once again, you have to cast them to get the proper interface
            Attr password_xhint = (Attr) password.getAttributes().getNamedItem("xhint");

            // Note that the attribute is stored in the node class

            // Next talk about how to get tag names with the getTagName() or getNodeName() instance methods
            String root_tagname = root.getTagName();
            //String root_tagname = root.getNodeName();

            // Next talk about how to extract text data from each of these objects using getTextContent()
            String host_content = host.getTextContent();
            String port_content = port.getTextContent();
            String user_content = user.getTextContent();
            String password_content = password.getTextContent();
            String password_xhint_content = password_xhint.getTextContent();

            // You don't have to talk about printing them but you can if you want for demonstration
            System.out.println(root_tagname);
            System.out.println(host_content);
            System.out.println(port_content);
            System.out.println(user_content);
            System.out.println(password_content);
            System.out.println(password_xhint_content);

        } catch (IOException | SAXException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

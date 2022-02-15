import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Intro_Tutorial {
    public static void main(String[] args) {

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
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());
            System.out.println("host = " + root.getElementsByTagName("host").item(0).getTextContent());
            System.out.println("port = " + root.getElementsByTagName("port").item(0).getTextContent());
            System.out.println("user = " + root.getElementsByTagName("user").item(0).getTextContent());
            System.out.println("password = " + root.getElementsByTagName("password").item(0).getTextContent());
        } catch (IOException | SAXException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

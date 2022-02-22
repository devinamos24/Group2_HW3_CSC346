import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Nested_XML_Tutorial {
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
            File xmlFile = new File("src/main/resources/Nested_XML_Tutorial.xml");
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // TODO: add code for parsing nested xml document

        } catch (IOException | SAXException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

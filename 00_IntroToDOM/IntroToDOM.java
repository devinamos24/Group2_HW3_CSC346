import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class IntroToDOM {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();

            File xmlFile = new File("00_IntroToDOM/IntroToDOM.xml");
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}

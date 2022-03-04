import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class NestedElements {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            File xmlFile = new File("02_NestedElements/NestedElements.xml");
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // TODO: add code for parsing nested xml document

            // Grabbing nested elements can be done by grabbing the parent of each element and working your way down
            Element root = document.getDocumentElement();

            // We will now grab the "title" two different ways
            // The first way is to just grab it by searching for it
            Element title_0 = (Element) root.getElementsByTagName("title").item(0);
            System.out.println(title_0.getTextContent());

            // Be careful with the previous method if there are multiple elements in the document with the same name

            // Now we will grab it by getting its parent first and working down
            Element image = (Element) root.getElementsByTagName("image").item(0);
            Element title_1 = (Element) image.getElementsByTagName("title").item(0);
            System.out.println(title_1.getTextContent());

            // The advantage to this method is that we avoid grabbing another element with the same name accidentally

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}

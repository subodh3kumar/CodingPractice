package dev.workshop.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlFile {

    private static final String FILE_NAME = "/users.xml";

    public static void main(String[] args) {
        ReadXmlFile xmlReader = new ReadXmlFile();
        xmlReader.readXmlV1();
    }

    private void readXmlV1() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try (InputStream inputStream = ReadXmlFile.class.getResourceAsStream(FILE_NAME)) {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            System.out.println("---------");

            NodeList userNode = document.getElementsByTagName("user");

            for (int i = 0; i < userNode.getLength(); i++) {
                Node node = userNode.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
                    String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();

                    NodeList salaryNodeList = element.getElementsByTagName("salary");
                    String salary = salaryNodeList.item(0).getTextContent();

                    String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

                    System.out.println("current element: " + node.getNodeName());
                    System.out.println("user id: " + id);
                    System.out.println("first name: " + firstname);
                    System.out.println("last name: " + lastname);
                    System.out.println("nickname: " + nickname);
                    System.out.printf("salary [currency]: %,.2f [%s]%n%n", Float.parseFloat(salary), currency);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadXmlFile {

    private static final Logger logger = Logger.getLogger(ReadXmlFile.class.getName());
    private static final String FILE_NAME = "/users.xml";

    public static void main(String[] args) {
        ReadXmlFile xmlReader = new ReadXmlFile();
        //xmlReader.readXmlV1();
        xmlReader.readXmlV2();
    }

    private void readXmlV2() {
        logger.log(Level.INFO, "readXmlV2() method start");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try (InputStream inputStream = this.getClass().getResourceAsStream(FILE_NAME)) {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();

            Element element = document.getDocumentElement();
            String nodeName = element.getNodeName();
            logger.log(Level.INFO, "node name: {0}", nodeName);

            NodeList usersNodeList = element.getElementsByTagName("users");
            logger.log(Level.INFO, "userNodeListLength: {0}", usersNodeList.getLength());

            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item instanceof Element element1) {
                    Element element11 = element1;
                    element11.normalize();
                    NodeList lastname = element11.getElementsByTagName("lastname");
                    logger.log(Level.INFO, "--->" + lastname.toString());
                }
                String childNodeName = item.getNodeName();
                logger.log(Level.INFO, "child node: {0}", childNodeName);
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private void readXmlV1() {
        logger.log(Level.INFO, "readXmlV1() method start");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try (InputStream inputStream = this.getClass().getResourceAsStream(FILE_NAME)) {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();

            logger.log(Level.INFO, "Root element: " + document.getDocumentElement().getNodeName());
            logger.log(Level.INFO, "---------");

            NodeList userNode = document.getElementsByTagName("user");

            for (int i = 0; i < userNode.getLength(); i++) {
                Node node = userNode.item(i);
                short nodeType = node.getNodeType();
                if (nodeType == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
                    String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();

                    NodeList salaryNodeList = element.getElementsByTagName("salary");
                    String salary = salaryNodeList.item(0).getTextContent();

                    String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

                    logger.log(Level.INFO, "current element: " + node.getNodeName());
                    logger.log(Level.INFO, "user id: " + id);
                    logger.log(Level.INFO, "first name: " + firstname);
                    logger.log(Level.INFO, "last name: " + lastname);
                    logger.log(Level.INFO, "nickname: " + nickname);
                    logger.log(Level.INFO, "salary [currency]: {0} [{1}]", new Object[]{salary, currency});
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

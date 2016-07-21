package com.example.lesson30;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParserDemo {
    public void parseXMLDocument() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(XMLReader.class.getResourceAsStream("/computerStore.xml"));
            document.normalize();
            NodeList rootNodes = document.getElementsByTagName("computerstore");
            Node rootNode = rootNodes.item(0);
            Element rootElement = (Element) rootNode;
            NodeList notesList = rootElement.getElementsByTagName("computer");
            System.out.println("title" + "\t\t" + "type" + "\t\t" + "amount");
            for (int i = 0; i < notesList.getLength(); i++) {
                Node theNote = notesList.item(i);
                Element noteElement = (Element) theNote;

                Node theTitle = noteElement.getElementsByTagName("title").item(0);
                Element titleElement = (Element) theTitle;
                System.out.print(titleElement.getTextContent());

                Node theType = noteElement.getElementsByTagName("type").item(0);
                Element typeElement = (Element) theType;
                System.out.print("\t" + typeElement.getTextContent());

                Node theAmmount = noteElement.getElementsByTagName("amount").item(0);
                Element ammountElement = (Element) theAmmount;
                System.out.println("\t\t" + ammountElement.getTextContent());
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

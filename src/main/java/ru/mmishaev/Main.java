package ru.mmishaev;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        System.out.println("Hello world!");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = docFactory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element root = document.createElement("staff");
        Element first = document.createElement("employee");
        root.appendChild(first);
        Element id = document.createElement("id");
        id.appendChild(document.createTextNode("1"));
        first.appendChild(id);

        Element firstName = document.createElement("firstName");
        firstName.appendChild(document.createTextNode("John"));
        first.appendChild(firstName);

        Element lastName = document.createElement("lastName");
        lastName.appendChild(document.createTextNode("Smith"));
        first.appendChild(lastName);

        Element country = document.createElement("country");
        id.appendChild(document.createTextNode("USA"));
        first.appendChild(country);

        Element age = document.createElement("age");
        id.appendChild(document.createTextNode("21"));
        first.appendChild(age);

        Element second = document.createElement("employee");
        root.appendChild(second);

        DOMSource dom = new DOMSource(document);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new File("data.xml"));
        transformer.transform(dom, result);
    }
}
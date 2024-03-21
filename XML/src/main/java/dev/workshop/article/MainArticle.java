package dev.workshop.article;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * https://stackoverflow.com/questions/4661154/how-do-i-remove-namespaces-from-xml-using-java-dom
 */
public class MainArticle {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        String xml = Files.readString(Path.of("src/main/resources/articles.xml"));
        xml = removeXmlStringNamespaceAndPreamble(xml);
        System.out.println("xml: " + xml);
    }

    public static String removeXmlStringNamespaceAndPreamble(String xmlString) {
        return xmlString.replaceAll("(<\\?[^<]*\\?>)?", "") /* remove preamble */
                .replaceAll("xmlns.*?(\"|\').*?(\"|\')", "") /* remove xmlns declaration */
                .replaceAll("(<)(\\w+:)(.*?>)", "$1$3") /* remove opening tag prefix */
                .replaceAll("(</)(\\w+:)(.*?>)", "$1$3"); /* remove closing tags prefix */
    }

}
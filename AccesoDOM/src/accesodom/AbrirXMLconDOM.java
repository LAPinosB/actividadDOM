/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author luis
 */
public class AbrirXMLconDOM {

    Document doc;

    public int abrirXMLconDOM(File f) {
        try {
            System.out.println("Abriendo archivo XML y generando DOM...");

            // Creamos una nueva instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Ignorar comentarios y espacios en blanco
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);

            // DocumentBuilder tiene el método parse que crea el modelo DOM en memoria
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(f);

            // Ahora 'doc' apunta al árbol DOM y podemos recorrerlo
            System.out.println("DOM creado con éxito.");
            return 0; // Si el método funciona
        } catch (Exception e) {
            System.out.println(e);
            return -1; // Si el método aborta en algún punto
        }
    }
}

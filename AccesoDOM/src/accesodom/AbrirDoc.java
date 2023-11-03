/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodom;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author luis
 */
public class AbrirDoc {
    Document doc;
    public Document abrirDoc(File f){
        try{
        System.out.println("Abriendo archivo XML y generando DOM...");

            // Creamos una nueva instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Ignorar comentarios y espacios en blanco
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);

            // DocumentBuilder tiene el método parse que crea el modelo DOM en memoria
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = (Document) builder.parse(f);

            // Ahora 'doc' apunta al árbol DOM y podemos recorrerlo
            System.out.println("DOM creado con éxito.");
        
        return doc;
        }catch( IOException | ParserConfigurationException | SAXException e){ //Sino controlamos aqui los posibles errores
            //se realizaria en la parte del Main.
            System.out.println("Error "+e);
            return null;
        }
    }
}

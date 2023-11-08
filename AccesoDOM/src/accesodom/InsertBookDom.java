/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodom;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author luis
 */
public class InsertBookDom {
    
    //Pongo Document porque quiero que los cambios se muestren y modifiquen en el MAIN para visualizarlo si fuera
    //Necesario para comprobar que se ha insertado correctamente
    public Document insertarLibroEnDOM(String titulo, String autor, String fecha, File f, Document doc){
        
        try {
            // las \n y \t los pongo por temas de estetica de visualizacion
            System.out.println("Añadir el libro al arbol DOM:\n \t \t"
                    +titulo+";\n \t \t"+autor+";\n \t \t"+fecha);
            
            //Crear el titulo
            Node nodeTitle = doc.createElement("Titulo");
            Node nodeTitleContent = doc.createTextNode(titulo);
            nodeTitle.appendChild(nodeTitleContent);
            
            //Crear el autor
            Node nodeAuthor = doc.createElement("Autor");
            Node nodeAuthorContent = doc.createTextNode(autor);
            nodeAuthor.appendChild(nodeAuthorContent);
            
            //Crear el Libro
            Node nodeBook = doc.createElement("Libro");
            ((Element)nodeBook).setAttribute("publicado", fecha);
            nodeBook.appendChild(nodeTitle);
            nodeBook.appendChild(nodeAuthor);
            
            //Append Book to the root
            nodeBook.appendChild(doc.createTextNode("\n"));
            
            //ESTO LO HICE ANTES DE VER EN CLASE LA CLASE DE GUARDAR EN EL ARCHIVO XML
            // Crear un objeto Transformer para guardar el documento DOM en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Crear un origen (source) DOM a partir del documento
            DOMSource source = new DOMSource(doc);

            // Crear un resultado (result) Stream para escribir en el archivo
            StreamResult result = new StreamResult(f);
            
             // Realizar la transformación para guardar el documento en el archivo
            transformer.transform(source, result);
            
            //Nos situamos en el primer nodo hijo
            Node root = doc.getFirstChild();
            //Añadimos Lo que vamos a añadir nuevo y se situara en el segundo nodo.( Esto lo hice por probar)
            root.appendChild(nodeBook);
            //Sout de que se ha añadido correctamente.
            System.out.println("Libro Insertado en DOM");
            //Devolvemos el Document que esta manipulado con los cambios realizados, para poder visualizarlo desde el main.
            return doc;
            
        } catch (Exception e) {
            System.out.println("Mensaje de Error: "+e.getMessage());
            return doc;
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodom;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author luis
 */
public class InsertBookDom {
    public int insertarLibroEnDOM(String titulo, String autor, String fecha, File f, Document doc){
        
        try {
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
            
            Node root = doc.getFirstChild();
            root.appendChild(nodeBook);
            System.out.println("Libro Insertado en DOM");
            return 0;
            
        } catch (Exception e) {
            System.out.println("Mensaje de Error: "+e.getMessage());
            return -1;
        }
    }
}

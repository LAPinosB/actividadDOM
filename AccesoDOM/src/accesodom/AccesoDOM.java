package accesodom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Esto se descomentara cuando usemos la libreria dom4j sino hay conflictos con las librerias
//Anteriores de DOM y SAX
/*
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;
*/
import org.w3c.dom.Document;
import java.io.File;

/**
 *
 * @author luis
 */
public class AccesoDOM {

    public static void main(String[] args) {
        Document doc;
        // TODO code application logic here
       
        AbrirXMLconDOM abrirXMLconDOM = new AbrirXMLconDOM();        
        //LeerAccesoDom leerAccesoDom = new LeerAccesoDom();
        InsertBookDom insertBookDom = new InsertBookDom();
        AbrirDoc abrirDoc = new AbrirDoc();
        DeleteNode deleteNode = new DeleteNode();
        File file = new File("Libros.xml"); //El archivo este a nivel del proyecto 
        if(abrirXMLconDOM.abrirXMLconDOM(file)==0){
            //Lectura de un archivo xml con DOM
            /*
            leerAccesoDom.mostrarLibros(abrirXMLconDOM.doc);
            leerAccesoDom.mostrarNodos(abrirXMLconDOM.doc);
            */
            //Lo hemos creado para llamarlo desde parametro en insertarLibroEnDOM(...)
            doc = abrirDoc.abrirDoc(file);
            //leerAccesoDom.mostrarNodos(abrirXMLconDOM.doc, "********");
            insertBookDom.insertarLibroEnDOM("Cien Años de Soledad", "Gabriel Garcia Marquez", "1980", file, doc);
            deleteNode.deleteNode("El Libro de la Jungla", doc);
        }else{
            System.out.println("El archivo DOM no se abrio correctamente");
        }
        
        //https://dom4j.github.io/ 
        /*
        try {
            SAXReader reader = new SAXReader();
            // Reemplaza con la ubicación de tu archivo XML
            Document document = reader.read("Libros.xml"); 

            Element root = document.getRootElement();
            mostrarNodos(root, "");
            
            //La biblioteca Dom4j no proporciona un método close() en la clase SAXReader para cerrar la lectura de un documento XML.
           //Por eso no he puesto finally.

        } catch (DocumentException e) {
            e.printStackTrace();
        } */
    }
}
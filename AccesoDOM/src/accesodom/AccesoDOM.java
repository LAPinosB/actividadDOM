package accesodom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static accesodom.Dom4J.mostrarNodos;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author luis
 */
public class AccesoDOM {

    public static void main(String[] args) {
        // TODO code application logic here
        /*
        AbrirXMLconDOM abrirXMLconDOM = new AbrirXMLconDOM();
        LeerAccesoDom leerAccesoDom = new LeerAccesoDom();
        File file = new File("Libros.xml"); //El archivo este a nivel del proyecto 
        if(abrirXMLconDOM.abrirXMLconDOM(file)==0){
            //leerAccesoDom.mostrarLibros(abrirXMLconDOM.doc);
            leerAccesoDom.mostrarNodos(abrirXMLconDOM.doc);
            //leerAccesoDom.mostrarNodos(abrirXMLconDOM.doc, "********");
        }else{
            System.out.println("El archivo DOM no se abrio correctamente");
        }
         */
        
        //https://dom4j.github.io/ 
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
        }
    }
}

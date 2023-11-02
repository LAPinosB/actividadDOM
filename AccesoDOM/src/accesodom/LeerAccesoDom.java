/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodom;

import org.w3c.dom.*;

/**
 *
 * @author luis
 */
public class LeerAccesoDom {

    public void mostrarNodos(Node nodo) {
        mostrarNodosRecursivo(nodo);
    }

    private void mostrarNodosRecursivo(Node nodo) {
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            Element elemento = (Element) nodo;
            String nodoName = nodo.getNodeName();
            if (nodoName.equals("Titulo") || nodoName.equals("Autor")) {
                System.out.println(nodoName + ": " + nodo.getTextContent());
            } else {
                System.out.println(nodoName);
            }

            NamedNodeMap atributos = elemento.getAttributes();
            for (int i = 0; i < atributos.getLength(); i++) {
                Node atributo = atributos.item(i);
                System.out.println("  " + atributo.getNodeName() + ": " + atributo.getNodeValue());
            }
        }

        NodeList hijos = nodo.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            mostrarNodosRecursivo(hijos.item(i));
        }
    }

    public void mostrarLibros(Document doc) {
        NodeList libros = doc.getElementsByTagName("Libro");

        for (int i = 0; i < libros.getLength(); i++) {
            Node libro = libros.item(i);
            if (libro.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoLibro = (Element) libro;
                String titulo = elementoLibro.getElementsByTagName("Titulo").item(0).getTextContent();
                String autor = elementoLibro.getElementsByTagName("Autor").item(0).getTextContent();
                String publicado = elementoLibro.getAttribute("publicado");
                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
                System.out.println("Año de publicación: " + publicado);
                System.out.println("------");
            }
        }
    }
}

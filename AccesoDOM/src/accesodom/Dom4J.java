/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodom;

import org.dom4j.Element;
import org.dom4j.Node;

/**
 *
 * @author luis
 */
public class Dom4J {

    //Busque documentacion de como usar dom4j dejo el link en comentarios
    public static void mostrarNodos(Element elemento) {
        //https://www.tabnine.com/code/java/methods/org.dom4j.Element/node
        //Se muestra el nombre del elemento actual y su contenido
        System.out.println(elemento.getName() + ": " + elemento.getTextTrim());

        ////iteramos a través de los nodos secundarios del elemento actual utilizando un bucle for-each, 
        //se puede hacer con un for como sale en la pagina del profesor: https://dom4j.github.io/ 
        for (Node nodo : elemento.content()) {
            if (nodo instanceof Element) {
                //Utilizamos recursividad, para buscar recurrentemente los nodos en nuestro caso 1º) Libros: 2º Linro: ... 
                mostrarNodos((Element) nodo);
            }
        }
    }

}

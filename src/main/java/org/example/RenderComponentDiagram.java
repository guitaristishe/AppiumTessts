package org.example;

import guru.nidi.graphviz.engine.Graphviz;

import java.io.File;
import java.io.IOException;

public class RenderComponentDiagram {
    public static void main(String[] args) {
        try {
            File dotFile = new File("MySwagLabsComponentDiagram.dot");
            File imgFile = new File("MySwagLabsComponentDiagram.png");
            Graphviz.fromFile(dotFile).render(guru.nidi.graphviz.engine.Format.PNG).toFile(imgFile);
            System.out.println("Diagram rendered as 'MySwagLabsComponentDiagram.png'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

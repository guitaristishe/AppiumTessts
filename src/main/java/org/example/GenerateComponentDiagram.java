package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.IOException;


public class GenerateComponentDiagram {
    public static void main(String[] args) {
        String dotFilePath = "MySwagLabsComponentDiagram.dot";
        String dotContent =
                "digraph MySwagLabsComponentDiagram {\n" +
                        "    rankdir=LR;\n" +
                        "    node [shape=component, style=filled, color=lightblue];\n" +
                        "\n" +
                        "    // Components\n" +
                        "    TestClass1 [label=\"MySwagLabsTest\"];\n" +
                        "    TestClass2 [label=\"Hooks\"];\n" +
                        "    LoginPage [label=\"LoginPage\"];\n" +
                        "    ProductPage [label=\"ProductPage\"];\n" +
                        "    CartPage [label=\"CartPage\"];\n" +
                        "    CheckoutPage [label=\"CheckoutPage\"];\n" +
                        "    DriverManager [label=\"DriverManager\"];\n" +
                        "    Properties [label=\"Properties\"];\n" +
                        "    TestContext [label=\"TestContext\"];\n" +
                        "    AndroidDriver [label=\"AndroidDriver\", shape=ellipse, style=filled, color=lightyellow];\n" +
                        "\n" +
                        "    // Relationships\n" +
                        "    TestClass1 -> LoginPage [label=\"uses\"];\n" +
                        "    TestClass1 -> ProductPage [label=\"uses\"];\n" +
                        "    TestClass1 -> CartPage [label=\"uses\"];\n" +
                        "    TestClass1 -> CheckoutPage [label=\"uses\"];\n" +
                        "    TestClass2 -> TestContext [label=\"uses\"];\n" +
                        "    LoginPage -> AndroidDriver [label=\"interacts with\"];\n" +
                        "    ProductPage -> AndroidDriver [label=\"interacts with\"];\n" +
                        "    CartPage -> AndroidDriver [label=\"interacts with\"];\n" +
                        "    CheckoutPage -> AndroidDriver [label=\"interacts with\"];\n" +
                        "    DriverManager -> AndroidDriver [label=\"manages\"];\n" +
                        "    TestContext -> DriverManager [label=\"uses\"];\n" +
                        "    TestContext -> Properties [label=\"uses\"];\n" +
                        "}";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dotFilePath))) {
            writer.write(dotContent);
            System.out.println("DOT file created: " + dotFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



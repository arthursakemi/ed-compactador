/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import compressor.Compressor;
import compressor.LinkedList;
import compressor.Node;

/**
 *
 * @author Sakemi, Marcelo Arthur
 */
public class Main {

    public static void main(String[] args) {
        String inputFile = "texto-inicial.txt";
        LinkedList text = Compressor.readInputFile(inputFile);

        for (Node n = text.getFirst(); n != null; n = n.getNext()) {
            String compressedLine = Compressor.compressLine(n.getElement());
            System.out.println(compressedLine);
        }
    }
}

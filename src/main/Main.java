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
        LinkedList words = new LinkedList();
        LinkedList compressedFile = new LinkedList();
        
        for (Node n = text.getFirst(); n != null; n = n.getNext()) {
            Compressor.compressLine(n.getElement(), words, compressedFile);
            compressedFile.addAtEnd("\n");
        }
        
        System.out.println(compressedFile);
    }
}

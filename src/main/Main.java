/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import compressor.Compressor;
import compressor.LinkedList;

/**
 *
 * @author Sakemi, Marcelo Arthur
 */
public class Main {

    public static void main(String[] args) {
        String inputFile = "texto-inicial.txt";
        String compressedFileName = "texto-compactado.txt";
        String decompressedFileName = "texto-descompactado.txt";

        LinkedList words = new LinkedList();

        Compressor.compressFile(inputFile, compressedFileName, words);

        Compressor.decompressFile(compressedFileName, decompressedFileName, words);

    }

}

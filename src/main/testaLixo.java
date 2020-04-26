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
 * @author Marcelo
 */
public class testaLixo {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        lista.addAtEnd("1");
        lista.addAtEnd("8");
        lista.addAtEnd("5");
        lista.addAtEnd("3");
        lista.addAtEnd("1");
        lista.addAtEnd("13");
        lista.addAtEnd("Mary");
        System.out.println(lista);
        
        System.out.println(lista.linearSearch("Mary"));
    }
}

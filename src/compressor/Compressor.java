/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sakemi
 */
public class Compressor {

    public static LinkedList readInputFile(String inputFile) {
        LinkedList file = new LinkedList();

        try {
            FileReader fileReader = new FileReader(inputFile);

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + inputFile + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + inputFile + "'");
        }

        return file;
    }

}

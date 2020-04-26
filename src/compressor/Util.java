/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sakemi
 */
public class Util {

    public static boolean writeOutputFile(String fileName, String text) {
        try {

            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + fileName + "'");
            return false;
        }
        return true;
    }

}

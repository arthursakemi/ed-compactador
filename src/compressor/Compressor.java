/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sakemi
 */
public class Compressor {

    public static LinkedList readInputFile(String inputFile) {
        LinkedList file = new LinkedList();
        
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                file.addAtEnd(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + inputFile + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + inputFile + "'");
        }

        return file;
    }

    public static void compressLine(String line, LinkedList words, LinkedList outputFile) {
        Pattern wordsPattern = Pattern.compile("([A-Z]+)|([^A-Z]+)", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordsPattern.matcher(line);
        
        while (wordMatcher.find()) {
            String word = wordMatcher.group();
            if(Character.isLetter(word.charAt(0))){
                manageWord(word, words, outputFile);
            } else {
                outputFile.addAtEnd(word);
            }
        }
    }
    
    public static void manageWord (String word, LinkedList words, LinkedList outputFile) {
        int i = words.linearSearch(word);
        
        if(i >= 0) {
            words.removeFrom(i);
            outputFile.addAtEnd(String.valueOf(i + 1));
        } else {
            outputFile.addAtEnd(word);
        }
        words.addAtStart(word);
    }
}

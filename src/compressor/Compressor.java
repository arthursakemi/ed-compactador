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

    public static String compressLine(String line) {
        Pattern words = Pattern.compile("([A-Z]+)", Pattern.CASE_INSENSITIVE);
        Pattern notWords = Pattern.compile("([^A-Z]+)", Pattern.CASE_INSENSITIVE);

        Matcher wordMatcher = words.matcher(line);
        Matcher specialCharMatcher = notWords.matcher(line);

        String compressedLine = "";

        while (wordMatcher.find() && specialCharMatcher.find()) {
            if (wordMatcher.end() < specialCharMatcher.end()) {
                System.out.print(wordMatcher.group());
                System.out.print(specialCharMatcher.group());
            } else {
                System.out.print(specialCharMatcher.group());
                System.out.print(wordMatcher.group());
            }
        }

        while (wordMatcher.find()) {
            System.out.print(wordMatcher.group());
        }

        while (specialCharMatcher.find()) {
            System.out.print(specialCharMatcher.group());
        }

        return compressedLine;

    }

}

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

    public static void decompressFile(String compressedFileName, String decompressedFileName, LinkedList words) {
        LinkedList compressedText = Compressor.readCompressedFile(compressedFileName);
        LinkedList decompressedFile = new LinkedList();

        for (Node n = compressedText.getFirst(); n != null; n = n.getNext()) {
            Compressor.decompressLine(n.getElement(), words, decompressedFile);
            decompressedFile.addAtStart("\n");

        }

        decompressedFile.addAtEnd("0");

        System.out.println(decompressedFile);

        Util.writeOutputFile(decompressedFileName, decompressedFile.toString());

    }

    public static void compressFile(String inputFile, String compressedFileName, LinkedList words) {

        LinkedList text = Compressor.readInputFile(inputFile);
        LinkedList compressedFile = new LinkedList();

        for (Node n = text.getFirst(); n != null; n = n.getNext()) {
            Compressor.compressLine(n.getElement().toString(), words, compressedFile);
            compressedFile.addAtEnd("\n");
        }

        System.out.println(compressedFile);

        Util.writeOutputFile(compressedFileName, compressedFile.toString());

    }

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
            if (Character.isLetter(word.charAt(0))) {
                manageWord(word, words, outputFile);
            } else {
                outputFile.addAtEnd(word);
            }
        }
    }

    public static void manageWord(String word, LinkedList words, LinkedList outputFile) {
        int i = words.linearSearch(word);

        if (i >= 0) {
            words.removeFrom(i);
            outputFile.addAtEnd(String.valueOf(i + 1));
        } else {
            outputFile.addAtEnd(word);
        }
        words.addAtStart(word);
    }

    public static LinkedList readCompressedFile(String compressedFile) {
        LinkedList file = new LinkedList();

        try {
            FileReader fileReader = new FileReader(compressedFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                file.addAtStart(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + compressedFile + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + compressedFile + "'");
        }

        return file;
    }

    public static void decompressLine(String line, LinkedList words, LinkedList outputFile) {

        String reversedLine = reverseLine(line);

        Pattern wordsPattern = Pattern.compile("([A-Z]+)|([^A-Z0-9]+)|([1-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordsPattern.matcher(reversedLine);

        Node wordNode;

        while (wordMatcher.find()) {
            wordNode = words.getFirst();
            String word = wordNode.getElement();
            String currentWord = wordMatcher.group();

            if (Character.isDigit(currentWord.charAt(0))) {
                words.removeFromStart();
                words.addAtPosition(word, Integer.valueOf(currentWord) - 1);
                outputFile.addAtStart(word);

            } else if (!Character.isLetter(currentWord.charAt(0))) {
                outputFile.addAtStart(currentWord);
            } else {
                outputFile.addAtStart(currentWord);
                words.removeFromStart();
            }
        }
    }

    public static String reverseLine(String line) {
        Pattern wordsPattern = Pattern.compile("([A-Z]+)|([^A-Z0-9]+)|([1-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordsPattern.matcher(line);

        String reversedLine = "";

        while (wordMatcher.find()) {
            reversedLine = wordMatcher.group() + reversedLine;
        }

        return reversedLine;
    }

}

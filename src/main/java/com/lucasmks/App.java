package com.lucasmks;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class App 
{
    public static void main( String[] args )
    {
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("URL de entrada: ");
            String inputUrl = sc.nextLine().trim();

            System.out.println("Frase a procurar:");
            String inputText = sc.nextLine().trim().toLowerCase();

            String content = fetchUrl(inputUrl).toLowerCase();

            int phraseCount = countOccurrences(content, inputText);
            System.out.println("A frase \"" + inputText + "\" repete " + phraseCount + " vezes.");

            String[] words = inputText.split("\\s+");
            for(String word : words){
                int wordCount = countOccurrences(content, word);
                System.out.println("A palavra \"" + word + "\" repete " + wordCount + " vezes.");
            }

            sc.close();
        } catch (Exception e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    private static String fetchUrl(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        return doc.text().toLowerCase();
    }

    private static int countOccurrences(String text, String target) {
        int count = 0, idx = 0;

        while ((idx = text.indexOf(target, idx)) != -1) {
            count++;
            idx += target.length();
        }

        return count;
    }
}

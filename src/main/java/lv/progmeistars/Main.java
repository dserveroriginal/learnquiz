package lv.progmeistars;

import lv.progmeistars.parser.CsvParser;
import lv.progmeistars.parser.WordTranslationTypeData;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        var parser = new CsvParser();

        try {
            var file = Main.class.getClassLoader().getResource("words.csv").getFile();
            var list = parser.parseFile(new File(file));

            for (WordTranslationTypeData data : list) {
                System.out.println(data);
            }
        } catch (NullPointerException e){
            System.out.println("y r wrong");
        }


    }
}

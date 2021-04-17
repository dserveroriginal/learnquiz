package lv.progmeistars;

import lv.progmeistars.parser.CommonTypeData;
import lv.progmeistars.parser.CsvParser;

import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        var parser = new CsvParser();

        try {

            Scanner scanner = new Scanner(System.in);

            if (scanner.nextInt() == 1) {
                var file = Main.class.getClassLoader().getResource("words.csv").getFile();
                var list = parser.parseFile(new File(file));

                for (CommonTypeData data : list) {
                    System.out.println(data);
                }
            } else {

                var scoreFile = Main.class.getClassLoader().getResource("score.csv").getFile();
                var scoreList = parser.parseFile(new File(scoreFile));

                System.out.println();

                for (CommonTypeData data : scoreList) {
                    System.out.println(data);
                }
            }
        } catch (NullPointerException e){
            System.out.println("y r wrong");
        }


    }
}

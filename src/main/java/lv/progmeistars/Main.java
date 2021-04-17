package lv.progmeistars;

import lv.progmeistars.menu.Menu;
import lv.progmeistars.parser.CommonTypeData;
import lv.progmeistars.parser.CsvParser;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        var menu = new Menu();
        fileOutput(menu.mainMenu());

    }

    private static void fileOutput(StringBuilder fileName) {
        var parser = new CsvParser();

        try {

            var file = Main.class.getClassLoader().getResource(String.valueOf(fileName)).getFile();
            var list = parser.parseFile(new File(file));

            for (CommonTypeData data : list) {
                System.out.println(data);//"score.csv" "words.csv"
            }
        } catch (NullPointerException e){
            System.out.println("y r wrong");
        }


    }
}

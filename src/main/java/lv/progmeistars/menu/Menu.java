package lv.progmeistars.menu;

import java.util.Scanner;

public class Menu {

    public StringBuilder mainMenu(){

        Scanner scanner = new Scanner(System.in);
        StringBuilder userInput = new StringBuilder();

        System.out.println("Enter menu type");
        userInput.append("File output");//scanner.nextLine()

        return(menuTypes(userInput));
    }

    private StringBuilder menuTypes(StringBuilder menuType) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder userInput = new StringBuilder();

        if (menuType.toString().equals("File output")) {

            System.out.println("Enter menu item"+menuType);

            userInput.append("Score output");//"Word output" scanner.nextLine()

            StringBuilder fileName = new StringBuilder() ;

            if (userInput.toString().equals("Word output")) {
                fileName.append("words.csv");
            } else if (userInput.toString().equals("Score output")){
                fileName.append("score.csv");
            }
            return fileName;

        } else {
            return menuType;
        }
    }

}

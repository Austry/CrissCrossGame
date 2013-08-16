import game.modes.*;

import java.util.Scanner;




public class Main {
    private static final int  FIELD_SIZE=3;
    private static CrissCrossGame newGame;
    public static Scanner scanner = CrissCrossGame.scanner;

    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Choose a game type:");
        System.out.println("1. Player VS Player");
        System.out.println("2. Player VS II");
        System.out.println("--------------------");



        int s = newGame.chooseGameType();
        System.out.println(s);
        switch(s){
            case 1:
                newGame = new PlayerVsPlayerGame(FIELD_SIZE);
                break;
            case 2:
                newGame = new PlayerVsAIGame(FIELD_SIZE);
                break;
            default:
                break;
        }
        newGame.showRules();
        newGame.play();

        requestForGameRestart();


    }



    private static void requestForGameRestart() {
        System.out.println("Do you wanna restart game? (y/n)");

        String tempRestartStr = scanner.nextLine();
        if(tempRestartStr.equals("y")){
            main(null);
        }
        if(tempRestartStr.equals("n")){
            System.out.println("Bye!");

        }
        else{
            System.out.println("Wrong input");
            requestForGameRestart();
        }
    }



}

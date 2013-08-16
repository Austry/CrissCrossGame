package game.modes;

import exceptions.CellNotEmptyException;
import exceptions.NoAvailableMovesException;
import exceptions.WrongInputException;
import game.parts.Field;
import game.parts.Player;

import java.util.Scanner;

public abstract class CrissCrossGame {

    private static final int MAX_GAME_MODES = 2;

    public static Scanner scanner = new Scanner(System.in);
    protected Field gameField;
    protected Player firstPlayer, secondPlayer,currentPlayer;

    public CrissCrossGame(int fieldSize){
        gameField = new Field(fieldSize);
        firstPlayer = new Player();
        secondPlayer = new Player();
        currentPlayer = firstPlayer;
    }

    public void play(){
        while(true){
            try{
                if(this.turnRealisation())  {
                    break;
                }

            } catch (WrongInputException e){

                System.out.println("Wrong move input!");
                System.out.println("Input must be greater than zero and less than " + gameField.getFieldSize());
                System.out.println("Try again!");

            } catch (CellNotEmptyException ex){

                System.out.println("Cell already taken!");
                System.out.println("Do another move");

            } catch (NumberFormatException e){

                System.out.println("You must enter numbers!");

            } catch (ArrayIndexOutOfBoundsException e){

                System.out.println("Required at least two numbers");

            } catch (NoAvailableMovesException e) {

                System.out.println("All cells filed!");
                System.out.println("Game over!");
                break;
            }
        }
    }

    public static  int chooseGameType(){
        System.out.print("Write a number of game type:");
        int tempGameTypeFlag = 0;
        try{
            tempGameTypeFlag = Integer.valueOf(scanner.nextLine());
            if(tempGameTypeFlag > 0 && tempGameTypeFlag <= MAX_GAME_MODES){
                //System.out.println(tempGameTypeFlag);
                return tempGameTypeFlag;
            }
        }
        catch (Exception e){
            System.out.println("Wrong input!");
            System.out.println("Type integer!");
            chooseGameType();
        }
        return 0;
    }



    protected void nextPlayer() {
        currentPlayer = (currentPlayer.equals(firstPlayer)) ? secondPlayer :  firstPlayer;
    }

    public abstract void showRules();
    protected abstract boolean turnRealisation() throws WrongInputException, NoAvailableMovesException, CellNotEmptyException;
}

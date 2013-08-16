package game.modes;

import exceptions.CellNotEmptyException;
import exceptions.NoAvailableMovesException;
import exceptions.WrongInputException;
import game.parts.State;


public class PlayerVsPlayerGame extends CrissCrossGame {
    private int tempHorizontalVar, tempVerticalVar ;
    private String playerInput;
    private String[] splitedInput ;

    public PlayerVsPlayerGame(int fieldSize){
        super(fieldSize);

        System.out.println("Plz,enter first player name: ");
        firstPlayer.setPlayersName(scanner.nextLine());
        System.out.println("Plz, enter second player name: ");
        secondPlayer.setPlayersName(scanner.nextLine());

        firstPlayer.setPlayersSymbol(State.X);
        secondPlayer.setPlayersSymbol(State.O);
        System.out.println(firstPlayer.getPlayersName()+" your symbol " + firstPlayer.getPlayersSymbol());
        System.out.println(secondPlayer.getPlayersName()+" your symbol " + secondPlayer.getPlayersSymbol());
    }

    @Override
    protected boolean turnRealisation() throws WrongInputException, NoAvailableMovesException, CellNotEmptyException {



        System.out.println(currentPlayer.getPlayersName() + " turn");
        playerInput = scanner.nextLine();
        splitedInput = playerInput.split(" ");
        tempHorizontalVar = Integer.valueOf(splitedInput[0]);
        tempVerticalVar = Integer.valueOf(splitedInput[1]);

        gameField.doMove(tempHorizontalVar,tempVerticalVar,currentPlayer);

        gameField.printField();

        if(gameField.isPlayerWin(currentPlayer.getPlayersSymbol())){
            System.out.println(currentPlayer.getPlayersName() + " wins!");
            return true;
        }
        else{
             nextPlayer();
            return false;
        }


    }
    @Override
    public void showRules(){
        System.out.println("Enter two integer numbers divided by space");

    }
}

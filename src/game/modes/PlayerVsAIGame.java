package game.modes;

import exceptions.CellNotEmptyException;
import exceptions.NoAvailableMovesException;
import exceptions.WrongInputException;


public class PlayerVsAIGame extends CrissCrossGame {
    public PlayerVsAIGame(int fieldSize){
     super(fieldSize);

    }

    @Override
    public void showRules() {
        System.out.println("There is no rules");
    }

    @Override
    protected boolean turnRealisation() throws WrongInputException, NoAvailableMovesException, CellNotEmptyException {
        System.out.println("It's not implemented");
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

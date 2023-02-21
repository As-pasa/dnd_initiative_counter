package CommandInterface.Commands;

import models.TurnModel;

public class DefaultHandler implements Command{
    @Override
    public boolean argCheck(String[] pr) {
        return true;
    }

    @Override
    public void apply(TurnModel model) {
        System.out.println("Unrecognized command or argument set");
    }
}

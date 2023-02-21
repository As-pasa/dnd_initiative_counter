package CommandInterface.Commands;

import models.TurnModel;
// .
public class EndTurnCommand implements Command{
    @Override
    public boolean argCheck(String[] pr) {
        if(!(pr.length==1))return false;
        return(pr[0].equals("."));
    }

    @Override
    public void apply(TurnModel model) {
        model.endTurn();
        System.out.println(model.getCurrent().getStr());
    }
}

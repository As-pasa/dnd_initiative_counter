package CommandInterface.Commands;

import models.TurnModel;

//crt

public class CurrentTurnCommand implements Command{
    @Override
    public boolean argCheck(String[] pr) {
     if(!(pr.length==1))return false;
     return pr[0].equals("crt");
    }

    @Override
    public void apply(TurnModel model) {
        System.out.println(model.getCurrent().getStr());
    }
}

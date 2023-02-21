package CommandInterface.Commands;

import Exceptions.TurnOrderException;
import models.InitiativeEntity;
import models.TurnModel;
//rm morn
public class RmCommand implements Command{
    String name="";
    @Override
    public boolean argCheck(String[] pr) {
        if(!(pr.length==2))return false;
        if(pr[0].equals("rm")){name=pr[1]; return true;} ;
        return false;
    }

    @Override
    public void apply(TurnModel model) {
        try {
            model.removeEntity(name);

        } catch (TurnOrderException e) {
            System.out.println(e.getMessage());
        }
    }
}

package CommandInterface.Commands;

import Exceptions.TurnOrderException;
import models.InitiativeEntity;
import models.TurnModel;

import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive


public class createEntityCommand implements Command{

    private String name;
    private int hits;
    private int ac;
    private int initiative;




    @Override
    public boolean argCheck(String[] commandSplit) {



        if(commandSplit.length!=4 && commandSplit.length !=5){return false;  }
        if(!commandSplit[0].equals("create") && !commandSplit[0].equals("cr")){return false;}
        name=commandSplit[1];

        try{
            hits=Integer.parseInt(commandSplit[2]);
        }
        catch (NumberFormatException nfe){return false;}

        try{
            ac=Integer.parseInt(commandSplit[3]);
        }
        catch (NumberFormatException nfe){return false;}

        if(commandSplit.length==5){
            try{
                initiative=Integer.parseInt(commandSplit[4]);
            }
            catch (NumberFormatException nfe){return false;}
        }
        else{
            initiative = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        }
        return true;
    }

    @Override
    public void apply(TurnModel model) {


        try{
            model.addEntity(new InitiativeEntity(initiative,ac,hits,name));
        }
        catch (TurnOrderException toe){
            System.out.println(toe.getMessage());
        }



    }
}

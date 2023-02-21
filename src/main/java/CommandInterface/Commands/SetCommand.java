package CommandInterface.Commands;

import Exceptions.TurnOrderException;
import models.InitiativeEntity;
import models.TurnModel;

import java.util.ArrayList;
import java.util.Set;

//set morn hp 5
public class SetCommand implements Command{

    private String traitToChange;
    private ArrayList<String> changeAble;
    private String name;
    private int value;

    public SetCommand() {
        changeAble = new ArrayList<>();
        changeAble.add("ht");
        changeAble.add("in");
        changeAble.add("ac");
    }
    @Override
    public boolean argCheck(String[] pr) {
        if(pr.length!=4)return false;
        if(!pr[0].equals("set") && !pr[0].equals("st"))return false;
        if(!changeAble.contains(pr[2]))return false;
        name=pr[1];
        traitToChange=pr[2];
        try {
            value=Integer.parseInt(pr[3]);
        }
        catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    @Override
    public void apply(TurnModel model) {
        InitiativeEntity ent;
        try{
            ent=model.getByName(name);
        }
        catch (TurnOrderException ex){
            System.out.println(ex.getMessage());
            return;
        }
        switch (traitToChange) {
            case "ht" -> ent.setHits(value);
            case "ac" -> ent.setAc(value);
            case "in" -> ent.setInitiative(value);
            default -> System.out.println("unexpected error in trait coding");
        }
    }
}

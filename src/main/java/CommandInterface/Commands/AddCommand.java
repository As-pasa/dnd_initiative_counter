package CommandInterface.Commands;

import Exceptions.TurnOrderException;
import models.InitiativeEntity;
import models.TurnModel;

import java.util.ArrayList;

// add morn ac 5
// sub morn ac 5
public class AddCommand implements Command{

    private String traitToChange;
    private ArrayList<String> changeAble;
    private String name;
    private int value;

    public AddCommand(){
        changeAble=new ArrayList<>();
        changeAble.add("ht");
        changeAble.add("in");
        changeAble.add("ac");
    }

    @Override
    public boolean argCheck(String[] pr) {
        if(pr.length!=4 && pr.length!=5)return false;
        if(!pr[0].equals("add") && !pr[0].equals("sub"))return false;
        name=pr[1];
        if(!changeAble.contains(pr[2])){
            return false;
        }
        else traitToChange=pr[2];
        try{
            value=Integer.parseInt(pr[3]);
        }
        catch (NumberFormatException ex){
            return false;
        }
        if(pr[0].equals("sub"))value=-value;
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
        switch (traitToChange){
            case "ht":ent.setHits(ent.getHits()+value); break;
            case "ac":ent.setAc(ent.getAc()+value);break;
            case "in":ent.setInitiative(ent.getInitiative()+value);break;
            default:
                System.out.println("unexpected error in trait coding");
        }
    }
}

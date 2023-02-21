package CommandInterface.Commands;

import Exceptions.TurnOrderException;
import models.InitiativeEntity;
import models.TurnModel;

import java.util.ArrayList;


public class InfoCommand implements Command{
    private String selector="";
    @Override
    public boolean argCheck(String[] pr) {
        if(pr.length!=2 && pr.length!=1){
            return false;
        }
        if(!pr[0].equals("info") &&!pr[0].equals("inf") &&!pr[0].equals("ord")){
            return false;
        }
        if(pr.length==1){
            if(pr[0].equals("ord")){selector="ord";}
            else selector="";
        }
        else selector=pr[1];

        return true;
    }

    @Override
    public void apply(TurnModel model) {
        ArrayList<InitiativeEntity> a;

        switch (selector){
            case "ord"->{a=model.getOrder();}
            case ""->{  a = model.getAllEntities();}
            default -> { try {
                a=new ArrayList<>();
                a.add(model.getByName(selector));
            } catch (TurnOrderException e) {
                System.out.println(e.getMessage());
                return;
            }}
        }

        StringBuilder builder=new StringBuilder();
        builder.append(String.format("%10s%4s%4s%4s%n",new String[]{"name","IN","AC","HI"}));
        for (var entity:a) {
            builder.append(entity.getStr());
        }
        System.out.println(builder);
        }

}

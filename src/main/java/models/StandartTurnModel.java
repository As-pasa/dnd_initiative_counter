package models;

import Exceptions.TurnOrderException;

import java.util.ArrayList;

public class StandartTurnModel implements TurnModel{
    private OrderSet allEntities;
    private TurnOrder round;
    private InitiativeEntity current;

    public StandartTurnModel(){
        allEntities=new OrderSet();
        round=allEntities.GetRound();
    }

    @Override
    public InitiativeEntity getCurrent() {
        if(current==null){
            endTurn();
        }
        return current;
    }

    @Override
    public void endTurn() {
        try {
            current=round.next();
        }
        catch (TurnOrderException toe){
            if (toe.getMessage().equals("Index Out Of Bound")){
                System.out.println("new round started");
                round=allEntities.GetRound();
                try {
                    current=round.next();
                }
                catch (TurnOrderException ex){
                    System.out.println("the ancient dread has rised");
                }
            }
        }

    }

    @Override
    public void addEntity(InitiativeEntity ent)throws TurnOrderException {
        allEntities.add(ent);
    }

    @Override
    public void removeEntity(String name) throws TurnOrderException{
        allEntities.remove(name);
        round.removeByName(name);
    }

    @Override
    public ArrayList<InitiativeEntity> getAllEntities() {
        return allEntities.getData();
    }

    @Override
    public InitiativeEntity getByName(String name) throws TurnOrderException {
        return allEntities.getFromName(name);
    }

    @Override
    public ArrayList<InitiativeEntity> getOrder() {
        return round.getOrderList();
    }
}

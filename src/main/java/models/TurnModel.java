package models;

import Exceptions.TurnOrderException;

import java.util.ArrayList;

public interface TurnModel {
    InitiativeEntity getCurrent();
    void endTurn();
    void addEntity(InitiativeEntity ent) throws TurnOrderException;
    void removeEntity(String name) throws TurnOrderException;
    ArrayList<InitiativeEntity> getAllEntities();
    InitiativeEntity getByName(String name) throws TurnOrderException;
    ArrayList<InitiativeEntity> getOrder();


}

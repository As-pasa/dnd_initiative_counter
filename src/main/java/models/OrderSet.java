package models;

import Exceptions.TurnOrderException;

import java.util.ArrayList;
import java.util.TreeSet;

public class OrderSet {
    private TreeSet<String> naming;
    private TreeSet<InitiativeEntity>data;

    public void add(InitiativeEntity ent) throws TurnOrderException {
        if (naming.contains(ent.getName())) {
            throw new TurnOrderException(2);
        }

        naming.add(ent.getName());
        data.add(ent);
    }

    public void remove(String name)throws TurnOrderException{
        if (naming.contains(name)) {
            for (var a:data) {
                if(a.getName().equals(name)){
                    data.remove(a);
                    naming.remove(name);
                    return;
                }
            }
        }
        throw new TurnOrderException(0);
    }

    public TurnOrder GetRound(){
        return new TurnOrder(new ArrayList<>(data));
    }
    public OrderSet() {
        this.data = new TreeSet<>();
        this.naming=new TreeSet<>();
    }
    public ArrayList<InitiativeEntity> getData(){return new ArrayList<>(data);}

    public InitiativeEntity getFromName(String name) throws TurnOrderException {
        if(!naming.contains(name)){
            throw new TurnOrderException(0);
        }
        for (var a :data) {
            if(a.getName().equals(name))return a;
        }
        throw new TurnOrderException(0);
    }

    public static void main(String[] args) {
        var Morn=new InitiativeEntity(3,15,31,"Morn");
        var Benua=new InitiativeEntity(10,14,23,"Benua");
        var order=new OrderSet();
        order.data.add(Morn);
        order.data.add(Benua);

        var turn =order.GetRound();
        while(turn.hasNext()){
            try{
                System.out.println(turn.next().getName());
            }
            catch (TurnOrderException ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

        try{
            System.out.println(turn.getFromName("dorn").getHits());
        }
        catch (Exception ex){ex.printStackTrace();}

    }
}

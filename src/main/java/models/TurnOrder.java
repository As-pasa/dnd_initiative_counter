package models;

import Exceptions.TurnOrderException;

import java.util.ArrayList;
import java.util.Objects;

public class TurnOrder {
    private ArrayList<InitiativeEntity> orderList;
    private int turn;
    private int roundLength;

    public TurnOrder(ArrayList<InitiativeEntity> a){
        orderList=a;
        roundLength=orderList.size();
        turn=0;
    }
    public InitiativeEntity next() throws TurnOrderException{
        try{
            var a= orderList.get(turn);
            turn+=1;
            return a;
        }
        catch (IndexOutOfBoundsException ex){
            throw new TurnOrderException(1);
        }

    };
    public boolean hasNext(){return turn<roundLength;}
    public InitiativeEntity getFromName(String name) throws TurnOrderException {

        for (InitiativeEntity a:orderList) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        throw new TurnOrderException(0);


    }

    public void removeByName(String name)throws TurnOrderException{
        for (InitiativeEntity a:orderList) {
            if (a.getName().equals(name)){
                orderList.remove(a);
                return;
            }
        }
        throw new TurnOrderException(0);
    }

    public static void main(String[] args) {
        ArrayList<InitiativeEntity> objs= new ArrayList<>();
        var Morn = new InitiativeEntity(17,10,56,"Morn");
        var Benua = new InitiativeEntity(15,10,34,"Benua");
        OrderSet a=new OrderSet();
        objs.add(Morn);
        objs.add(Benua);
        var TOrder=new TurnOrder(objs);

        while(TOrder.hasNext()){
            try{
                System.out.println(TOrder.next().getName());

            }
            catch (TurnOrderException ex){
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<InitiativeEntity> getOrderList(){return orderList;}
}

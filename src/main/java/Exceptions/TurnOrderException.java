package Exceptions;

public class TurnOrderException extends Exception{
    private int code;
    public TurnOrderException(int code){
        this.code=code;
    }

    public String getMessage(){
        switch (code){
            case 0:return "No such name in turn order";
            case 1: return "Index Out Of Bound";
            case 2: return "TurnSet Already Has Such Entity";
            default: return "unexpected";
        }

    }
}

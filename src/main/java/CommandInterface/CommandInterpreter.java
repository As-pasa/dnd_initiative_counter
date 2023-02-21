package CommandInterface;

import CommandInterface.Commands.*;
import models.StandartTurnModel;
import models.TurnModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandInterpreter {
    private ArrayList<Command> handlers;

    public CommandInterpreter(){
        handlers=new ArrayList<>();
        handlers.add(new createEntityCommand());
        handlers.add(new InfoCommand());
        handlers.add(new AddCommand());
        handlers.add(new SetCommand());
        handlers.add(new RmCommand());
        handlers.add(new CurrentTurnCommand());
        handlers.add(new EndTurnCommand());
        handlers.add(new DefaultHandler());
    }

    public void Interpret(BufferedReader reader, TurnModel model){
        while(true){
            String command= null;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                break;
            }
            if(command==null){
                break;
            }
            String[] splited=command.split("\\s+");
            for (var h:handlers) {
                if(h.argCheck(splited)){
                    h.apply(model);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1=new BufferedReader(new FileReader("C:\\Users\\as-pa\\IdeaProjects\\dndInitiativeCounter\\src\\initiative"));
        CommandInterpreter interpreter=new CommandInterpreter();
        var model=new StandartTurnModel();
        interpreter.Interpret(reader,model);

    }

}

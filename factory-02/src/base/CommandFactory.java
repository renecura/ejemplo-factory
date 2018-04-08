package base;

// La fabrica conoce a cada comando.
import base.Command;

import base.commands.OpenCommand;
import base.commands.CloseCommand;
import base.commands.MoveCommand;
import base.commands.ResizeCommand;

public class CommandFactory {
    
    // Singleton
    private static CommandFactory instance = null;

    private CommandFactory(){}

    public static CommandFactory getInstance() {
        if (instance == null)
            instance = new CommandFactory();
        return instance;
    }



    public Command getCommand(String command){
        switch (command) {
        case "OPEN":
            return (Command)OpenCommand.getInstance();            
        case "CLOSE":
            return (Command)CloseCommand.getInstance();
        case "RESIZE":
            return (Command)ResizeCommand.getInstance();
        case "MOVE":
            return (Command)MoveCommand.getInstance();
        default:
            return null;
        }
    }

}
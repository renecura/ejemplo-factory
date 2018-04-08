package base.commands;

import base.Command;
import java.util.Queue;

public class MoveCommand implements Command {

    // Singleton
    private static MoveCommand instance = null;

    private MoveCommand(){}

    public static MoveCommand getInstance() {
        if(instance == null)
            instance = new MoveCommand();
        return instance;
    }

    // Implementación de la interface
    public int execute(Queue<Integer> args){
        
        System.out.println("Soy MoveCommand y mis argumentos son 4: "
            + args.remove() + ", " 
            + args.remove() + ", "
            + args.remove() + ", "
            + args.remove());

        return 0;
    }

}
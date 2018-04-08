package base.commands;

import base.Command;
import java.util.Queue;

public class CloseCommand implements Command {

    // Singleton
    private static CloseCommand instance = null;

    private CloseCommand(){}

    public static CloseCommand getInstance() {
        if(instance == null)
            instance = new CloseCommand();
        return instance;
    }

    // Implementación de la interface
    public int execute(Queue<Integer> args){
        
        System.out.println("Soy CloseCommand y mis argumentos son 2: "
            + args.remove() + ", "
            + args.remove());

        return 0;
    }

}
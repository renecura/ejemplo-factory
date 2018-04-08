package base.commands;

import base.Command;
import java.util.Queue;

public class OpenCommand implements Command {

    // Singleton
    private static OpenCommand instance = null;

    private OpenCommand(){}

    public static OpenCommand getInstance() {
        if(instance == null)
            instance = new OpenCommand();
        return instance;
    }

    // Implementación de la interface
    public int execute(Queue<Integer> args){
        
        System.out.println("Soy OpenCommand y mis argumentos son 4: "
            + args.remove() + ", " 
            + args.remove() + ", "
            + args.remove() + ", "
            + args.remove());

        return 0;
    }

}
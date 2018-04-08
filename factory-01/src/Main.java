import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


import base.commands.OpenCommand;
import base.commands.CloseCommand;
import base.commands.MoveCommand;
import base.commands.ResizeCommand;

class Main {

    public static void main(String[] argv) {

        Scanner input = new Scanner(System.in);
        
        String command;
        Queue<Integer> args = new LinkedList<>();
        
        StringTokenizer line;
        while(input.hasNextLine()){
            // Lee y tokeniza la linea.
            line = new StringTokenizer(input.nextLine());

            // Lee el comando y sus argumentos.
            command = line.nextToken();
            while(line.hasMoreTokens()){
                args.add(Integer.parseInt(line.nextToken()));
            }

            // Ejecuta el comando
            switch(command){
                case "OPEN": OpenCommand.getInstance().execute(args); break;
                case "CLOSE": CloseCommand.getInstance().execute(args); break;
                case "RESIZE": ResizeCommand.getInstance().execute(args); break;
                case "MOVE": MoveCommand.getInstance().execute(args); break;
                default : System.out.println("Comando no encontrado");
            }

            // Limpia la cola de argumentos.
            args.clear();            
        }

        input.close();        
    }

}
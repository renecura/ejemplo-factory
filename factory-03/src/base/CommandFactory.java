package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import java.util.Map;
import java.util.HashMap;

// La fabrica ahora slo conoce a Command
import base.Command;


public class CommandFactory {

    private final String filename = "commands.config";
    
    // Mapa donde almacena cada comando.
    // Lo carga en base a un archivo de configuración.
    private Map<String, Command> commandMap;

    // Singleton
    private static CommandFactory instance = null;

    private CommandFactory(){
        commandMap = new HashMap<>();

        Properties config = new Properties();

        try {
            config.load(getClass().getClassLoader().getResourceAsStream(filename));
        } catch (IOException ioe) {
            System.err.println("No se encontró el archivo de configuración: "+filename);
        }

        Enumeration<?> e = config.propertyNames();
        String name;
        Class t;
        while(e.hasMoreElements()){
            name = (String) e.nextElement();
            try {
                t = Class.forName(config.getProperty(name));                
                commandMap.put(name, (Command)t.getMethod("getInstance").invoke(null));
            } catch (ClassNotFoundException cnfe) {
                System.err.println("No se encontró la clase: "+config.getProperty(name));
            } catch (NoSuchMethodException nsme){
                System.err.println("La clase "+config.getProperty(name)+" no implementa el metodo get instance.");
            } catch (Exception iae){
                System.err.println("Ocurrio un error invocando el metodo getInstance de la clase "+config.getProperty(name)+" "+iae.getMessage());
            }
        }
    }

    public static CommandFactory getInstance() {
        if (instance == null)
            instance = new CommandFactory();
        return instance;        
    }

    public Command getCommand(String command){       
        return commandMap.get(command);     
    }

}
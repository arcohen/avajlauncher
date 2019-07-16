package avajlauncher;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Avajlauncher 
{

    public static PrintWriter output;
    
    public static void main (String[] args)
    {
        int simulationNumber = 0;
        int lineFile = 2;

        WeatherTower weatherTower = new WeatherTower();

        if (args.length != 1)
        {
            if (args.length < 1)
                System.out.println("Please provide a simulation file for evaluation");
            else
                System.out.println("Please provide only one simulation file");
        } 
        else 
        {
            try
            {
                File outputFile = new File ("simulation.txt");
                output = new PrintWriter(outputFile);
                FileReader input = new FileReader(args[0]);
                BufferedReader reader = new BufferedReader(input);
                String aircraft[];
                String line = reader.readLine();
                try
                {
                    simulationNumber = Integer.parseInt(line);
                    if (simulationNumber < 1)
                        throw new CustomException("number of simulations must be greater than 0");
                }
                catch (Exception e)
                {
                    System.out.println("simulation number must be an integer");
                }
                while ((line = reader.readLine()) != null) {
                    aircraft = line.split(" ");
                    
                    if (aircraft.length != 5)
                        throw new CustomException("Error in number of variable in aircraft description at line " + lineFile);

                    if (aircraft[0].toLowerCase() != "baloon" || aircraft[0].toLowerCase() != "helicopter" || aircraft[0].toLowerCase() != "jetplane")
                        throw new CustomException("Error in  aircraft type at line " + lineFile);
    
                    for (int i = 2; i < 5; i++)
                    {
                        try {
                            if (Integer.parseInt(aircraft[i]) < 0)
                                throw new CustomException("Coordinate must be a positive integer at line " + lineFile);
                        } catch (Exception e) {
                            throw new CustomException("Coordinate must be a integer at line " + lineFile);
                        }
                    }
                    
                    Flyable newAircraft = new AircraftFactory().newAircraft(aircraft[0], aircraft[1], Integer.parseInt(aircraft[2]), Integer.parseInt(aircraft[3]), Integer.parseInt(aircraft[4]));
                    newAircraft.registerTower(weatherTower);
                    lineFile++;
                }
                
                reader.close();
    
                for (int i = simulationNumber; i > 0; i--) {
                    weatherTower.changeWeather();
                }
                
    
            }
            catch (Exception e)
            {   
                System.out.println("Error in file reading / creation");
            }
           
           
        }
    }
}
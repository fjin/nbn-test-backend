package nbn.rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinf on 20/04/2016.
 */
public class NBNApplication {

    public void readCommandsFromFile(String filename)
    {
        List<Rover> rovers = new ArrayList<Rover>();
        Plateau plateau = null;
        List<String> commands = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            String initPlateauSize = line;
            plateau = Plateau.plateau(initPlateauSize);
            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (line.length() == 0) {
                    line = reader.readLine();
                }

                String[] positions = line.split(" ");

                Position position = Position.position(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
                Direction direction = Direction.getInitDirection(positions[2].charAt(0));
                Rover rover = Rover.rover(direction, position);
                rovers.add(rover);

                line = reader.readLine();
                commands.add(line);
            }
            reader.close();
            for(int i = 0; i < rovers.size(); i++)
            {
                System.out.println(rovers.get(i).run(commands.get(i), plateau));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception
    {
        new NBNApplication().readCommandsFromFile("src/main/resources/test");
    }


}

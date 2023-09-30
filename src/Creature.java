import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Random;

public class Creature {
    Random random = new Random();
    int speed = 60;
    int step = 0;
    int x;
    int y;

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[][] getSurroundingCoordinates(int[][] matrix, int x, int y){
        ArrayList<int[]> coordinatesList = new ArrayList<>();
        if (x != 0 && y != 0) coordinatesList.add(new int[]{x-1, y-1});
        if (y != 0) coordinatesList.add(new int[]{x, y-1});
        if (x != matrix[0].length-1 && y != 0) coordinatesList.add(new int[]{x+1, y-1});

        if (x != 0) coordinatesList.add(new int[]{x-1, y});
        if (x != matrix[0].length-1) coordinatesList.add(new int[]{x+1, y});

        if (x != 0 && y != matrix.length-1) coordinatesList.add(new int[]{x-1, y+1});
        if (y != matrix.length-1) coordinatesList.add(new int[]{x, y+1});
        if (x != matrix[0].length-1 && y != matrix.length-1) coordinatesList.add(new int[]{x+1, y+1});


        int[][] coordinates = new int[coordinatesList.size()][2];
        for (int i = 0; i < coordinatesList.size(); i++){
            coordinates[i] = coordinatesList.get(i);
        }

        return coordinates;
    }

    public void eat(){}

    public void move(){}

    public void multiply(ArrayList<Creature> creatures, int selfCode, int multiplyPlaceCode){
        if (step == speed){
            step = 0;
            int[][] surroundingCoordinates = getSurroundingCoordinates(Main.matrix, this.x, this.y);
            int index = random.nextInt(surroundingCoordinates.length);
            int[] randomCoordinates = surroundingCoordinates[index];
            int new_x = randomCoordinates[0];
            int new_y = randomCoordinates[1];
            if (Main.matrix[new_x][new_y] == multiplyPlaceCode){
                Main.matrix[new_x][new_y] = selfCode;
                creatures.add(new Creature(new_x, new_y));
            }
        }else step++;
    }

    public void die(int dying_x, int dying_y, ArrayList<Creature> creatures){
        for (int i = 0; i < creatures.size(); i++){
            if (creatures.get(i).x == dying_x &&  creatures.get(i).y == dying_y){
                creatures.remove(i);
                break;
            }
        }
    }


}

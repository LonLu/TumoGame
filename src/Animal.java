import java.util.ArrayList;
import java.util.Random;

public class Animal extends Creature{
    private final Random random = new Random();
    private static final int speed = 60;
    private int step = 0;
    public Animal(int x, int y) {
        super(x, y);
    }

    @Override
    public int[][] getSurroundingCoordinates(int[][] matrix, int x, int y) {
        return super.getSurroundingCoordinates(matrix, x, y);
    }

    @Override
    public void eat() {
        super.eat();
        if (step == speed){
            step = 0;
            int[][] surroundingCoordinates = getSurroundingCoordinates(Main.matrix, this.x, this.y);
            int index = random.nextInt(surroundingCoordinates.length);
            int[] randomCoordinates = surroundingCoordinates[index];
            int new_x = randomCoordinates[0];
            int new_y = randomCoordinates[1];
            if (Main.matrix[new_x][new_y] == 1){
                die(new_x, new_y, Main.grasses);
                Main.matrix[new_x][new_y] = 2;
                Main.animals.add(new Animal(new_x, new_y));
            }

        }else step++;
    }

    @Override
    public void move() {
        super.move();
    }

//    @Override
//    public void multiply() {
//        super.multiply();
//    }

    @Override
    public void die(int dying_x, int dying_y, ArrayList<Creature> creatures) {
        super.die(dying_x, dying_y, creatures);
    }
}

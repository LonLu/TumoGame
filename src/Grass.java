import java.util.ArrayList;

public class Grass extends Creature{

    private static final int selfCode = 1;
    private static final int multiplyPlaceCode = 0;
    public Grass(int x, int y) {
        super(x, y);
    }
    public static int getSelfCode() {
        return selfCode;
    }
    public static int getMultiplyPlaceCode() {
        return multiplyPlaceCode;
    }

    @Override
    public int[][] getSurroundingCoordinates(int[][] matrix, int x, int y) {
        return super.getSurroundingCoordinates(matrix, x, y);
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void multiply(ArrayList<Creature> creatures, int selfCode, int multiplyPlaceCode) {
        super.multiply(creatures,selfCode,multiplyPlaceCode);
//        if (step == speed){
//            step = 0;
//            int[][] surroundingCoordinates = getSurroundingCoordinates(Main.matrix, this.x, this.y);
//            int index = random.nextInt(surroundingCoordinates.length);
//            int[] randomCoordinates = surroundingCoordinates[index];
//            int new_x = randomCoordinates[0];
//            int new_y = randomCoordinates[1];
//            if (Main.matrix[new_x][new_y] == 0){
//                Main.matrix[new_x][new_y] = 1;
//                Main.grasses.add(new Grass(new_x, new_y));
//            }
//
//        }else step++;

    }

    @Override
    public void die(int dying_x, int dying_y, ArrayList<Creature> creatures) {
        super.die(dying_x, dying_y, Main.grasses);
//        for (int i = 0; i < Main.grasses.size(); i++){
//            if (Main.grasses.get(i).x == dying_x &&  Main.grasses.get(i).y == dying_y){
//                Main.grasses.remove(i);
//                break;
//            }
//        }
    }
}

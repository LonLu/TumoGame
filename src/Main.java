import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main extends PApplet {

    public static int[][] matrix = new int[30][30];
    public static ArrayList<Creature> grasses = new ArrayList<>();
    public static ArrayList<Creature> animals = new ArrayList<>();
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;


    {initMatrix();}



    public static void main(String[] args) {
        PApplet.main("Main");

    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }


    @Override
    public void draw() {

        drawMatrix(30, 30);
        for (int i = 0; i < grasses.size() - 1; i++){
            grasses.get(i).multiply(Main.grasses, Grass.getSelfCode(), Grass.getMultiplyPlaceCode());
        }

        for (int i = 0; i < animals.size(); i++){
            animals.get(i).eat();
        }
        System.out.println(grasses.size());

    }



    public void drawMatrix(int row, int column, int something){
        int x_cellSize = WIDTH / row;
        int y_cellSize = HEIGHT / column;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                int x = i * x_cellSize;
                int y = j * y_cellSize;
                rect(x, y, x_cellSize, y_cellSize);
            }
        }
    }


    public void drawMatrix(int row, int column){
        int x_cellSize = WIDTH / row;
        int y_cellSize = HEIGHT / column;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int x = i * x_cellSize;
                int y = j * y_cellSize;
                if (matrix[i][j] == 1) fill(42, 206, 30);
                else if (matrix[i][j] == 2) fill(255, 255, 0);
                else fill(142, 142, 142);
                rect(x, y, x_cellSize, y_cellSize);
            }
        }
    }

    public void initMatrix(){
        Random random = new Random();
        int[] numbers = {0, 0, 0, 1, 1, 2};
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int randomIndex = random.nextInt(numbers.length);
                matrix[i][j] = numbers[randomIndex];
                if (matrix[i][j] == 1) grasses.add(new Grass(i, j));
                if (matrix[i][j] == 2) animals.add(new Animal(i, j));
            }
        }
    }

}


import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class chase{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("chase".toLowerCase()+".in"));

        String dirs = "NESW";
        int[] rMove = new int[]{-1, 0, 1, 0};
        int[] cMove = new int[]{0, 1, 0, -1};

        int cases = f.nextInt();
        while (cases-- > 0){
            cols = f.nextInt();
            rows = f.nextInt();
            f.nextLine();

            int mouseR = 0, mouseC = 0, mouseDir = 0;
            int catR = 0, catC = 0, catDir = 0;

            char[][] maze = new char[rows][cols];
            for (int r = 0; r < rows; r++){
                maze[r] = f.nextLine().trim().toCharArray();
                System.out.println(Arrays.deepToString(maze));
                for (int c = 0; c < cols; c++){
                    if (Character.isLowerCase(maze[r][c])){
                        mouseR = r;
                        mouseC = c;
                        mouseDir = dirs.indexOf(Character.toUpperCase(maze[r][c]));
                    }
                    if (Character.isUpperCase(maze[r][c])){
                        catR = r;
                        catC = c;
                        catDir = dirs.indexOf(Character.toUpperCase(maze[r][c]));
                    }
                }
            }

            HashSet<Coordinate> mouseCoords = new HashSet<>();
            boolean mouseMove = true;
            boolean end = false;
            boolean mouseWin = false;
            boolean catWin = false;

            HashSet<Coordinate> catPos = new HashSet<>();
            HashSet<Coordinate> mousePos = new HashSet<>();

            int moves = 0;

            while (!end){
                moves++;
                Coordinate mouseCoord = new Coordinate(mouseR, mouseC);
                Coordinate catCoord = new Coordinate(catR, catC);

                if (mousePos.contains(mouseCoord) && catPos.contains(catCoord)){
                    end = true;
                }

                if (mouseMove){
                    boolean catFound = false;
                    mouseCoords = new HashSet<>();

                    int tempMouseR = mouseR;
                    int tempMouseC = mouseC;

                    while (inBounds(tempMouseR, tempMouseC) && maze[tempMouseR][tempMouseC] != '#'){
                        if (tempMouseR == catR && tempMouseC == catC) catFound = true;
                        tempMouseR += rMove[mouseDir];
                        tempMouseC += cMove[mouseDir];
                    }

                    if (catFound){
                        mouseDir--;
                        mouseDir = (mouseDir + 4) % 4;
                    }

                    tempMouseR = mouseR;
                    tempMouseC = mouseC;

                    while (inBounds(tempMouseR, tempMouseC) && maze[tempMouseR][tempMouseC] != '#'){
                        Coordinate temp = new Coordinate(tempMouseR, tempMouseC);
                        mouseCoords.add(temp);
                        tempMouseR += rMove[mouseDir];
                        tempMouseC += cMove[mouseDir];
                    }

                    if (!inBounds(tempMouseR, tempMouseC)){
                        mouseWin = true;
                        end = true;
                    }


                    mouseR = tempMouseR - (rMove[mouseDir]);
                    mouseC = tempMouseC - (cMove[mouseDir]);

                    mouseDir--;
                    mouseDir = (mouseDir + 4) % 4;

                }
                else{
                    boolean mouseFound = false;

                    int tempCatR = catR;
                    int tempCatC = catC;

                    while (inBounds(tempCatR, tempCatC) && maze[tempCatR][tempCatC] != '#'){
                        if (tempCatR == mouseR && tempCatC == mouseC) mouseFound = true;

                        tempCatR += rMove[catDir];
                        tempCatC += cMove[catDir];
                    }

                    if (mouseFound){
                        catWin = true;
                        end = true;
                    }

                    else{
                        boolean state2 = false;
                        while (inBounds(tempCatR, tempCatC) && maze[tempCatR][tempCatC] != '#'){
                            Coordinate temp = new Coordinate(tempCatR, tempCatC);
                            if (mouseCoords.contains(temp)){
                                if (tempCatC == mouseC && tempCatR > mouseR) catDir = 0;
                                if (tempCatR == mouseR && tempCatC < mouseC) catDir = 1;
                                if (tempCatC == mouseC && tempCatR < mouseR) catDir = 2;
                                if (tempCatR == mouseR && tempCatC > mouseC) catDir = 3;
                                state2 = true;
                                break;
                            }
                            tempCatR += rMove[catDir];
                            tempCatC += cMove[catDir];
                        }
                        if (state2){
                            catR = tempCatR;
                            catC = tempCatC;
                        }
                        else {
                            catR = tempCatR - rMove[catDir];
                            catC = tempCatC - cMove[catDir];
                            catDir = (catDir + 1) % 4;
                        }
                    }
                }

                mouseMove = !mouseMove;
                System.out.println(mouseR+" "+mouseC+" "+mouseDir);

                System.out.println(catR+" "+catC+" "+catDir);

            }

            System.out.println(catWin+" "+mouseWin);

        }

        f.close();
    }

    int rows, cols;

    public boolean inBounds(int row, int col){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    class Coordinate{
        int row, col;
        public Coordinate(int row, int col){
            this.row = row;
            this.col = col;
        }

        public int hashCode(){
            return Objects.hash(row, col);
        }

        public boolean equals(Object o){
            Coordinate c = (Coordinate)o;
            return row == c.row && col == c.col;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new chase().run();
    }
}

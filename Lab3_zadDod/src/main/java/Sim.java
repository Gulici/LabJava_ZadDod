import java.util.Objects;

public class Sim {
    static String[][] MapForrest;
    static int N = 10;
    static double forestation = 0;
    public Sim(){
        MapForrest = new String[N][N];
    }
    public static void setN(int i){
        N = i;
    }
    public static void setForestation(double i) {
        forestation = i;
    }

    public static void setMap(){
        for (String[] strings : MapForrest) {
            for (int x = 0; x < MapForrest.length; x++){
                if(Math.random()<forestation) strings[x] = "T";
                else strings[x] = "X";
            }
        }
    }
    public static void printMap(){
        for (String[] strings : MapForrest) {
            for (int x = 0; x < MapForrest.length; x++)
                System.out.print("\t"+strings[x]);
            System.out.println();
        }
        System.out.println();
    }
    public static void countMap(){
        int pX = 0, pT = 0, pB = 0;

        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++){
                if(Objects.equals(MapForrest[y][x], "T")) pT++;
                else if(Objects.equals(MapForrest[y][x], "X")) pX++;
                else if(Objects.equals(MapForrest[y][x], "B")) pB++;
            }
        }
        System.out.println("Trees:\t\t\t"+pT);
        System.out.println("Empty field:\t"+pX);
        System.out.println("Trees in fire:\t"+pB);
    }
    private static void fireStart(){
        for(int x = 0; x < N; x++)
            if(MapForrest[0][x].equals("T")) MapForrest[0][x]="B";
    }
    private static boolean isFire(int y, int x){
        return MapForrest[y][x].equals("B");
    }
    private static boolean setFireNear(int y, int x){
        boolean set = false;
        for (int dy = -1; dy <=1; dy++){
            if(y+dy>=0 && y+dy<N){
                for (int dx = -1; dx <=1; dx++){
                    if(x+dx>=0 && x+dx<N){
                        if (MapForrest[y+dy][x+dx].equals("T")){
                            MapForrest[y+dy][x+dx] = "B";
                            set = true;
                        }
                    }
                }
            }
        }
        return set;
    }
    private static boolean fireStep(){
        for (int y = 0; y<N; y++){
            for(int x = 0; x<N; x++){
                if(isFire(y,x)){
                    if(setFireNear(y,x)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void fireSim(){
        fireStart();
        while (fireStep()) {
            //printMap(Map);
        }
    }
}

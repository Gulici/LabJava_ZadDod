import java.util.Objects;

public class Sim {
    private String[][] MapForrest;
    private int n = 10;
    private int forestation = 0;

    public Sim(int n, int forestation){
        this.n = n;
        this.forestation = forestation;
        MapForrest = new String[n][n];
        setMap();
    }

    public void setMap(){
        for (String[] strings : MapForrest) {
            for (int x = 0; x < MapForrest.length; x++){
                if(Math.random()*100<forestation) strings[x] = "T";
                else strings[x] = "X";
            }
        }
    }
    public void printMap(){
        for (String[] strings : MapForrest) {
            for (int x = 0; x < MapForrest.length; x++)
                System.out.print("\t"+strings[x]);
            System.out.println();
        }
        System.out.println();
    }
    public int[] countMap(){
        int pEmpty = 0, pTree = 0, pBurn = 0;

        for (int y = 0; y < n; y++){
            for (int x = 0; x < n; x++){
                if(Objects.equals(MapForrest[y][x], "T")) pTree++;
                else if(Objects.equals(MapForrest[y][x], "X")) pEmpty++;
                else if(Objects.equals(MapForrest[y][x], "B")) pBurn++;
            }
        }

        int pAllTree = pTree+pBurn;
        int[] result = {pBurn,pAllTree,pTree};

//        System.out.println("Trees:\t\t\t"+pTree);
//        System.out.println("Empty field:\t"+pEmpty);
//        System.out.println("Trees in fire:\t"+pBurn);

        return result;
    }
    private void fireStart(){
        for(int x = 0; x < n; x++)
            if(MapForrest[0][x].equals("T")) MapForrest[0][x]="B";
    }
    private boolean inFire(int y, int x){
        return MapForrest[y][x].equals("B");
    }
    private boolean setFireNear(int y, int x){
        boolean set = false;
        for (int dy = -1; dy <=1; dy++){
            if(y+dy>=0 && y+dy< n){
                for (int dx = -1; dx <=1; dx++){
                    if(x+dx>=0 && x+dx< n){
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
    private boolean fireStep(){
        for (int y = 0; y< n; y++){
            for(int x = 0; x< n; x++){
                if(inFire(y,x)){
                    if(setFireNear(y,x)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int[] fireSim(){
        fireStart();
        while (fireStep()){}
        return countMap();
    }
}

import java.util.LinkedHashMap;
import java.util.Map;

public class RunSimulation {
    private Map<Integer, int[]> result = new LinkedHashMap<>();
    private int size;

    public RunSimulation(int size) {
        this.size = size;
    }

    public void startSimulation(){
        for (int forestation = 0; forestation<=100; forestation+=5){
            int nBurnTree = 0, nAllTree =0, nTree = 0;

            System.out.println("Processed forestation: "+forestation);

            for(int i = 0; i < 10; i++){
                System.out.println((i+1)+"/10");
                Sim sim = new Sim(size, forestation);
                int[] ints = sim.fireSim();
                nBurnTree+=ints[0];
                nAllTree+=ints[1];
                nTree+=ints[2];
            }
            int[] trees = {nBurnTree,nAllTree,nTree};

            result.put(forestation,trees);
        }
    }
    public Map<Integer, int[]> getResult() {
        return result;
    }
}

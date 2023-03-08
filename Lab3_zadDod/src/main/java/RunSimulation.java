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
            int inFire = 0, allTree =0, nBurnTree = 0;

            System.out.println("Processed forestation: "+forestation);

            for(int i = 0; i < 10; i++){
                System.out.println((i+1)+"/10");
                Sim sim = new Sim(size, forestation);
                sim.setMap();
                int[] ints = sim.fireSim();
                inFire+=ints[0];
                allTree+=ints[1];
                nBurnTree+=ints[2];
            }
            int[] trees = {inFire,allTree,nBurnTree};

            result.put(forestation,trees);
        }
    }
    public Map<Integer, int[]> getResult() {
        return result;
    }
}

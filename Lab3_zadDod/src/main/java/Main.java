
import java.util.Map;
import java.io.FileWriter;
public class Main {
    public static void main(String[] args){
        RunSimulation runSimulation = new RunSimulation(100);
        runSimulation.startSimulation();
        Map<Integer, int[]> result = runSimulation.getResult();
        Data data = new Data(result);
        data.printData();

        //save to .txt file
        try{
            WriteToFile(data.getResultTable());
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void WriteToFile(String result) throws Exception{
        String filename = "table.txt";
        FileWriter fileW = new FileWriter(filename);
        fileW.write(result);
        fileW.close();
    }
}

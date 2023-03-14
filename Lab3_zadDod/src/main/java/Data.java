import java.util.HashMap;
import java.util.Map;

public class Data {
    /*
    ----------------------------------------------------------------------------------
    | Forestation | All trees | Trees in fire | Trees not in fire | inFire/All ratio |
    ----------------------------------------------------------------------------------
    |        0.00 |         0 |             0 |                 0 |                0 |
    ....
    ----------------------------------------------------------------------------------
     */

    /*
    HashMap ( key - forestation , value - int[] = {InFire,All} )

    Store data from 10 Sim for each forestation value
     */
    private Map<Integer, int[]> data;
    private String resultTable;

    public Data(Map<Integer, int[]> data) {
        this.data = data;
    }

    public void printData() {
        StringBuilder table = new StringBuilder();
        table.append("----------------------------------------------------------------------------------\n" +
                "| Forestation | All trees | Trees in fire | Trees not in fire | inFire/All ratio |\n" +
                "----------------------------------------------------------------------------------\n");
        for (Integer key : data.keySet()) {
            String temp;

            int allTrees = data.get(key)[1];
            int burnTrees = data.get(key)[0];
            int nBurnTrees = data.get(key)[2];
            double forestation = (double) key / 100;
            double ratio;
            if (burnTrees == 0) {
                ratio = 0.00;
            } else {
                ratio = (double) data.get(key)[0] / data.get(key)[1];
            }
            temp = String.format("| %11.2f | %9d | %13d | %17d | %16.2f |\n", forestation, allTrees, burnTrees, nBurnTrees, ratio);

            table.append(temp);
        }
        table.append("----------------------------------------------------------------------------------\n");
        System.out.println(table);
        setResultTable(table.toString());
    }

    public String getResultTable() {
        return resultTable;
    }

    public void setResultTable(String resultTable) {
        this.resultTable = resultTable;
    }
}



public class Menu {
    public static void main(String[] args){

        Sim.setN(20);
        Sim.setForestation(0.35);
        new Sim();


        Sim.setMap();
        Sim.printMap();
        Sim.countMap();

        Sim.fireSim();
        Sim.printMap();
        Sim.countMap();
    }
}

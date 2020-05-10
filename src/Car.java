public class Car extends SimulationObject {
    private SimulationObject underObject;
    private Simulation simulation;


    public Car(Simulation simulation, SimulationObject underObject) {
        this.underObject = underObject;
        this.simulation = simulation;
    }


    @Override
    public String toString() {
        return "C";
    }

    // C...R............G......
    @Override
    public void update() {
        SimulationObject neighbour = simulation.findNeighbour(this);
        if(neighbour != null){
            simulation.setInstead(underObject, this);
            underObject = neighbour;
            simulation.setInstead(this, neighbour);
        }
    }
}

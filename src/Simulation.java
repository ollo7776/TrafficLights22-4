import java.util.ArrayList;

import java.util.List;

public class Simulation {
    private List<SimulationObject> objects = new ArrayList<>();

    public SimulationObject findNeighbour(SimulationObject object) {
        int index = objects.indexOf(object);
        if (index < objects.size() - 1) {
            return objects.get(index + 1);
        }
        return null;
    }

    public void add(SimulationObject object) {
        objects.add(object);
    }

    public void nextStep() {
        for (int i = objects.size() - 1; i >= 0; i--) {
            SimulationObject object = objects.get(i);
            object.update();
        }
    }

    public void setInstead(SimulationObject source, SimulationObject instead) {
        int index = objects.indexOf(instead);

        objects.set(index, source);
    }

    @Override
    public String toString() {
        String text = "";
        for (Object object : objects) {
            text += object.toString();
        }
        return text;
    }

    public static Simulation parse(String road) {
        Simulation simulation = new Simulation();
        for (char c : road.toCharArray()) {
            if (c == 'C') {
                simulation.objects.add(new Car(simulation, new Road()));
            } else if (c == '.') {
                simulation.objects.add(new Road());
            } else {
                simulation.objects.add(new Lights(c + ""));
            }

        }
        return simulation;
    }
}



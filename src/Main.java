public class Main {
    public static void main(String[] args) {
        Simulation simulation = Simulation.parse("C...R............G......");
        System.out.println(simulation);

        for (int i = 0; i < 10; i++) {
            simulation.nextStep();
            System.out.println(simulation);
        }
    }
}

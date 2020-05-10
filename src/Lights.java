public class Lights extends SimulationObject {
    private String state;
    private int unit;

    public Lights(String state) {
        if(state.equals("G")||state.equals("O")||state.equals("R")){
            this.state = state;
        }else {
         throw new IllegalArgumentException(state);
        }
    }

    @Override
    public void update() {
        if (state.equals("G") && unit == 5) {
            state = "O";
            unit = 0;
        } else if (state.equals("O") && unit == 1) {
            state = "R";
            unit = 0;
        } else if (state.equals("R") && unit == 5) {
            state = "G";
            unit = 0;
        }
        unit++;
    }

    @Override
    public String toString() {
        return state;
    }
}

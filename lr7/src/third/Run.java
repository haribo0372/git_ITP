package third;

public class Run extends Thread {
    private SumKG sumKG;

    public Run(SumKG s){
        sumKG = s;
    }
    @Override
    public void run() {
        System.out.println("Three workers were tired, " + sumKG.getSum() + " kilograms were attributed");
    }
}

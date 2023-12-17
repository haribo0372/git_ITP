public class Truck extends Transport{
    private int maxFreight;

    public Truck(){
        this.maxFreight = 500;
    }

    public Truck(int freight){
        this.maxFreight = freight;
    }

    public int getMaxFreight(){
        return this.maxFreight;
    }

    public void setMaxFreight(int freight){
        this.maxFreight = freight;
    }

    public int FreightInGrams(){
        return this.maxFreight * 1000;
    }

    @Override
    public void getValues(){
        System.out.print("This is Truck:" +
                "\n\tColor: " + this.color +
                "\n\tWeight: " + this.weight +
                "\n\tSpeed: " + this.speed +
                "\n\tMax freight: " + this.maxFreight);
        System.out.format(" (%s grams)\n\n", FreightInGrams());
    }
}

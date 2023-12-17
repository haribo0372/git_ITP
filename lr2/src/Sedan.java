public class Sedan extends Transport{
    protected static int counter;
    private String brand;
    private String model;

    public Sedan(){
        this.brand = "Toyota";
        this.model = "Chaser";
        counter++;
    }

    public Sedan(String brand, String model){
        this.brand = brand;
        this.model = model;
        counter++;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void plusSpeed(int speed){
        this.speed += speed;
    }

    public static int getNumOfInstances() {
        return counter;
    }

    @Override
    public void getValues(){
        System.out.println("This is Sedan:" +
                "\n\tColor: " + this.color +
                "\n\tWeight: " + this.weight +
                "\n\tSpeed: " + this.speed +
                "\n\tBrand: " + this.brand +
                "\n\tModel: " + this.model + "\n");
    }
}



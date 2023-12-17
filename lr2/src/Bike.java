public class Bike extends Transport{
    private String name;

    public Bike(){
        this.name = "Matilda";
        this.speed = 300;
    }
    public Bike(String name){
        this.name = name;
        this.speed = 300;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void getValues(){
        System.out.println("This is Bike and his name "+ this.name +
                "\n\tColor: " + this.color +
                "\n\tWeight: " + this.weight +
                "\n\tSpeed: " + this.speed + "\n");
    }
}

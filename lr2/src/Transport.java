public abstract class Transport {

    public float weight;
    public String color;
    public int speed;

    public Transport(float weight, String color, int speed) {
        this.weight = weight;
        this.color = color;
        this.speed = speed;
    }

    public Transport() {
        this.weight = 100.0f;
        this.color = "Black";
        this.speed = 60;
    }
    public float getWeight(){
        return this.weight;
    }

    public String getColor(){
        return this.color;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void getValues(){
        System.out.println("This is Transport");
    }
}

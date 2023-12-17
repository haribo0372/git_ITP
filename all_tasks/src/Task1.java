

public class Task1 {
    public static void main(String[] args) {
        System.out.println(
                        "\n<---------------------Tasks 1/6--------------------->\n" +
                "\nTask 1/10 : convert(5) = " + convert(5) +
                "\nTask 2/10 : fitCalc(41, 3) = " + fitCalc(41, 3) +
                "\nTask 3/10 : containers(4, 1, 4) = " + containers(4, 1, 4) +
                "\nTask 4/10 : triangleType(3, 4, 5) = " + triangleType(3, 4, 5) +
                "\nTask 5/10 : ternaryEvaluation(500, 655) = " + ternaryEvaluation(500, 655) +
                "\nTask 6/10 : howManyItems(45, 1.8, 1.9) = " + howManyItems(45, 1.8f, 1.9f) +
                "\nTask 7/10 : factorial(7) = " + factorial(7) +
                "\nTask 8/10 : gcd(259, 28) = " + gcd(259,28) +
                "\nTask 9/10 : ticketSaler(70, 1500) = " + ticketSaler(70, 1500) +
                "\nTask 10/10 : tables(123, 58) = " + tables(123, 58));

    }

//    ----------------------------------------------------Task 1/6----------------------------------------------------
    public static float convert(int x){
        return x*3.785f;
    }
    public static int fitCalc(int x , int y){
        return x*y;
    }
    public static int containers(int x, int y, int z){
        return x*20 + y*50 + z*100;
    }
    public static String triangleType(int x, int y, int z){
        if (z < x+y & y < x+z & x < y+z){
            if (x == y & x == z){
                return "isosceles";
            }
            else if (x==y || y==z || x==z){
                return "equilateral";
            }
            else{
                return "different-sided";
            }
        }
        else {
            return "not a triangle";
        }
    }
    public static int ternaryEvaluation(int a, int b){
        return a > b ? a : b;
    }
    public static int howManyItems(float n, float h, float w){
        return (int) ((n/2) / (h*w));
    }
    public static int factorial(int x){

        int result = 1;

        for (int i=2; i<=x; i++){
            result *= i;
        }
        return result;
    }
    public static int gcd(int x, int y){
        int i = Math.min(x, y);
        while (i != 1){
            if (x%i==0 && y%i==0){
                return i;
            }
            i -= 1;
        }
        return 1;
    }
    public static int ticketSaler(int x, int y){
        return x*y - x*y*28/100;
    }
    public static int tables(int x, int y){
        if (x > y*2){
            return (int)Math.ceil((double) (x - y * 2) / 2);
        }else{ return 0; }
    }
}
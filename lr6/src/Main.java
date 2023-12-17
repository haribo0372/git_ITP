public class Main {
    public static void main(String[] args) {
        System.out.println("-----Demonstration of Stack-----");
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println("-----Demonstration of Shop-----");
        Shop shop = new Shop();
        shop.put("огурчик");    // 1
        shop.put("носки");      // 2
        shop.put("марковка");   // 3
        shop.put("носки");      // 4
        shop.put("огурчик");    // 5
        shop.put("носки");      // 6
        shop.put("яблоко");     // 7
        shop.put("носки");      // 8

        shop.printProducts();

        System.out.println("Top product : " + shop.getTopProduct());
        System.out.println("Total sales = " + shop.getSalesAmount());
    }
}

import java.util.*;

class GFG {
    public static void main(String args[])
    {
        String[] geekslist = { "1", "2", "4", "2", "1", "2",
                "3", "1", "3", "4", "3", "3" };

        // Creating a list and removing
        // elements without use of singleton()
        List geekslist1 = new ArrayList(Arrays.asList(geekslist));
        System.out.println("Original geeklist1: " + geekslist1);

        geekslist1.remove("1");
        System.out.println("geekslist1 after removal of 1 without"
                + " singleton " + geekslist1);
        geekslist1.remove("1");
        System.out.println("geekslist1 after removal of 1 without"
                + " singleton " + geekslist1);
        geekslist1.remove("2");
        System.out.println("geekslist1 after removal of 2 without"
                + " singleton " + geekslist1);
 
        /* Creating another list and removing 
    its elements using singleton() method */
        List geekslist2 = new ArrayList(Arrays.asList(geekslist));
        System.out.println("\nOriginal geeklist2: " + geekslist2);

        // Selectively delete "1" from
        // all it's occurrences
        geekslist2.removeAll(Collections.singleton("1"));
        System.out.println("geekslist2 after removal of 1 with "
                + "singleton:" + geekslist2);

        // Selectively delete "4" from
        // all it's occurrences
        geekslist2.removeAll(Collections.singleton("4"));
        System.out.println("geekslist2 after removal of 4 with "
                + "singleton:" + geekslist2);

        // Selectively delete "3" from
        // all it's occurrences
        geekslist2.removeAll(Collections.singleton("3"));
        System.out.println("geekslist2 after removal of 3 with"
                + " singleton: " + geekslist2);
    }
}
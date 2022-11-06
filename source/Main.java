
import java.util.Scanner;

public class Main {

    // some colors ANSI code to use changing console text color
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW

    public static void main(String[] args) {
       menu();
    }
    static QuadraticHashTable qht=new QuadraticHashTable();


    private static void menu(){

        Scanner s=new Scanner(System.in);

        while (true){
            System.out.println(GREEN_BOLD +"\n--------------------------------------------------------" + RESET);
            System.out.println(GREEN_BOLD + "\n***** Enter the number of the act you want *****  |" + RESET);
            System.out.println("1 - Insert to Hash Table");
            System.out.println("2 - Erase a key from Hash Table");
            System.out.println("3 - Clear all elements of Hash Table \n ");
            System.out.println(YELLOW_BOLD + "              ------------------------------" + RESET);
            System.out.println(YELLOW_BOLD + "              |||| Hash Table Accessors ||||" + RESET);
            System.out.println(YELLOW_BOLD + "              ------------------------------ \n" + RESET);
            System.out.println("4 - Print all bins element");
            System.out.println("5 - Numbers of element in the Hash Table");
            System.out.println("6 - Capacity of the Hash Table");
            System.out.println("7 - Load factor of the Hash Table");
            System.out.println("8 - Checking being Empty");
            System.out.println("9 - Checking existence of a Key in Hash Table");
            System.out.println("10- Getting element of a bin");
            System.out.println(RED_BOLD + "11 - Exit" + RESET );
            System.out.println(GREEN_BOLD +"\n--------------------------------------------------------" + RESET);

            int selectedItem=s.nextInt();

            switch(selectedItem){
                case 1 :insert(qht);
                case 2 :erase(qht);
                case 3 :clear(qht);
                case 4 :print(qht);
                case 5 :size(qht);
                case 6 :capacity(qht);
                case 7 :loadFactor(qht);
                case 8 :isEmpty(qht);
                case 9 :exist(qht);
                case 10 :bin(qht);
                case 11 :print(qht);
                case 12 : return;
            }


        }
    }


    public static void insert(QuadraticHashTable qht){
        Scanner s=new Scanner(System.in);
        System.out.println(" Enter the Key : " );
        Object key=s.next();
        qht.insert(key);
        menu();
    }


    public static void erase(QuadraticHashTable qht) {
        Scanner s = new Scanner(System.in);
        System.out.println(" Enter the Key : ");
        Object key = s.next();
        if (!qht.erase(key)){
            System.out.println(RED_BOLD + "There is no key like this in Hash Table." + RESET);
        }
        else {
            System.out.println(GREEN_BOLD + "Key < " + key + " > erased from Hash Table." + RESET);
        }
        menu();
    }


    public static void clear(QuadraticHashTable qht) {
        qht.clear();
        System.out.println(GREEN_BOLD + "Hash Table Cleared." + RESET);
        menu();
    }


    public static void print(QuadraticHashTable qht) {
        qht.print();
        menu();
    }


    public static void size(QuadraticHashTable qht) {
        System.out.println(YELLOW_BOLD + "Numbers of elements in Hash Table is : " + qht.size() + RESET);
        menu();
    }


    public static void capacity(QuadraticHashTable qht) {
        System.out.println(YELLOW_BOLD + "The Capacity of  Hash Table is : " + qht.capacity() + RESET);
        menu();
    }


    public static void loadFactor(QuadraticHashTable qht) {
        System.out.println(YELLOW_BOLD + "The Load Factor  of  Hash Table is : " + qht.loadFactor() + RESET) ;
        menu();
    }


    public static void isEmpty(QuadraticHashTable qht) {
        if (qht.isEmpty()) {
          System.out.println(YELLOW_BOLD + "The Hash Table is Empty." + RESET);
          menu();
          return;
        }
        System.out.println(YELLOW_BOLD + "The Hash Table isn't Empty." + RESET);

        menu();
    }


    public static void exist(QuadraticHashTable qht) {

        System.out.println("Enter the key that you want to check existence of it :");
        Scanner s = new Scanner(System.in);
        Object key =s.next();

        if (qht.exist(key)) {
            System.out.println(GREEN_BOLD + "The key is in the Hash Table." + RESET);
            menu();
            return;
        }

        System.out.println(RED_BOLD + "The key isn't in the Hash Table ." + RESET);
        menu();
    }


    public static void bin(QuadraticHashTable qht) {
        System.out.println("Which index do you want to print it's element ? ");
        Scanner s = new Scanner(System.in);
        int index =s.nextInt();

        Object elementOfIndex=qht.bin(index);

        if (elementOfIndex!=null){

            System.out.println(YELLOW_BOLD + "element of that index you entered is : " + elementOfIndex  + RESET);
        }
        else {
            System.out.println(YELLOW_BOLD + "element of that index you entered is : " + null + RESET);
        }
        menu();
    }

}

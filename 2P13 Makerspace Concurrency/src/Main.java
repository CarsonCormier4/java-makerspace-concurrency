import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/* COSC 2P13
 * Assignment 1
 *
 *
 * Username: ww23iu@brocku.ca
 * Student #: 7843469
 *
 * Due: Feburary 24 @11:55pm
 * @version 3.2
 */

public class Main {

    //Reads in user input
    private static Scanner scanner = new Scanner(System.in);

    //Counter for total number of knickknacks produced
    private static int totalKnickknacks = 0;

    //Lock to update the total knicknacks count
    private static final ReentrantLock countLock = new ReentrantLock();

    //Locks for each station
    static ReentrantLock fdmLock = new ReentrantLock();
    static ReentrantLock resinLock = new ReentrantLock();
    static ReentrantLock solderLock = new ReentrantLock();
    static ReentrantLock toasterLock = new ReentrantLock();
    static ReentrantLock latheLock = new ReentrantLock();
    static ReentrantLock millLock = new ReentrantLock();
    static ReentrantLock airbrushLock = new ReentrantLock();

    /**
     * @method Main method that runs the program
     * @param args Command line arguments
     */
    public static void main(String[] args){

        //Array of knickknacks
        String[] knickknacks = {"Figurines", "Motor Controllers", "Chess Sets", "Toaster Pastries", "Cup Holders", "SAK Scales", "Flashlights"};

        //Array for user input values (7 is max threads)
        int[] userInVal = new int[7];

        //Array to store threads
        Thread[] threads = new Thread[7];

        //Get the number of knickknacks to produce for each knickknack
        for(int i=0 ; i<7 ; i++){

            //Error trap the user input
            while(true){
                System.out.print("Enter number of " + knickknacks[i] + " to produce: ");

                //Check if input is an integer
                if (scanner.hasNextInt()){
                    int input = scanner.nextInt();

                    //Ensure the input is positive
                    if(input>=0){
                        userInVal[i]=input;
                        break;
                    }else{
                        System.out.println("Invalid number, try again");
                    }
                }else{
                    System.out.println("Invalid number, try again");
                    scanner.next();
                }
            }
        }

        //Ask user how often should progress be reported
        System.out.print("Report progress every X knickknacks: ");
        int reportX = scanner.nextInt();

        //Close scanner
        scanner.close();

        //Create and start threads to produce knickknacks
        for(int i=0 ; i<7 ; i++){

            //Only create a thread if user wants item produced
            if(userInVal[i]>0){

                //Create thread and start its execution
                threads[i] = new Thread(createProject(knickknacks[i], userInVal[i], reportX));
                threads[i].start();
            }
        }

        //Wait for all existing threads to finnish
        for(int i=0 ; i<7 ; i++){
            if(threads[i]!=null){
                try{
                    threads[i].join();
                }catch (InterruptedException e){}
            }
        }

        //Print the final production results
        System.out.println("All knickknacks have been produced");
        System.out.println("Total knickknacks produced: " + totalKnickknacks);
    }

    /**
     * @method Increments the total number of knickknacks produced
     */
    public static void incTotKnickknacks(){

        //Safely increment using locks
        countLock.lock();
        try{
            totalKnickknacks++;
        }finally{
            countLock.unlock();
        }
    }

    /**
     * @method Creates and returns Knickknack object based on given name
     * @param name The name of the Knickknack to produce
     * @param amount The number of a specified knickknack to produce
     * @param reportTime How often the progress is reported
     * @return A new instance of a knicknack's project, null if name DNE
     */
    private static knickknacks createProject(String name, int amount, int reportTime){
        if(name.equals("Figurines")) return new figurineProject(amount, reportTime);
        if(name.equals("Motor Controllers")) return new motorProject(amount, reportTime);
        if(name.equals("Chess Sets")) return new chessProject(amount, reportTime);
        if(name.equals("Toaster Pastries")) return new pastryProject(amount, reportTime);
        if(name.equals("Cup Holders")) return new cupHolderProject(amount, reportTime);
        if(name.equals("SAK Scales")) return new scaleProject(amount, reportTime);
        if(name.equals("Flashlights")) return new flashlightProject(amount, reportTime);

        //Base case: return null if given name isn't a known type
        return null;
    }
}

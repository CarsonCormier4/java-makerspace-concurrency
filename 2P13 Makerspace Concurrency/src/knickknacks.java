//Class that represents a knickknack producer.
public abstract class knickknacks implements Runnable{

    //The knickknacks name
    protected String name;

    //Amount of knickknacks to be produced
    protected int amount;

    //How often progress is reported
    protected int reportTime;

    //Defines the specific steps/stations to make a project
    protected abstract void doSteps();

    //Default constructor
    public knickknacks(){}


    /**
     * @method Simulates the knickknacks' production in a separate thread
     */
    public void run(){
        for(int i=1 ; i<=amount ; i++){

            //Do the steps in the subclass
            doSteps();

            //Increase the total knickknack count by 1
            Main.incTotKnickknacks();

            //Show the progress based on how often progress is reported
            if(i%reportTime==0 || i==amount){
                System.out.println(name + " produced: "+ i +"/"+ amount);
            }
        }

        //Tell user specific knickknack is done
        System.out.println(name + " production is done.");
    }
}

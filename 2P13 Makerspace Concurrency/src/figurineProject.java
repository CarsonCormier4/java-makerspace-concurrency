//Class that produces Figurines for Mazes and Monsters using given steps
public class figurineProject extends knickknacks{

    /**
     * @method Initializes a figurine Project object
     * @param amount Number of figurines to make
     * @param reportTime How often the figurines' progress is reported
     */
    public figurineProject(int amount, int reportTime){
        this.name = "Figurines";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a figurine
     */
    protected void doSteps(){

        //1. First print the figures on the resin printer
        Main.resinLock.lock();
        try{
            System.out.println(name +": Printing figures on the resin printer.");
        }finally {
            Main.resinLock.unlock();
        }

        //2. Then paint each using the airbrush
        Main.airbrushLock.lock();
        try{
            System.out.println(name +": Painting figures with the airbrush.");
        }finally {
            Main.airbrushLock.unlock();
        }

        //3. Start a moral panic about DND and make a movie about it
    }

}

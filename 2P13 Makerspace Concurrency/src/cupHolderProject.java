//Class that produces cup holders using given steps
public class cupHolderProject extends knickknacks{


    /**
     * @method Initializes a Cup Holder Project object
     * @param amount Number of cup holders to make
     * @param reportTime How often the cup holders' progress is reported
     */
    public cupHolderProject(int amount, int reportTime){
        this.name = "Cup Holders";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a cup holder
     */
    protected void doSteps(){

        //1. Throw the filament into the toaster oven to dry it
        Main.toasterLock.lock();
        try{
            System.out.println(name +": Putting filament into the toaster oven.");
        }finally {
            Main.toasterLock.unlock();
        }

        //2. Produce the basic holder on the FDM printer
        Main.fdmLock.lock();
        try{
            System.out.println(name +": Making a basic holder on the FDM printer.");
        }finally {
            Main.fdmLock.unlock();
        }

        //3. Use pure acetone in the airbrush station to smooth the layer lines
        Main.airbrushLock.lock();
        try{
            System.out.println(name +": Smoothing layer lines with the airbrush.");
        }finally {
            Main.airbrushLock.unlock();
        }

        //4. Set it aside to dry for a bit
    }
}

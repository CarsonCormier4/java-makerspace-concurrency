//Class that produces Motor Controllers with Custom PCBs using given steps
public class motorProject extends knickknacks{

    /**
     * @method Initializes a Motor Controller Project object
     * @param amount Number of motor controllers to make
     * @param reportTime How often the motor controllers' progress is reported
     */
    public motorProject(int amount, int reportTime){
        this.name = "Motor Controllers";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a motor controller
     */
    protected void doSteps() {

        //1. Use the soldering iron to tin the through-hole components
        Main.solderLock.lock();
        try{
            System.out.println(name + ": Tinning through-hole components with soldering iron.");
        }finally {
            Main.solderLock.unlock();
        }

        //2. Run the board through the mill to cut out the traces
        Main.millLock.lock();
        try{
            System.out.println(name+": Running board through the mill.");
        }finally {
            Main.millLock.unlock();
        }

        //3. Brush on some flux
        //4. Spread on the solder paste

        //5. Throw it into the toaster oven to flow the solder
        Main.toasterLock.lock();
        try{
            System.out.println(name+": Flowing solder in the toaster oven.");
        }finally {
            Main.toasterLock.unlock();
        }

        //6. Run it through the mill again to clear out any bridges
        Main.millLock.lock();
        try{
            System.out.println(name+": Clearing bridges in the mill.");
        }finally {
            Main.millLock.unlock();
        }

        //7. Use the soldering iron to touch up any weak joints
        Main.solderLock.lock();
        try{
            System.out.println(name+": Touching up weak joints with soldering iron.");
        }finally {
            Main.solderLock.unlock();
        }

        //8. Plug in the motors
    }
}

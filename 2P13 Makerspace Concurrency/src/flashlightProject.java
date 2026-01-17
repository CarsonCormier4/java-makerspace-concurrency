//Class that produces Flashlights using given steps
public class flashlightProject extends knickknacks {

    /**
     * @method Initializes a flashlight Project object
     * @param amount Number of flashlights to make
     * @param reportTime How often the flashlights progress is reported
     */
    public flashlightProject(int amount, int reportTime) {
        this.name = "Flashlights";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a flashlight
     */
    protected void doSteps() {

        //1. Throw some round stock into the lathe to hollow it out
        Main.latheLock.lock();
        try{
            System.out.println(name + ": Hollowing out round stock on the lathe.");
        }finally {
            Main.latheLock.unlock();
        }

        //2. Drill a couple holes

        //3. Use the soldering iron to connect some batteries, an LED, and a switch
        Main.solderLock.lock();
        try{
            System.out.println(name+": Soldering technology.");
        }finally {
            Main.solderLock.unlock();
        }
    }
}

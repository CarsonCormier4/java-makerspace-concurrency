//Class that produces Toaster pastries using given steps
public class pastryProject extends knickknacks{

    /**
     * @method Initializes a Toaster Pastry Project object
     * @param amount Number of toaster pastries to make
     * @param reportTime How often the toaster pastries' progress is reported
     */
    public pastryProject(int amount, int reportTime){
        this.name = "Toaster Pastries";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a toaster pastry
     */
    protected void doSteps(){

        //1. Pop a pastry into the toaster oven
        Main.toasterLock.lock();
        try{
            System.out.println(name+": Popping a pastry in the toaster oven.");
        }finally {
            Main.toasterLock.unlock();
        }
    }
        //2. Consume half the pastry
        //3. Regret not letting the pastry cool
        //4. Resume consuming the pastry
        //5. Wonder if it’s smart to use the same oven for both pastries and lead solder
    }

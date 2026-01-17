//Class that produces SAK scales using given steps
public class scaleProject extends knickknacks {


    /**
     * @method Initializes a SAK scale Project object
     * @param amount Number of SAK scales to make
     * @param reportTime How often the SAK scales' progress is reported
     */
    public scaleProject(int amount, int reportTime) {
        this.name = "SAK Scales";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a SAK scale
     */
    protected void doSteps() {

        //1. Grab some aluminum stock

        //2. Throw it onto the mill to carve out the scales
        Main.millLock.lock();
        try{
            System.out.println(name+": Carving out scales on the mill.");
        }finally {
            Main.millLock.unlock();
        }

        //3. Debur with a file if necessary
        //4. Wash

        //5. Throw into the toaster oven to dry completely
        Main.toasterLock.lock();
        try{
            System.out.println(name+": Drying in the toaster oven.");
        }finally {
            Main.toasterLock.unlock();
        }

        //6. Anodize
    }
}
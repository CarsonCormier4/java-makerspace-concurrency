//Class that produces chess sets using given steps
public class chessProject extends knickknacks{


    /**
     * @method Initializes a Chess Set Project object
     * @param amount Number of chess sets to make
     * @param reportTime How often the chess sets progress is reported
     */
    public chessProject(int amount, int reportTime){
        this.name = "Chess Sets";
        this.amount = amount;
        this.reportTime = reportTime;
    }


    /**
     * @method Preforms the production steps for a chess set
     */
    protected void doSteps(){

        //1. Print out the white pieces using the resin printer
        Main.resinLock.lock();
        try{
            System.out.println(name +": Printing white pieces on resin printer.");

        }finally {
            Main.resinLock.unlock();
        }

        //2. Turn the white rooks on the lathe
        Main.latheLock.lock();
        try{
            System.out.println(name +": Turning white rooks on lathe.");
        }finally {
            Main.latheLock.unlock();
        }

        //3. Print out the black peices using the resin printer
        Main.resinLock.lock();
        try{
            System.out.println(name +": Printing black pieces on resin printer.");
        }finally {
            Main.resinLock.unlock();
        }

        //4. Turn the black rooks on the lathe
        Main.latheLock.lock();
        try{
            System.out.println(name +": Turning black rooks on lathe.");
        }finally {
            Main.latheLock.unlock();
        }

        //5. Use the FDM printer to produce the board
        Main.fdmLock.lock();
        try{
            System.out.println(name +": Printing board on FDM printer.");
        }finally {
            Main.fdmLock.unlock();
        }

        //6. Box all the parts up together
    }
}

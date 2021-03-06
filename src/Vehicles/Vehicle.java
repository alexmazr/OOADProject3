package Vehicles;
import java.util.*;

// ABSTRACT CLASS: This class is the superclass for all vehicle types.
// You cannot make an instance of a vehicle, but all vehicle are, well, vehicles. So they extend this class.
public abstract class Vehicle 
{
    private String licensePlate;
    private boolean isCrashed = false;
    private CrashStrategy crashStrategy = new CrashNever();

    public Vehicle (String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    // Strategy pattern algorithm setter
    public void setCrashStrategy (CrashStrategy cs)
    {
        this.crashStrategy = cs;
    }

    public String getLicensePlate ()
    {
        return this.licensePlate;
    }

    public void wash ()
    {
        String result = "shines";
        Random rand = new Random ();
        if (rand.nextInt (10) < 3) result = "sparkles";
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + result + ".");
    }

    public void unlock ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " unlocked.");
    }

    public void lock ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " locked.");
    }

    public void tuneUp ()
    {
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " runs.");
    }

    // This method uses the strategy pattern to determine if the vehicle should crash.
    public void testDrive ()
    {
        String result = "drives.";
        this.isCrashed = this.crashStrategy.isCrashed ();
        if (this.isCrashed) result = "crashed.";
        System.out.println (this.getClass ().getSimpleName () + " " + this.getLicensePlate () + " " + result);
    }

    public boolean isCrashed () 
    {
        return this.isCrashed;
    }
}

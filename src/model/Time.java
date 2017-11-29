package model;

//***************************************************************
//This file isn't made by us 
// Title   : Time
// Author  : Chris Lattner
// Due date: 10-28-96
//
// This Time object provides a number of facilities to keep track
// of time.  When called as a stand alone application, it prompts
// the user for two times and subtracts them.  When used with
// other classes, it provides methods to print time, subtract
// times, create times, and return the number of seconds
// represented by a time.
//
//***************************************************************



public class Time {
    int hours;
    int minutes;
    int seconds;

    // Time constructor:  Simply assign the state of this object values.
    public Time(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
    }

    // Time Constructor: When a Time object is created with no parameters, the
    //    user of the program is prompted for the appropriate info.
    public Time() {
     /*   VInput in = new VInput();

        System.out.print  ("    hours:   ");  // get the hours
        System.out.flush  ();
        hours = in.readInt();

        System.out.print  ("    minutes: ");  // get the minutes
        System.out.flush  ();
        minutes = in.readInt();

        System.out.print  ("    seconds: ");  // get the seconds
        System.out.flush  ();
        seconds = in.readInt();*/
    }

    // Subtract method:  Subtract the time X from the time "this".  This method
    //    needs to be careful to take into account borrowing of time.
    public Time subtract(Time x) {

        //Do the initial subtraction and create the return Time.
        Time ret = new Time(hours-x.hours, minutes-x.minutes, seconds-x.seconds);

        if (ret.seconds < 0) {   // If we need to borrow for the seconds, do it now
            ret.seconds += 60;   //    60 seconds in a minute
            ret.minutes--;       //    1  minute for 60 seconds
        }


        if (ret.minutes < 0) {   // If we need to borrow for the minutes, do it now.
            ret.minutes += 60;   //    60 seconds to an hour
            ret.hours--;
        }

        return (ret);            // Return the result.
    }

    // println Method: This method prints out the contents of a Time object in a neatly
    //    arranged mannor.  At the end, it finishes with a println();
    public void println() {
        boolean comma = false;

        if (hours != 0) {               // If there are hours....
            System.out.print(hours);    //   print them!
            System.out.print(" hour");
            if (hours != 1)             // If there not only one hour,
              System.out.print("s");    //   print an "s" to make it plural.
            comma = true;               // If there are any more components, mark that we
        }                               //   need to draw a comma.


        if (minutes != 0) {             // If there are minutes...
            if (comma)                  // If there were hours,
              System.out.print(", ");   //   then print a comma to seperate them.
            System.out.print(minutes);
            System.out.print(" minute");
            if (minutes != 1)           // Make it plural if neccesary.
              System.out.print("s");
            comma = true;
        }

        if (seconds != 0) {             // If there are seconds...
            if (comma)                  // If there were either minutes or hours,
              System.out.print(", ");   //   print the seperator.

            System.out.print(seconds);
            System.out.print(" second");
            if (seconds != 1)           // Make it plural.
              System.out.print("s");
        }

        System.out.println();
    }

    // seconds Method: The seconds method returns the number of seconds that the objects
    //    state contains.  This is obtained by taking the seconds + the minutes*60 (60
    //    seconds in a minute) + the hours*3600 (3600 seconds in each hour).
    public int seconds() {
        return(seconds + minutes*60 + hours*60*60);
    }

/*
    // Main Method: This is where the whole thing starts...
    public static void main (String args[]) {

        // Get the start time.
        System.out.println("Please enter the start time:");
        Time StartTime = new Time();
        System.out.println();

        // Get the ending time.
        System.out.println("Please enter the ending time: ");
        Time EndTime   = new Time();

        // Compute the amount of elapsed time.
        Time elapsed = EndTime.subtract(StartTime);
        System.out.println();
        System.out.print("The elapsed time is ");
        elapsed.println();   // Print the amount of elapsed time.


        // Print the amount of elapsed seconds.
        System.out.print("Total elapsed seconds: ");
        System.out.println(elapsed.seconds());

        // Wait for <ENTER> to be pressed.
        VInput in = new VInput();
        in.waitForCR();
    }*/
}
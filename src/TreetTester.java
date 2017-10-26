import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TreetTester implements Serializable {

    // can comment out most of the code and still load the old treets because they are saved
    private static final long serialVersionUID = 8922875014907916636L;

    public static void main(String[] args) {
        Treet treet = new Treet(
                "Jessie B",
                "Not his treet but my Treet. Treets are #tweets basically lol",
                new Date(1477436817000L));

        Treet secondTreet = new Treet("John Smith",
                                      "This is just another #tweet..I mean Treet.",
                                       new Date(1477436899000L));

        System.out.printf("This is a new Treet: %s %n",  treet);
        System.out.println("The Word is: ");

        // Testing parsing wards
        for (String word: treet.getWords()) {
           System.out.println(word);
        }

        //
        Treet[] ar= {secondTreet, treet};
        Arrays.sort(ar);
        for (Treet test : ar) {
            System.out.println(test);
        }
        // Now lets save the array of treets/ its in binary
        SaveTreets.save(ar);

        // Now lets load those treets
        System.out.println("these are the loaded treets down here");
        Treet[] reloadedTreets = SaveTreets.load();
        for (Treet loaded : reloadedTreets){
            System.out.println(loaded);
        }

    }

}

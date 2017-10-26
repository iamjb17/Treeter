import java.io.Serializable;
import java.util.Date;

public class Treet implements Comparable, Serializable {

    // Private variables
    private String mAuthor;
    private String mDescription;
    private Date mCreationDate;
    // uncomment to test the loading of the treets
     //String breakIt;

    Treet(String author, String description, Date creationDate) {
        mAuthor = author;
        mDescription = description;
        mCreationDate = creationDate;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmDescription() {
        return mDescription;
    }

    public Date getmCreationDate() {
        return mCreationDate;
    }

    @Override
    public String toString() {

        // added date to test sorting treets.
        return String.format("The Treet is: %s \\ %s \\ %s.",
                mDescription,
                mAuthor,
                mCreationDate);
        // The original String before formatting = "Treet: \"" + mDescription + "\" - @" + mAuthor;
    }

    // splitting up the tweets by word with some punctuation taken out
    String[] getWords() {
        return mDescription.toLowerCase().split("[^\\w#'@-]+");
    }

    @Override
    public int compareTo(Object o) {
        // This is going to be tested by adding the date to the toString
        Treet other = (Treet) o;
        if (equals(other)) {
            return 0;
        }
        int dateComp = mCreationDate.compareTo(other.mCreationDate);
        if (dateComp == 0) {
            return mDescription.compareTo(other.mDescription);
        }
        return dateComp;
    }
}

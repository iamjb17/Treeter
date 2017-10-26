import java.io.*;

class SaveTreets {

    static void save(Treet[] treets) {
        // try with resource block for saving treets
        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                                         new FileOutputStream("treets.ser"))
                ) {
            oos.writeObject(treets);
        } catch (IOException e) {
            System.out.println("File not saved properly");
            e.printStackTrace();
        }
    }

    static Treet[] load(){
        Treet[] treets = new Treet[0];
        try (
                // Ill just split them up this time to show more detail
                FileInputStream fis = new FileInputStream("treets.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            treets = (Treet[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return treets;
    }

}

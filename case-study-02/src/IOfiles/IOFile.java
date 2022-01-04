package IOfiles;

import java.io.*;
import java.util.ArrayList;

public class IOFile<T> {
    public void writeToFile(String path, ArrayList<T> t) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.close();
            fos.close();
        } catch (IOException ios) {
            ios.printStackTrace();
        }
    }

    public ArrayList<T> readFromFile(String path) {
        ArrayList<T> t = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                t = (ArrayList<T>) ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException ios) {
                ios.printStackTrace();
            }
        }
        return t;
    }
}

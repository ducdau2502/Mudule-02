package IOfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile<T> {
    public void writeToFile(String path, List<T> t) {
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

    public  List<T> readDataFromFile(String path) {
        List<T> t = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            t = (List<T>) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException | ClassNotFoundException ios) {
            ios.printStackTrace();
        }
        return t;
    }
}

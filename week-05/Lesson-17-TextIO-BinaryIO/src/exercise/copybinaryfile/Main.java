package exercise.copybinaryfile;

import java.io.*;

public class Main {
    public static void copyFileUsingStream(String source, String dest) {
        File file = new File(source);
        File file1 = new File(dest);

        if (!file.exists()) {
            System.out.println("File not found");
            System.exit(0);
        }

        if (file1.exists()) {
            System.out.println("File destination already exists !!!");
            System.exit(0);
        }

        try {
            InputStream is = new FileInputStream(file);
            OutputStream os = new FileOutputStream(file1);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("copy successfully");
    }

    public static void main(String[] args) {
        String path = "src/exercise/copybinaryfile/source/Moom_3.2.24.zip";
        String dest = "src/exercise/copybinaryfile/destination/dest.zip";
        copyFileUsingStream(path, dest);

    }
}

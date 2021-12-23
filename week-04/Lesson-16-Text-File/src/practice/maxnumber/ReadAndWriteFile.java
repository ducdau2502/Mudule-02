package practice.maxnumber;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {

            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }

            br.close();

        } catch(Exception e) {
            System.err.println("File không tồn tại!");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);

        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("/Volumes/Data/workspace/codegym/module-02/week-04/Lesson-16-Text-File/src/practice/maxnumber/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("/Volumes/Data/workspace/codegym/module-02/week-04/Lesson-16-Text-File/src/practice/maxnumber/results.txt", maxValue);
    }
}

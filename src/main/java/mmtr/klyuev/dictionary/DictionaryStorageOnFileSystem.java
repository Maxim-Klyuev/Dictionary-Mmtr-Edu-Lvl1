package mmtr.klyuev.dictionary;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
@Scope("prototype")
public class DictionaryStorageOnFileSystem implements DictionaryStorage {
    private File latinDict = new File("LatinDict.txt");
    private File digitDict = new File("DigitDict.txt");
    private Scanner scanner;

    @Override
    public String showAllWords() {
        String str = "";
        try {
            scanner = new Scanner(latinDict); // latin/digit
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                str = str + line + "\n";
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        return str;
    }

    @Override
    public String translationOneWord(String key) {
        Map<String, String> map = new HashMap<>();
        try {
            scanner = new Scanner(latinDict);    // latin/digit
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String args[] = line.split(" ");
                map.put(args[0], args[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        return map.get(key);
    }

    @Override
    public void addWord(String str) {
        try (FileWriter writer = new FileWriter(latinDict, true)) {    // latin/digit
            writer.write(str + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWord(String str) {
        File temp = new File("Temp.txt");
        String s;
        try {
            scanner = new Scanner(latinDict);               //latin/digit
            try (PrintWriter tempWriter = new PrintWriter(new FileWriter(temp))) {
                while (scanner.hasNextLine()) {
                    s = scanner.nextLine();
                    if (!s.trim().contains(str)) {
                        tempWriter.println(s);
                        tempWriter.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        latinDict.delete();
        temp.renameTo(latinDict);
    }
}
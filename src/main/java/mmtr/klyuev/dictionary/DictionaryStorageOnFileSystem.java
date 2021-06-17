package mmtr.klyuev.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryStorageOnFileSystem implements DictionaryStorage {

    private File dictionary;

    DictionaryStorageOnFileSystem(String filePath) {
        dictionary = new File(filePath);
    }

    private Scanner scanner;

    @Override
    public String findAllWords() {
        String str = "";
        try {
            scanner = new Scanner(dictionary);
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
    public String findWord(String word) {
        Map<String, String> map = new HashMap<>();
        try {
            scanner = new Scanner(dictionary);
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
        return map.get(word);
    }

    @Override
    public void addWord(String record) {
        try (FileWriter writer = new FileWriter(dictionary, true)) {

            writer.write(record + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWord(String word) {
        File temp = new File("Temp.txt");
        String s;
        try {
            scanner = new Scanner(dictionary);
            try (PrintWriter tempWriter = new PrintWriter(new FileWriter(temp))) {
                while (scanner.hasNextLine()) {
                    s = scanner.nextLine();
                    String[] keyValue = s.split(" ");
                    String value = keyValue[0];
                    if (!value.trim().equals(word)) {
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
        dictionary.delete();
        temp.renameTo(dictionary);
    }
}
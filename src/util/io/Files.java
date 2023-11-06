package util.io;

import java.io.*;
import java.util.Scanner;

public abstract class Files {
    // Helper methods for file I/O

    public static String readAsset(String filename) {
        StringBuilder contents = new StringBuilder();

        try {
            File assetFile = new File("assets/" + filename);
            Scanner fileRead = new Scanner(assetFile);
            while (fileRead.hasNextLine())
                contents.append(fileRead.nextLine());
        } catch (FileNotFoundException fn) {
            contents.append("File not found!");
        }

        return contents.toString();
    }

    public static void writeStudentList(String toWrite) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "students_list.txt"))) {
            writer.write(toWrite);
            writer.close();
            System.out.println("SUCCESS - students saved in 'students_list.txt'");
        } catch (IOException ie) {
            System.out.println("ERROR - not able to write the students file.");
            System.out.println(ie.getMessage());
        }
    }

    public static void writeStudentDetails(String name, String details) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"));
            writer.write(details);
            writer.close();
            System.out.println("SUCCESS - student's details saved to file '" + name + ".txt'");
        } catch (
                IOException ie) {
            System.out.println("ERROR - not able to write student's details to file.");
            System.out.println(ie.getMessage());
        }
    }
}

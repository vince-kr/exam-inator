package util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Files {
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
}

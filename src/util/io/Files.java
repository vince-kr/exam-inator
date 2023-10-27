package util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {
    private Files() {
        throw new UnsupportedOperationException("Don't instantiate this!");
    }

    public static String readAsset(String filename) {
        StringBuilder contents = new StringBuilder();

        try {
            File assetFile = new File("assets/" + filename);
            Scanner fileRead = new Scanner(assetFile);
            while (fileRead.hasNextLine())
                contents.append(fileRead.nextLine());
        } catch (FileNotFoundException fn) {
            fn.printStackTrace();
        }

        return contents.toString();
    }
}

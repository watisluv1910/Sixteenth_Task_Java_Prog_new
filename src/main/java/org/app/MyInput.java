package org.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Function;

public class MyInput {

    private final static Scanner scanner = new Scanner(System.in);

    public static <T> T inputInteger(String message, Function<Integer, T> converter) {
        while (true) {
            try {
                System.out.println(message);
                T temp = converter.apply(scanner.nextInt());
                scanner.nextLine(); // Removing \n
                return temp;
            }
            catch (Exception ex) {
                System.err.println("Incorrect input format.");
                System.exit(1);
            }
        }
    }

    public static <T> T inputString(String message, Function<String, T> converter) {
        while (true) {
            try {
                System.out.println(message);
                return converter.apply(scanner.nextLine());
            } catch (Exception ex) {
                System.err.println("Incorrect input format.");
                System.exit(1);
            }
        }
    }

    public static String readFileLine(String fileName, Integer lineNumber)
            throws IOException {

        String str = new String(
                Files.readAllBytes(Paths.get(fileName)));

        String line = "";

        try {

            line = str.split("\n")[lineNumber];
            return line;

        } catch (ArrayIndexOutOfBoundsException ex) {

            System.err.println("Wrong line number.");
            System.exit(1);
        }

        return line;
    }
}

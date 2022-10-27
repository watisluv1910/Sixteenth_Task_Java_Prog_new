package org.app;

import org.firstSubtask.Areas;

import java.io.IOException;

public class App {

    public static void main( String[] args ) {

        while (true) {

            Integer navigationVar = MyInput.inputInteger("""
                    Navigation menu:
                    Enter 1 to run first subtask.
                    Enter 2 to run second subtask and etc. up to 3.
                    Enter any other digit to stop the program.""", Integer::valueOf);

            switch (navigationVar) {
                case 1 -> {
                    new Areas();
                }
                case 2 -> {

                }
                case 3 -> {

                }
                default -> System.exit(1);
            }
        }
    }
}
package com.gmail.ditritusa;

import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
    private ShoppingList spl = new ShoppingList();

   public void start() {

        System.out.println("Ready");

        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.nextLine();
            String[] splited = command.split("\\s+");

            if (splited[0].equals("stop") | splited[0].equals("exit")) {

                System.out.println("Shutting down");
                System.exit(0);
            }
            if (splited[0].equals("add")) {

                spl.add(splited);
            }
            if (splited[0].equals("list")) {

                spl.list();
            }
            if (splited[0].equals("total")) {

                spl.convertor(splited[1]);

            }
            if (splited[0].equals("clear")) {

                spl.clear(splited[1]);
            }

        }
    }
}

package hexoplasm.minijavaprojects;

import java.util.Scanner;

public class DiceGame {
    static String user1, user2;
    static Scanner inp = new Scanner(System.in);
    static int u1s = 0, u2s = 0;

    public static int roll() {
        return (int)(Math.random()*6)+1;
    }

    public static void interactiveRoll() {
        System.out.print("press enter to roll your die.");
        inp.nextLine();
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void gameCalc(int user) {
        int x = roll();
        int y = roll();
        int z = (x+y)%2;
        int a = 0;
        String b = "";
        String c = x+" and "+y;
        if (user==1) {
            a = u1s;
            b = user1;
        } else {
            a = u2s;
            b = user2;
        }
        System.out.print(b+", ");
        interactiveRoll();


        if (x == y) {
            System.out.println("You rolled "+c+", a double!");
            delay(2000);
            int d = roll();
            a += d;
            System.out.print(b+", ");
            interactiveRoll();
            System.out.println("You re-rolled, and got "+d+"!");
        } else if (z == 0) {
            System.out.println("You rolled "+c+", an even number, +10 points!");
            a += 10;
        } else {
            System.out.println("You rolled "+c+", an odd number, -5 points!");
            if (a>4) a -= 5; else a = 0;
        }
        System.out.println("\n");

        if (user==1) {
            u1s = a;
        } else {
            u2s = a;
        }
    }

    public static void tiebreaker() {
        System.out.println("Since it's a tie, a reroll is necessary.");
        int tie_u1s, tie_u2s;
        tie_u1s = roll();
        tie_u2s = roll();
        System.out.println(user1+" rolled a "+tie_u1s+" and "+user2+" rolled a "+tie_u2s+", meaning that...");
        delay(4000);
        if (tie_u1s>tie_u2s) {
            System.out.println(user1+" wins!");
        } else if (tie_u2s>tie_u1s) {
            System.out.println(user2+" wins!");
        } else {
            System.out.println("Another tie! We will re-roll again.");
            tiebreaker();
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\n\n\n\nWelcome to the dice game, here are the rules.");
        delay(2000);
        System.out.println("If your total is an even number, you gain 10 points.");
        delay(2000);
        System.out.println("However, if you get an odd number, you lose 5 points!");
        delay(2000);
        System.out.println("If both your die give the same value, you get to roll with one dice again.");
        delay(2000);
        System.out.println("Whatever that roll is will be added to your points.");
        delay(2000);
        System.out.println("Whoever has the highest score at the end wins!");
        delay(4000);


        System.out.print("\nPlayer 1, enter your name: ");
        user1 = inp.nextLine();
        //delay(4000);
        System.out.print("Player 2, enter your name: ");
        user2 = inp.nextLine();
        System.out.println("\n\n\n");


        for (int i=0; i<5; i++) {
            delay(2000);

            gameCalc(1);
            delay(2000);
            gameCalc(2);

            delay(2000);

            System.out.println("\n\n"+user1+" now has "+u1s+" points!");
            System.out.println(user2+" now has "+u2s+" points!\n\n");
        }

        if (u1s == u2s) {
            tiebreaker();
        } else if (u1s > u2s) {
            System.out.println(user1+" wins!");
        } else {
            System.out.println(user2+" wins!");
        }

        inp.close();
    }
}
package hexoplasm.minijavaprojects;

// Unfinished


import java.util.Scanner;

public class DiceGame {
    public static int roll() {
        return (int)(Math.random()*6)+1;
    }
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("\n\n\n\n\nWelcome to the dice game, here are the rules.");
        //delay(2000);
        System.out.println("If your total is an even number, you gain 10 points.");
        //delay(2000);
        System.out.println("However, if you get an odd number, you lose 5 points!");
        //delay(2000);
        System.out.println("If both your die give the same value, you get to roll again.");
        //delay(2000);
        System.out.println("Whatever you roll is added to your points.");
        //delay(2000);
        System.out.println("Whoever has the highest score at the end wins!");
        
        // u stands for user and s stands for score
        int u1s = 0;
        int u2s = 0;



        //delay(4000);
        System.out.print("\n\nPlayer 1, enter your name: ");
        String user1 = inp.nextLine();
        //delay(4000);
        /*System.out.print("\n\nPlayer 2, enter your name: ");
        String user2 = inp.nextLine();*/

        int u1s1 = roll();
        int u1s2 = roll();
        int u1x = (u1s1+u1s2)%2;

        if (u1x == 0) {
            System.out.println("You rolled an even number, +10 points!");
            u1s += 10;
        } else if (u1x == 1) {
            System.out.println("You rolled an odd number, -5 points!");
            if (u1x>4) u1s -= 5; else u1s = 0;
        } else {
            System.out.println("You rolled a double!");
            int x = roll();
            u1s += x;
            System.out.println("You re-rolled, and got "+x+"!");
        }


        inp.close();
    }
}
import java.util.Scanner;

public class Player {
    String name;
    int health = 100;

    Player(String playerName) {
        this.name = playerName;
    }

    void takeDamage(int damageAmount) {
        health -= damageAmount;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your player name.");
        String name = sc.nextLine();
        Player p1 = new Player(name);

        System.out.println("Enter the damage");
        int damage = sc.nextInt();
        p1.takeDamage(damage);

        System.out.println("After damage the current health is:- " + p1.health);

        sc.close();

    }
}

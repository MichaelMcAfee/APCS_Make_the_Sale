import java.util.Scanner;
public class ConversationParser
{
    Game game = new Game();
    public void conversationOnePrompt()
    {
        Scanner s = new Scanner(System.in);
        game.type("Customer: What do you want?");
        game.sleepShort();
        System.out.println("");
        game.type("You can say:");
        System.out.println("");
        game.type("A) Hi, I have an incredible opportunity for you!");
        System.out.println("");
        game.type("B) Hello, would you like to buy " + "[x]" + "?");
        System.out.println("");
        game.type("C) I have something that will make your day!");
        System.out.println("");
        game.type("You can type a, b, or c");
        System.out.println("");
        System.out.print("> ");
        String input = s.nextLine(); // Get next line of user input
        if (input.toLowerCase().equals("a"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Go away, I don't want any part of your scam!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("b"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Why yes, I would love some " + "[x]" + "! I will buy 5!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("c"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Oh. Cool.");
            System.out.println("");
        }
    }
    
    public void conversationTwoPrompt()
    {
        Scanner s = new Scanner(System.in);
        game.type("Customer: What do you want?");
        game.sleepShort();
        System.out.println("");
        game.type("You can say:");
        System.out.println("");
        game.type("A) Hi, I have an incredible opportunity for you!");
        System.out.println("");
        game.type("B) Hello, would you like to buy " + "[x]" + "?");
        System.out.println("");
        game.type("C) I have something that will make your day!");
        System.out.println("");
        game.type("You can type a, b, or c");
        System.out.println("");
        System.out.print("> ");
        String input = s.nextLine(); // Get next line of user input
        if (input.toLowerCase().equals("a"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Go away, I don't want any part of your scam!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("b"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Why yes, I would love some " + "[x]" + "! I will buy 5!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("c"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Oh. Cool.");
            System.out.println("");
        }
    }
    
    public void conversationThreePrompt()
    {
        Scanner s = new Scanner(System.in);
        game.type("Customer: What do you want?");
        game.sleepShort();
        System.out.println("");
        game.type("You can say:");
        System.out.println("");
        game.type("A) Hi, I have an incredible opportunity for you!");
        System.out.println("");
        game.type("B) Hello, would you like to buy " + "[x]" + "?");
        System.out.println("");
        game.type("C) I have something that will make your day!");
        System.out.println("");
        game.type("You can type a, b, or c");
        System.out.println("");
        System.out.print("> ");
        String input = s.nextLine(); // Get next line of user input
        if (input.toLowerCase().equals("a"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Go away, I don't want any part of your scam!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("b"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Why yes, I would love some " + "[x]" + "! I will buy 5!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("c"))
        {
            game.customer();
            System.out.println("");
            game.type("Customer: Oh. Cool.");
            System.out.println("");
        } 
    }
}

import java.util.Scanner;
public class ConversationParser
{
    public void customerOpen()
    {
        System.out.print('\u000C');
        System.out.println("    ___________  ");
        System.out.println("   |           | ");
        System.out.println("   |  |     |  | ");
        System.out.println("   |    ___    | ");
        System.out.println("   |   |___|   | ");
        System.out.println("    - - - - - -  ");
        System.out.println("        /|\\      ");
        System.out.println("       / | \\     ");
        System.out.println("      /  |  \\    ");
        System.out.println("     /   |   \\   ");
        System.out.println("         |       ");
        System.out.println("         |       ");
    }
    
    public void customerClosed()
    {
        System.out.print('\u000C');
        System.out.println("    ___________  ");
        System.out.println("   |           | ");
        System.out.println("   |  |     |  | ");
        System.out.println("   |           | ");
        System.out.println("   |   -----   | ");
        System.out.println("    - - - - - -  ");
        System.out.println("        /|\\      ");
        System.out.println("       / | \\     ");
        System.out.println("      /  |  \\    ");
        System.out.println("     /   |   \\   ");
        System.out.println("         |       ");
        System.out.println("         |       ");
    }
    
    public void customer()
    {
        Game game = new Game();
        System.out.print('\u000C');
        customerClosed();
        game.sleepShort();
        customerOpen();
        game.sleepShort();
        customerClosed();
        game.sleepShort();
        customerOpen();
        game.sleepShort();
        customerClosed();
        game.sleepShort();
        customerOpen();
        game.sleepShort();
        customerClosed();
        game.sleepShort();
        customerOpen();
        game.sleepShort();
        customerClosed();
    }
    
    public void conversationOnePrompt(String item)
    {
        Scanner s = new Scanner(System.in);
        Game.type("Customer: What do you want?");
        Game.sleepShort();
        System.out.println("");
        Game.type("You can say:");
        System.out.println("");
        Game.type("A) Hi, I have an incredible opportunity for you!");
        System.out.println("");
        Game.type("B) Hello, would you like to buy " + item + "?");
        System.out.println("");
        Game.type("C) I have something that will make your day!");
        System.out.println("");
        Game.type("You can type a, b, or c");
        System.out.println("");
        System.out.print("> ");
        String input = s.nextLine(); // Get next line of user input
        if (input.toLowerCase().equals("a"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Go away, I don't want any part of your scam!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("b"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Why yes, I would love some " + item + "! I will buy 5!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("c"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Oh. Cool.");
            System.out.println("");
        }
    }
    
    public int conversationTwoPrompt(String item)
    {
        Scanner s = new Scanner(System.in);
        Game.type("Customer: What do you want?");
        Game.sleepShort();
        System.out.println("");
        Game.type("You can say:");
        System.out.println("");
        Game.type("A) Hi, I have an incredible opportunity for you!");
        System.out.println("");
        Game.type("B) Hello, would you like to buy " + item + "?");
        System.out.println("");
        Game.type("C) I have something that will make your day!");
        System.out.println("");
        Game.type("You can type a, b, or c");
        System.out.println("");
        System.out.print("> ");
        String input = s.nextLine(); // Get next line of user input
        int totalItems = 0;
        if (input.toLowerCase().equals("a"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Go away, I don't want any part of your scam!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("b"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Why yes, I would love some " + item + "! I will buy 5!");
            totalItems = totalItems = 5;
            System.out.println("");
        }
        else if (input.toLowerCase().equals("c"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Oh. Cool.");
            System.out.println("");
        }
        return totalItems;
    }
    
    public void conversationThreePrompt(String item)
    {
        Scanner s = new Scanner(System.in);
        Game.type("Customer: What do you want?");
        Game.sleepShort();
        System.out.println("");
        Game.type("You can say:");
        System.out.println("");
        Game.type("A) Hi, I have an incredible opportunity for you!");
        System.out.println("");
        Game.type("B) Hello, would you like to buy " + item + "?");
        System.out.println("");
        Game.type("C) I have something that will make your day!");
        System.out.println("");
        Game.type("You can type a, b, or c");
        System.out.println("");
        System.out.print("> ");
        String input = s.nextLine(); // Get next line of user input
        if (input.toLowerCase().equals("a"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Go away, I don't want any part of your scam!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("b"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Why yes, I would love some " + item + "! I will buy 5!");
            System.out.println("");
        }
        else if (input.toLowerCase().equals("c"))
        {
            customer();
            System.out.println("");
            Game.type("Customer: Oh. Cool.");
            System.out.println("");
        } 
    }
}

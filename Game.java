import java.util.Scanner;/** * Class Game - the main class of the "Make the Sale: (x) Edition!" game. * * Author:  Michael McAfee * *  To play this game, right click the 'Game' class and run 'main' * *  This class creates all rooms, creates the parser and starts the game. It also evaluates the *  commands that the parser returns. */class Game {    public static String[] items = {"Vacuums", "Plungers", "Knives", "Candles", "Bibles", "Cheeses", "Smells"};    public int selectedItem;    private Room office;    private Room car;    private Room sidewalk1;    private Room sidewalk2;    private Room sidewalk3;    private Room house1;    private Room house2;    private Room house3;    private int itemsSold;    private int housesVisited;    private boolean visitedOne;    private boolean visitedTwo;    private boolean visitedThree;    private Parser parser;    private Room currentRoom;    private Room previousRoom;        public static void main(String[] args) {        Game game = new Game();        game.play();    }        /**     * Create the game and initialise its internal map.     */    public Game()     {        createRooms();        parser = new Parser();    }    /**     * Create all the rooms and link their exits together.     */    private void createRooms()    {        // create the rooms        car = new Room("your car..");        sidewalk1 = new Room("the left end of the sidewalk.");        sidewalk2 = new Room("the middle of the sidewalk.");        sidewalk3 = new Room("the right end of the sidewalk.");        house1 = new Room("the first house.");        house2 = new Room("the second house.");        house3 = new Room("the third house.");        office = new Room("your boss's office.");                // initialise room exits        car.setExits(sidewalk2, null, office, null);        sidewalk2.setExits(house2, sidewalk3, car, sidewalk1);        sidewalk1.setExits(house1, sidewalk2, null, null);        sidewalk3.setExits(house3, null, null, sidewalk2);        house1.setExits(null, null, sidewalk1, null);        house2.setExits(null, null, sidewalk2, null);        house3.setExits(null, null, sidewalk3, null);        office.setExits(car, null, null, null);                currentRoom = car;  // start game outside                    }    /**     *  Main play routine.  Loops until end of play.     */    public void play()     {                    printWelcome();        // Enter the main command loop.  Here we repeatedly read commands and        // execute them until the game is over.                        boolean finished = false;        while (! finished)        {            Command command = parser.getCommand();            finished = processCommand(command);        }        System.out.print('\u000C');        type("Thank you for playing.  Good bye.");    }    public void type(String str)    {        for( int i = 0; i < str.length(); i++ )        {            System.out.print( str.charAt( i ) );            try{ Thread.sleep(20); }catch( Exception e ){}        }    }        private void sleep()    {        try        {            Thread.sleep(3000); // sets delay        }        catch(Exception e){}    // catches exception    }        public void sleepShort()    {        try        {            Thread.sleep(400); // sets delay        }        catch(Exception e){}    // catches exception    }        private void nextLine()    {        try        {            Thread.sleep(3000); // sets delay        }        catch(Exception e){}    // catches exception        System.out.print('\u000C');  // clears terminal    }        /**     * Print out the opening message for the player.     */    public void printWelcome()    {        System.out.print('\u000C');        selectedItem = (int)(Math.random()*items.length); // a random number between 0 and 2 (3 choices)        type("Welcome to 'Make the Sale; " + items[selectedItem] + " Edition!'");        nextLine();        type("'Make the Sale; " + items[selectedItem] + " Edition!' is an adventure game about selling " + items[selectedItem]);        nextLine();        type("There are three houses you have to visit and sell " + items[selectedItem] + " to.");        nextLine();        type("After visiting all three houses you must return to your boss at the office.");        nextLine();        type("You must sell 10 " + items[selectedItem] + " before you return to your boss.");        nextLine();        type("If you haven't sold 10 " + items[selectedItem] + " after visiting all houses you will be fired.");        nextLine();        type("Type 'help' if you need help.");        nextLine();        System.out.println(currentRoom.longDescription());    }    /**     * Given a command, process (that is: execute) the command.     * If this command ends the game, true is returned, otherwise false is     * returned.     */    private boolean processCommand(Command command)     {        if(command.isUnknown())        {            System.out.print('\u000C');            type("I don't know what you mean...");            System.out.println("");        }        String commandWord = command.getCommandWord();        if (commandWord == null || command == null)         {            type("Wait until the text dissapears before entering a command!");            sleep();            System.out.println(currentRoom.longDescription());        }        else if (commandWord.equals("help"))            printHelp();        else if (commandWord.equals("go"))            goRoom(command);        else if (commandWord.equals("back"))            goBack(command);        else if (commandWord.equals("sales"))            checkSales();        else if (commandWord.equals("quit"))        {            if(command.hasSecondWord())                System.out.println("Quit what?");            else                return true;  // signal that we want to quit        }        return false;    }    // implementations of user commands:    private void checkSales()    {        System.out.print('\u000C');        type("Your current sales are: " + "[x]" + " " + items[selectedItem]);        sleep();        System.out.println(currentRoom.longDescription());    }        private void youLose()    {        System.out.print('\u000C');        type("YOU LOSE!");        sleep();    }        private void youWin()    {        System.out.print('\u000C');        type("YOU WIN!");        sleep();    }        /**     * Print out some help information.     * Here we print some stupid, cryptic message and a list of the      * command words.     */    private void printHelp()     {        System.out.print('\u000C');        type("You must sell 10 or more " + items[selectedItem] + "!");        System.out.println("");        type("Convince your customers to buy more!");        System.out.println(" ");        System.out.print("Your command words are: ");        System.out.println("");        parser.showCommands();        sleep();        sleep();        sleep();        System.out.println(currentRoom.longDescription());    }    private void customerOpen()    {        System.out.print('\u000C');        System.out.println("    ___________  ");        System.out.println("   |           | ");        System.out.println("   |  |     |  | ");        System.out.println("   |    ___    | ");        System.out.println("   |   |___|   | ");        System.out.println("    - - - - - -  ");        System.out.println("        /|\\      ");        System.out.println("       / | \\     ");        System.out.println("      /  |  \\    ");        System.out.println("     /   |   \\   ");        System.out.println("         |       ");        System.out.println("         |       ");    }        private void customerClosed()    {        System.out.print('\u000C');        System.out.println("    ___________  ");        System.out.println("   |           | ");        System.out.println("   |  |     |  | ");        System.out.println("   |           | ");        System.out.println("   |   -----   | ");        System.out.println("    - - - - - -  ");        System.out.println("        /|\\      ");        System.out.println("       / | \\     ");        System.out.println("      /  |  \\    ");        System.out.println("     /   |   \\   ");        System.out.println("         |       ");        System.out.println("         |       ");    }        public void customer()    {        System.out.print('\u000C');        customerClosed();        sleepShort();        customerOpen();        sleepShort();        customerClosed();        sleepShort();        customerOpen();        sleepShort();        customerClosed();        sleepShort();        customerOpen();        sleepShort();        customerClosed();        sleepShort();        customerOpen();        sleepShort();        customerClosed();    }        private void customerOne()    {        System.out.print('\u000C');        type("You're at the first house.");        sleepShort();        System.out.println("");        type("You've encountered a potential customer!");        sleep();        customer();        ConversationParser one = new ConversationParser();        one.conversationOnePrompt();    }        private void customerTwo()    {        System.out.print('\u000C');        type("You're at the second house.");        sleepShort();        System.out.println("");        type("You've encountered a potential customer!");        sleep();        customer();        ConversationParser two = new ConversationParser();        two.conversationTwoPrompt();    }        private void customerThree()    {        System.out.print('\u000C');        type("You're at the third house.");        sleepShort();        System.out.println("");        type("You've encountered a potential customer!");        sleep();        customer();        ConversationParser three = new ConversationParser();        three.conversationThreePrompt();    }        /**      * Try to go to one direction. If there is an exit, enter the new     * room, otherwise print an error message.     */    private void goRoom(Command command)     {        if(!command.hasSecondWord())        {            // if there is no second word, we don't know where to go...            System.out.print('\u000C');            type("Go where?");            sleep();            System.out.println(currentRoom.longDescription());            return;        }        String direction = command.getSecondWord();        // Try to leave current room.        Room nextRoom = currentRoom.nextRoom(direction);                if (nextRoom == null)        {            System.out.print('\u000C');            type("You can't go that way!");            sleep();            System.out.println(currentRoom.longDescription());        }                else         {            previousRoom = currentRoom;            currentRoom = nextRoom;            System.out.println(currentRoom.longDescription());        }                if(currentRoom == office)        {            if(housesVisited == 3)            {                System.out.print('\u000C');                System.out.println(currentRoom.longDescription());                Scanner s = new Scanner(System.in);                if(itemsSold >= 10)                {                    type("Boss: Congrats! You sold more than 10! You're still employed!");                    System.out.println("");                    sleep();                    youWin();                    System.out.println("");                    type("Play again?");                    System.out.println("");                    String input = s.nextLine().toUpperCase();                    if (input.toLowerCase().equals("yes"))                    {                        Game game = new Game();                        game.play();                    }                    if (input.toLowerCase().equals("no"))                    {                        System.exit(0);                    }                }                else                {                    type("Boss: You've failed me. You didn't sell 10. You're fired.");                    System.out.println("");                    sleep();                    youLose();                    System.out.println("");                    sleep();                    type("Play again?");                    System.out.println("");                    String input = s.nextLine().toUpperCase();                    if (input.toLowerCase().equals("yes"))                    {                        Game game = new Game();                        game.play();                    }                    if (input.toLowerCase().equals("no"))                    {                        System.exit(0);                    }                }            }            else            {                type("You must visit all three houses before going to the office!");                sleep();                currentRoom = car;                System.out.println(currentRoom.longDescription());            }        }                if(currentRoom == house1)        {            if (!visitedOne)             {                housesVisited++;                visitedOne = true;                customerOne();            }            else            {                System.out.print('\u000C');                type("You've already been in this house!");                sleep();                currentRoom = sidewalk1;                System.out.println(currentRoom.longDescription());            }        }                if(currentRoom == house2)        {            if (!visitedTwo)             {                housesVisited++;                visitedTwo = true;                customerTwo();            }            else            {                System.out.print('\u000C');                type("You've already been in this house!");                sleep();                currentRoom = sidewalk2;                System.out.println(currentRoom.longDescription());            }        }                if(currentRoom == house3)        {            if (!visitedThree)             {                housesVisited++;                visitedThree = true;                customerThree();            }            else            {                System.out.print('\u000C');                type("You've already been in this house!");                sleep();                currentRoom = sidewalk3;                System.out.println(currentRoom.longDescription());            }        }    }        private void goBack(Command command)    {        if(previousRoom == null)        {            System.out.print('\u000C');            type("Can't go back if you haven't gone somewhere");            sleep();            System.out.println(currentRoom.longDescription());            return;        }        if(command.hasSecondWord())        {            System.out.print('\u000C');            type("You can only go to where you were previously.");            sleep();            return;        }        System.out.println(previousRoom.longDescription());        currentRoom = previousRoom;    }}
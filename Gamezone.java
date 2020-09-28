import java.util.Random;
import java.util.Scanner;

/**
 * @author Matthew Diaz
 *
 */
 class GameZone {
public static Random rand;
public static Scanner scan;
/**
 * 21 Game
 */
public static void TwentyOne(){
   int user = 0;
   String x = "";
   
   do{
   
   int draw = rand.nextInt(11)+1;
   System.out.println("You drew "+draw+".");
   user = user+draw;
   System.out.println("Current total is: "+user+".");
   if(user == 21){
       System.out.println("You Won! Go brag to all your friends ");
       return;
   }
   if(user > 21){
       System.out.println("You Lost, better luck next time ");
       return;
   }
   System.out.print("Wanna draw another card? ");
   x = scan.nextLine();
   }while(x.compareToIgnoreCase("n")!=0);
   int opponent  = rand.nextInt(8)+13;
   
   System.out.println("Your opponent drew "+opponent+".");
   if(opponent <= user){
   System.out.println("You won! Go brag to all your friends ");
   }
   else{
   
   System.out.println("You lost, Sorry Pal");
   }
}
/**
 * RPS Game
 */
public static void RockScissorsPaper(){
  
   int z = rand.nextInt(3)+1;
   int x = rand.nextInt(3)+1;

   System.out.println("You played "+getChoice(z)
           +", and the your opponent played "+getChoice(x));
   if(z == x){
   System.out.println("It was a draw.");
   }
   else if((z==1 && x==2) || (z==2 && x==3) || (z==3 && x==1)){
   System.out.println("You won. You are a True Champion");
   }
   else{
 
   System.out.println("You lost. Better luck next time");
   }
}
public static String getChoice(int y){
   if(y == 1){
   return "Paper";
   }
   else if(y == 2){
   return "Rock";
   }
   return "Scissors";
}

public static void main(String[] args){
   rand = new Random();
   scan = new Scanner(System.in);
   System.out.println("*****************************************");
   System.out.println("**\tWelcome to the Game Zone\t**");
   System.out.println("*****************************************");

   int choice = 0;
  
   do{
 
   System.out.println("What would you like to play?");
   System.out.println("1. Twenty-one");
   System.out.println("2. Rock Paper Scissors");
   System.out.println("3. Neither - I'm done!");
   System.out.print("Please enter the number of your choice: ");
   choice = Integer.parseInt(scan.nextLine());

   switch(choice){
       case 1:
       TwentyOne();
       break;
       case 2:
       RockScissorsPaper();
       break;
       default:
       break;
   }
   }while(choice != 3);
   scan.close();
   System.out.println("Thank you for playing");
}
}
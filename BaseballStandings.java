
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ Matthew Diaz 
 *
 */

class BaseballStandings {

  public static void Welcome() {
    System.out.println("******************************************");
    System.out.println(" 2020 BASEBALL STANDING ANALYZER");
    System.out.println("******************************************");
  } 

/**
 * Displays Menu Options 
 *
 */
  public static int LeaugeChoice(Scanner sc) {
    System.out.println("Which Standings would you like to see?"); 
    System.out.println("1. AL East\n2. Al Central\n3. AL West"); 
    System.out.println("4. NL East\n5. NL Central\n6. NL West"); 
    System.out.println("7. All\n8. Quit"); 
    System.out.print("Enter your selection: "); 
    int choice = sc.nextInt();
    return choice;
  } 

  public static double getAvg(String line) {
    String[] parts = line.split("\t");
    double gamesPlayed =
      (Integer.parseInt(parts[1])) + (Integer.parseInt(parts[2]));
    double avg = (Integer.parseInt(parts[1])) / gamesPlayed;
    return avg;
  } 
/**
 * Displays formatted table 
 *
 */
  public static void displayStats(ArrayList<String> standings) {
    String[] parts;
    double avg; 
    System.out.println(
      "----------------------------------------------------------------"
    );
    System.out.println("Teams: Wins: Loses: Pct: ");
    System.out.println(
      "----------------------------------------------------------------"
    );
    for (String standing : standings) {
      parts = standing.split("\t");
      avg = getAvg(standing);
   
      System.out.printf(
        "%-15s%-7s%-7s%5.2f \n ",
        parts[0],
        parts[1],
        parts[2],
        avg
      );
     
    } 
    
  } 

  public static void displayStats2(ArrayList<String> standings) {
    String[] parts;
    double avg;
    System.out.println("-----------------------------");
    System.out.println("Teams: Pct:");
    System.out.println("-----------------------------");
    for (String standing : standings) {
      parts = standing.split("\t");
      avg = getAvg(standing);
      System.out.printf("%-15s%7.2f\n ", parts[0], avg);
   
    } 
   
  } 

  public static void byAvg(ArrayList<String> teams, String line) {
    double avg1 = getAvg(line); 
    double avg2;
    int pos = -1;
    for (int i = 0; i < teams.size(); i++) {
      avg2 = getAvg(teams.get(i)); 
      if (avg1 > avg2) {
        pos = i;
        break;
      } 
    }
    if (pos < 0) {
      teams.add(line);
    } else {
      teams.add(pos, line);
    } 
  }

/**
 * Array Section 
 *
 */

  public static void main(String[] args) {
 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter File Name:  ");
    String fname = sc.nextLine(); 
    ArrayList<String> Aleast = new ArrayList<String>();
    ArrayList<String> Alcentral = new ArrayList<String>();
    ArrayList<String> Alwest = new ArrayList<String>();
    ArrayList<String> Nleast = new ArrayList<String>();
    ArrayList<String> Nlcentral = new ArrayList<String>();
    ArrayList<String> Nlwest = new ArrayList<String>();
    ArrayList<String> Target = null;
    ArrayList<String> All = new ArrayList<String>(); 
    String line, sem;
    String[] parts;
    boolean goAhead;
    int choice;
    try {
      Scanner fsc = new Scanner(new File(fname));
      while (fsc.hasNextLine()) {
        line = fsc.nextLine();
        parts = line.split("\t");
        if (parts[0].equalsIgnoreCase("LEAGUE")) {
          sem = parts[1].toUpperCase();
          if (sem.equalsIgnoreCase("AL EAST")) {
            Target = Aleast;
          } else if (sem.equalsIgnoreCase("AL CENTRAL")) {
            Target = Alcentral;
          } else if (sem.equalsIgnoreCase("AL West")) {
            Target = Alwest;
          } else if (sem.equalsIgnoreCase("NL EAST")) {
            Target = Nleast;
          } else if (sem.equalsIgnoreCase("NL CENTRAL")) {
            Target = Nlcentral;
          } else if (sem.equalsIgnoreCase("NL WEST")) {
            Target = Nlwest;
          }
        } else {
          Target.add(line);
          byAvg(All, line); 
        } 
      } 
      Welcome(); 
      fsc.close(); 
      goAhead = true;
    } catch (Exception ex) {
      System.out.println("File Could not be Read");
      goAhead = false;
    } 
    if (goAhead) {
      do {
        choice = LeaugeChoice(sc);
        if (choice == 1) {
          displayStats(Aleast);
        } else if (choice == 2) {
          displayStats(Alcentral);
        } else if (choice == 3) {
          displayStats(Alwest);
        } else if (choice == 4) {
          displayStats(Nleast);
        } else if (choice == 5) {
          displayStats(Nlcentral);
        } else if (choice == 6) {
          displayStats(Nlcentral);
        } else if (choice == 7) {
          displayStats2(All);
        } 
      } while (choice != 8);
    } 
  } 
} 

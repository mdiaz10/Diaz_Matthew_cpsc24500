import java.util.Scanner;

public class Flooring {

   public static void main(String[] args) {
      
       double houseArea = 0, length, width;
       int One_Board = 30 * 6;
       int number_of_boards = 0, number_of_packs = 0;
       double totalPackagesCost = 0.0;

       try (
	Scanner sc = new Scanner(System.in)) {
		System.out.print("Enter the length of the room (in ft):");
		   length = sc.nextDouble();

		   System.out.print("Enter the width of the room (in ft):");
		   width = sc.nextDouble();
	}
       houseArea = length * width*12;
       houseArea = (int) (houseArea + (houseArea * 0.20));
       number_of_boards = (int)Math.ceil((houseArea / One_Board));
       number_of_packs = number_of_boards / 6;

       totalPackagesCost = PackageCost(number_of_packs);
       System.out.println("You need" + number_of_packs+ " packs of laminate.");
       System.out.println("Total cost of packages is :$"+totalPackagesCost);

   }

   private static double PackageCost(int number_of_packs) {
       double One_Pack = 24.99;
       return number_of_packs * One_Pack;
   }

}
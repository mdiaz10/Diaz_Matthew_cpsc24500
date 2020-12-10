import java.util.ArrayList;
import java.util.Scanner;

/**
 * Prints the different options as well asks user what they would ike to do 
 *
 */
public class QuizApp {
	public static int showMenu(Scanner sc) {
		System.out.println("Here are your choices: ");
		System.out.println("1. Take a Quiz.");
		System.out.println("2. See Questions and answers");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Question> allQuestions = new ArrayList<Question>();
		QuestionPrinter questionPrinter;
		QuestionReader questionReader;
		ArrayList<Question> quizQuestions = new ArrayList<Question>();
		Quizzer quizzer = new Quizzer();
		
		
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int choice; //stores user entered menu choice
		int numQuestions;
		String fileName; //stores user filename
		String userAnswer;
		int counter;
		
		System.out.print("Enter name of file containing questions: ");
		fileName= sc.nextLine();
		questionReader= new QuestionReader();
		allQuestions=questionReader.readFromJSON(fileName);
		
		do {
			choice = showMenu(sc);
			if (choice == 1) {
				counter=0;
				System.out.println("How many questions would you like?:  ");
				numQuestions= sc.nextInt();
				quizQuestions= quizzer.randomQuestionArray(numQuestions, allQuestions);
				System.out.println("");

				quizzer.correctAnswers=0;
				do {
				
					System.out.println(quizQuestions.get(counter).getQuestion());
					System.out.print("a. ");
					System.out.println(quizQuestions.get(counter).getChoice1());
					System.out.print("b. ");
					System.out.println(quizQuestions.get(counter).getChoice2());
					System.out.print("c. ");
					System.out.println(quizQuestions.get(counter).getChoice3());
					System.out.print("d. ");
					System.out.println(quizQuestions.get(counter).getChoice4());
					System.out.print("Type the letter of your choice: ");
					userAnswer=scanner.nextLine();
					quizzer.checkAnswer(userAnswer, quizQuestions.get(counter).getAnswer());
					System.out.println("");
					counter++;
				}
				while(counter< quizQuestions.size());
	
				String report=String.format("You answered %s correct  out of %s questions asked\n",quizzer.correctAnswers,quizQuestions.size());
				System.out.println(report);
				
			} else if (choice == 2) {
				
				//questionReader= new QuestionReader();
				//allQuestions=questionReader.readFromJSON(fileName);
				questionPrinter=new QuestionPrinter();
				questionPrinter.printQuestions(allQuestions);

			} 
		}
		while (choice != 3);
		
	}
		

}

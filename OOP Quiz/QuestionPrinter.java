import java.util.ArrayList;

/**
 * Prints the questions 
 *
 */
public class QuestionPrinter {
	
	public static void printQuestions(ArrayList<Question> questions) {
		for (Question q : questions) {
			System.out.println(q);
		}
	}

}


//for(Question q: quizQuestions) {
//System.out.println(q.getQuestion());
//System.out.print("a. ");
//System.out.println(q.getChoice1());
//System.out.print("b. ");
//System.out.println(q.getChoice2());
//System.out.print("c. ");
//System.out.println(q.getChoice3());
//System.out.print("d. ");
//System.out.println(q.getChoice4());
//System.out.print("Type the letter of your choice: ");
//userAnswer= sc.nextLine();
//
//}
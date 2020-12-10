import java.util.ArrayList;
import java.util.Collections;

/**
 * Checks if the answers are correct 
 *
 */
public class Quizzer {
	
	int correctAnswers;
	public ArrayList<Question> randomQuestionArray (int numQuestions,ArrayList<Question> questions){
		ArrayList<Question> randQuestionArray= new ArrayList<Question>();
		Collections.shuffle(questions);
		for(int i=0; i<numQuestions;i++) {
			randQuestionArray.add(questions.get(i));
		}
		

		return randQuestionArray;
	}
	
	public void checkAnswer(String userInput,String answer ) {
		if (userInput.equals(answer)) {
			correctAnswers++;
		}
		else {
			return;
		}
		return;
	}
	
	
}

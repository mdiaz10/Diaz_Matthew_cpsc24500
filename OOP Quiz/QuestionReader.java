import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Reads the Json file
 *
 */
public class QuestionReader {
	public ArrayList<Question> readFromJSON(String fname) {
		try {
			ArrayList<Question> questions = new ArrayList<Question>();
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator();
			JSONObject questionObject;
			String question;
			String answer;
			String choice1, choice2, choice3, choice4;
			while (itr.hasNext()) {
				questionObject = (JSONObject)(itr.next());
				
				question = questionObject.get("question").toString();
				choice1 = questionObject.get("a").toString();
				choice2 = questionObject.get("b").toString();
				choice3 = questionObject.get("c").toString();
				choice4 = questionObject.get("d").toString();
				answer = questionObject.get("answer").toString();
				
				questions.add(new Question(question, choice1, choice2, choice3, choice4, answer));
			}
			return questions;
		} catch (Exception ex) {
			return null;
		}
	}

}

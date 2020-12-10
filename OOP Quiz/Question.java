
/**
 * Implements different question choices 
 *
 */
public class Question {
//	public class Article {
//		private String title;
//		private String author;
//		private String text;
//		public String getTitle() {
//			return title;
//		}
//		public void setTitle(String title) {
//			this.title = title;
//		}
//		public String getAuthor() {
//			return author;
//		}
//		public void setAuthor(String author) {
//			this.author = author;
//		}
//		public String getText() {
//			return text;
//		}
//		public void setText(String text) {
//			this.text = text;
//		}
//		public Article(String title, String author, String text) {
//			setTitle(title);
//			setAuthor(author);
//			setText(text);
//		}
//		@Override
//		public String toString() {
//			return String.format("%s\n%s\n%s",title,author,text);
//		}
//	}
	
	public Question(String question,String choice1,String choice2,String choice3,String choice4,String answer) {
		setQuestion(question);
		setChoice1(choice1);
		setChoice2(choice2);
		setChoice3(choice3);
		setChoice4(choice4);
		setAnswer(answer);
	}
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String answer;
	
	public void  setQuestion(String ques) {
		question=ques;
	}
	public String getQuestion() {
		return question;
	}
	
	public void  setAnswer(String ans) {
		answer=ans;
	}
	public String getAnswer() {
		return answer;
	}
	
	public void setChoice1(String ch) {
		choice1=ch;
	}
	public String getChoice1() {
		return choice1;
	}
	
	
	public void setChoice2(String ch) {
		choice2=ch;
	}
	public String getChoice2() {
		return choice2;
	}
	
	public void setChoice3(String ch) {
		choice3=ch;
	}
	public String getChoice3() {
		return choice3;
	}
	
	public void setChoice4(String ch) {
		choice4=ch;
	}
	public String getChoice4() {
		return choice4;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s\n",answer,question);
	}

}

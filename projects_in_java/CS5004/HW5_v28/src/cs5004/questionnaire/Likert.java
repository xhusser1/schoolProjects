package cs5004.questionnaire;

/**
 * This class represents a Likert object, and offers
 * all methods listed within the Question interface.
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructs a YesNo object passing in question prompt and boolean to see if required.
   * @param prompt the question prompt.
   * @param type the boolean of question. true being required and false being optional.
   * @throws IllegalArgumentException if user answer is null.
   */
  public Likert(String prompt, boolean type) {
    super(prompt,type);
  }

  @Override
  public void answer(String userAnswer) throws IllegalArgumentException {
    if (userAnswer == null) {
      throw new IllegalArgumentException("Answer is invalid");
    }
    if (userAnswer.equalsIgnoreCase("Strongly Agree")) {
      this.answer = userAnswer;
    } else if (userAnswer.equalsIgnoreCase("Agree")) {
      this.answer = userAnswer;
    } else if (userAnswer.equalsIgnoreCase("Neither Agree Nor Disagree")) {
      this.answer = userAnswer;
    } else if (userAnswer.equalsIgnoreCase("Strongly Disagree")) {
      this.answer = userAnswer;
    } else if (userAnswer.equalsIgnoreCase("Disagree")) {
      this.answer = userAnswer;
    }
  }

  @Override
  public Question copy() {
    Question copy = new Likert(this.prompt, this.type);
    if (this.answer.equals("")) {
      return copy;
    }
    copy.answer(this.answer);
    return copy;
  }
}

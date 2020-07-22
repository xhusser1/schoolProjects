package cs5004.questionnaire;

/**
 * This class represents a YesNo object, and offers
 * all methods listed within the Question interface.
 */
public class YesNo extends AbstractQuestion {

  /**
   * This constructs a YesNo object passing in question prompt and boolean to see if required.
   * @param prompt the question prompt.
   * @param type the boolean of question. true being required and false being optional.
   * @throws IllegalArgumentException if user answer is null.
   */
  public YesNo(String prompt, boolean type) {
    super(prompt, type);
  }

  @Override
  public void answer(String userAnswer) throws IllegalArgumentException {
    if (userAnswer == null) {
      throw new IllegalArgumentException("prompt cannot be null");
    } else if (userAnswer.equalsIgnoreCase("yes")) {
      this.answer = userAnswer;
    } else if (userAnswer.equalsIgnoreCase("no")) {
      this.answer = userAnswer;
    }
  }

  @Override
  public Question copy() {
    Question copy = new YesNo(this.prompt, this.type);
    if (this.answer.equals("")) {
      return copy;
    }
    copy.answer(this.answer);
    return copy;
  }
}

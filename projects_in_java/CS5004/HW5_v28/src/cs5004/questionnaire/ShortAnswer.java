package cs5004.questionnaire;

/**
 * This class represents a shortAnswer object, and offers
 *  all methods listed within the Question interface.
 */
public class ShortAnswer extends AbstractQuestion {

  /**
   * This constructs a ShortAnswer object passing in
   * question prompt and boolean to see if required.
   *
   * @param prompt the question prompt.
   * @param type   the boolean of question. true being required and false being optional.
   * @throws IllegalArgumentException if prompt is null or answer is too long.
   */
  public ShortAnswer(String prompt, boolean type) {
    super(prompt, type);
  }

  @Override
  public void answer(String userAnswer) throws IllegalArgumentException {
    if (userAnswer == null) {
      throw new IllegalArgumentException("prompt cannot be null");
    }
    if (userAnswer.length() > 280) {
      throw new IllegalArgumentException("Answer is too long");
    }
    this.answer = userAnswer;
  }

  @Override
  public Question copy() {
    Question copy = new ShortAnswer(this.prompt, this.type);
    copy.answer(this.answer);
    return copy;
  }
}

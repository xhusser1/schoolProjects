package cs5004.questionnaire;

/**
 * This class represents an abstract question object
 * that implements all of the methods from the question interface
 * and is extended within the YesNo, ShortAnswer, and Likert classes.
 */
public class AbstractQuestion implements Question {
  protected String prompt;
  protected boolean type;
  protected String answer;

  /**
   * Constructs an AbstractQuestion object passing in question prompt and
   * boolean to see if required.
   * @param prompt the question prompt.
   * @param type the boolean of question. true being required and false being optional.
   * @throws IllegalArgumentException if prompt is null or blank.
   */
  public AbstractQuestion(String prompt, boolean type) {
    this.prompt = prompt;
    this.type = type;
    this.answer = "";
    if (this.prompt == null || this.prompt.isBlank()) {
      throw new IllegalArgumentException("prompt cannot be empty");
    }
  }

  @Override
  public String getPrompt() {
    return this.prompt;
  }

  @Override
  public boolean isRequired() {
    return this.type;
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null) {
      throw new IllegalArgumentException("Invalid answer cannot be null");
    }

  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    return null;
  }

}

package cs5004.questionnaire;

/**
 * This class represents a wrapper object that has
 * the ability to get the identifier, type of questions,
 * whether a question is required or optional, and the answer of the question.
 */
public class Wrapper {
  private String identifier;
  private Question questions;

  /**
   * Constructs a public wrapper class.
   * @param identifier the string identifier.
   * @param questions the question type.
   * @throws IllegalArgumentException if identifier is null or blank.
   */
  public Wrapper(String identifier, Question questions) {
    this.identifier = identifier;
    this.questions = questions;
    if (this.identifier == null || this.identifier.isBlank()) {
      throw new IllegalArgumentException("Identifier must be provided");
    }
  }

  /**
   * Get the identifier of the question.
   * @return a string of the identifier.
   */
  public String getIdentifier() {
    return this.identifier;
  }

  /**
   * Get the question type of the question.
   * @return the question type of the questions.
   */
  public Question getQuestions() {
    return this.questions;
  }

  /**
   * Get the boolean type of whether question is optional or required.
   * @return the value of whether a question is required or not.
   */
  public boolean getBoolean() {
    return this.questions.isRequired();
  }

  /**
   * Get the answer of the question.
   * @return the string representation of the answer.
   */
  public String getAnswer() {
    return this.questions.getAnswer();
  }

}


package cs5004.questionnaire;

/**
 * This Question interface contains the method signature of the methods that
 * will be implemented by the abstract question class.
 */
public interface Question {

  /**
   * Get the question question.
   * @return the prompt that is being asked.
   */
  String getPrompt();

  /**
   * Get the status of a question.
   * @return if question is required or not.
   */
  boolean isRequired();

  /**
   * Get the answer of the question object.
   * @param answer the identifier of the question being answered.
   * @throws IllegalArgumentException if answer is null.
   */
  void answer(String answer);

  /**
   * Get the answer to the question being asked.
   * @return the answer of the question.
   */
  String getAnswer();

  /**
   * Get a copy of the question.
   * @return the copy of the question with the data.
   */
  Question copy();
}

package cs5004.questionnaire;

/**
 * This class represents an enum object
 * that has the characteristics of containing the response option with value and text.
 */
enum LikertResponseOption {
  STRONGLY_DISAGREE(-2, "Strongly Disagree"),
  DISAGREE(-1, "Disagree"),
  NEUTRAL(0, "Neither Agree Nor Disagree"),
  AGREE(1, "Agree"),
  STRONGLY_AGREE(2, "Strongly Agree");

  private final int val;
  private final String txt;

  /**
   * This constructs a likert response option with a value and text.
   * @param val the value of the response.
   * @param txt the string text response.
   */
  LikertResponseOption(int val, String txt) {
    this.val = val;
    this.txt = txt;
  }

  /**
   * Get the value of the response option.
   * @return the int value of the response.
   */
  int getValue() {
    return val;
  }

  /**
   * Get the text of the response option.
   * @return the string text of the response option.
   */
  String getText() {
    return txt;
  }
}

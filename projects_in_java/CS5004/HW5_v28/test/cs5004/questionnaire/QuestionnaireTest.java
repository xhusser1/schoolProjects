package cs5004.questionnaire;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
K * A junit test for the questionnaire class.
 */
public class QuestionnaireTest {

  @Test
  public void testAddQuestion() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    test.addQuestion("q1", yesNo1);
    yesNo1.answer("No");
    assertEquals(yesNo1,test.getQuestion(1));
  }

  @Test
  public void testAddQuestion2() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question shortAnswer = new ShortAnswer("What is the best place for pizza", true);
    test.addQuestion("q1", shortAnswer);
    shortAnswer.answer("New York City has the best spots for pizza");
    assertEquals(shortAnswer,test.getQuestion(1));
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", true);

    test.addQuestion(null, yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
  }

  @Test
  public void testRemoveQuestion() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", true);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    test.removeQuestion("q1");
    assertEquals("Question: Who's a great artists" + "\n\n"
            +  "Answer: " + "\n\n" + "Question: Pineapple on pizza" + "\n\n"
            +  "Answer: " , test.toString());
  }

  @Test
  public void testGetQuestionNum() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", true);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    assertEquals(shortAns1,test.getQuestion(2));
  }

  @Test
  public void testGetQuestionString() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", true);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    assertEquals(shortAns1,test.getQuestion("q2"));
  }

  @Test
  public void testRequiredQuestion() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", false);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    assertTrue(test.getRequiredQuestions().contains(yesNo1));
  }

  @Test
  public void testOptionalQuestion() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", false);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    assertTrue(test.getRequiredQuestions().contains(shortAns1));
  }

  @Test
  public void testIsOptional() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", false);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    assertTrue(test.getOptionalQuestions().contains(likert1));
  }

  @Test
  public void testGetResponse() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    yesNo1.answer("no");
    assertFalse(test.getResponses().contains(yesNo1));
  }

  @Test
  public void testFilter() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good?", true);
    Question shortAns1 = new ShortAnswer("Who is your favorite singer?", true);
    Question likert1 = new Likert("Pineapple on pizza", false);
    yesNo1.answer("no");
    shortAns1.answer("Alicia Keys is a great singer");
    likert1.answer("Agree");

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    Predicate<Question> q = Question::isRequired;
    assertEquals("Question: Is country music good?" + "\n\n"
            +  "Answer: no" + "\n\n" + "Question: Who is your favorite singer?" + "\n\n"
            +  "Answer: Alicia Keys is a great singer" , test.filter(q).toString());
  }

  @Test
  public void testIsCompleted() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo = new YesNo("Is Tupac the greatest rapper?", true);
    test.addQuestion("q1", yesNo);
    yesNo.answer("yes");
    assertTrue(test.isComplete());
  }

  @Test
  public void testSort() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Is country music good", true);
    Question shortAns1 = new ShortAnswer("Who's a great artists", true);
    Question likert1 = new Likert("Pineapple on pizza", false);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q2", shortAns1);
    test.addQuestion("q3", likert1);
    assertTrue(test.getRequiredQuestions().contains(yesNo1));
  }

  @Test
  public void testToString() {
    QuestionnaireImpl test = new QuestionnaireImpl();
    Question yesNo1 = new YesNo("Do you play the ukelele?", true);
    Question likert1 = new Likert("I love the ukelele.", false);

    test.addQuestion("q1", yesNo1);
    test.addQuestion("q3",  likert1);
    yesNo1.answer("yes");
    likert1.answer("Strongly agree");
    assertEquals("Question: Do you play the ukelele?" + "\n\n"
            +  "Answer: yes" + "\n\n" + "Question: I love the ukelele." + "\n\n"
            +  "Answer: Strongly agree" , test.toString());
  }
}
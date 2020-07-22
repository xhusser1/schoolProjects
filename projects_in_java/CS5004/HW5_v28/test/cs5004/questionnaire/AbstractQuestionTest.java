package cs5004.questionnaire;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * A junit test for abstract questions.
 */
public class AbstractQuestionTest {
  private YesNo yesNo1;
  private ShortAnswer short1;
  private Likert likert1;

  @Before
  public void setUp() {
    yesNo1 = new YesNo("Are you a dog?", true);
    short1 = new ShortAnswer("Are pugs the best dog breed?", true);
    likert1 = new Likert("Apartments in Boston are too expensive", true);

  }

  @Test
  public void testConstructor() {
    YesNo verifyYesNo1 = new YesNo("Are you a dog?", true);
    ShortAnswer verifyShortAns1 = new ShortAnswer("Are pugs the best dog breed?", true);
    Likert verifyLikert1 = new Likert("Apartments in Boston are too expensive", true);
    //verifyYesNo1.equals(yesNo1);
    assertEquals(verifyYesNo1.getPrompt(), yesNo1.getPrompt());
    assertEquals(verifyShortAns1.getPrompt(), short1.getPrompt());
    assertEquals(verifyLikert1.getPrompt(),likert1.getPrompt());

  }

  @Test (expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    YesNo blankConstructor = new YesNo("         ", true);
    ShortAnswer longConstructor = new ShortAnswer("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
            + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
            + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
            + "iiiiiiiiiiiiiiiiiiiiii", true);
    Likert blankLikert =  new Likert("     ", true);
    assertEquals("prompt cannot be empty", blankConstructor);
    assertEquals("Answer is too long", longConstructor);
    assertEquals("Asnwer cannot be blank", blankLikert);

  }

  @Test
  public void testGetPrompt() {
    assertEquals("Are you a dog?",yesNo1.getPrompt());
    assertEquals("Are pugs the best dog breed?", short1.getPrompt());
    assertEquals("Apartments in Boston are too expensive", likert1.getPrompt());

  }

  @Test
  public void testIsRequired() {
    assertTrue(yesNo1.isRequired());
    assertTrue(short1.isRequired());
    assertTrue(likert1.isRequired());
  }


  @Test
  public void testAnswer() {
    YesNo question1 = new YesNo("Is the sky purple", false);
    question1.answer("no");
    assertEquals("no", question1.getAnswer());

  }

  @Test
  public void testGetAnswer() {
    YesNo question2 = new YesNo("Is the sky blue", false);
    question2.answer("yes");
    assertEquals("yes", question2.getAnswer());

  }

  @Test
  public void testCopy() {
    Question result = new YesNo("Is it raining", true);
    result.answer("yes");
    assertEquals("Is it raining", result.copy().getPrompt());

  }
}

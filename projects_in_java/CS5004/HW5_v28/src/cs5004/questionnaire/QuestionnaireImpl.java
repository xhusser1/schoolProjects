package cs5004.questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * This class represents a questionnaire implementation object
 * that applies all methods from the questionnaire interface.
 */
public class QuestionnaireImpl implements Questionnaire {
  private LinkedList<Wrapper> questions;


  /**
   * This constructs a questionnaire linked list.
   * @throws NoSuchElementException if string identifier does not exist.
   */
  public QuestionnaireImpl() {
    this.questions = new LinkedList<>();
  }

  @Override
  public void addQuestion(String identifier, Question q) {
    Wrapper genericQuestion = new Wrapper(identifier, q);
    questions.add(genericQuestion);
  }

  @Override
  public void removeQuestion(String identifier) throws NoSuchElementException {
    if (identifier == null) {
      throw new NoSuchElementException("Element does not exist");
    }
    questions.removeIf(q -> q.getIdentifier().equals(identifier));
  }

  @Override
  public Question getQuestion(int num) {
    int size = num - 1;
    if (size > questions.size()) {
      throw new IndexOutOfBoundsException("Element does not exist");
    }
    List<Wrapper> newList = new ArrayList<>(questions);
    return newList.get(size).getQuestions();
  }

  @Override
  public Question getQuestion(String identifier) {
    if (identifier == null) {
      throw new IllegalArgumentException("identifier cannot be null");
    }
    for (Wrapper q : questions) {
      if (q.getIdentifier().equals(identifier)) {
        return q.getQuestions();
      }
    }
    throw new NoSuchElementException("Element does not exist");
  }

  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> requiredQuestion = new LinkedList();
    for (Wrapper q : questions) {
      if (q.getBoolean()) {
        requiredQuestion.add(q.getQuestions());
      }
    }
    return requiredQuestion;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    LinkedList requiredQuestions = new LinkedList();
    for (Wrapper q : questions) {
      if (!q.getBoolean()) {
        requiredQuestions.add(q.getQuestions());
      }
    }
    return requiredQuestions;
  }

  @Override
  public boolean isComplete() {
    for (int i = 0; i < questions.size(); i++) {
      if (!questions.get(i).getAnswer().equals("")) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<String> getResponses() {
    List<String> response = new LinkedList();
    for (Wrapper q : questions) {
      response.add(q.getQuestions().getAnswer());
    }
    return response;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    if (pq == null) {
      throw new IllegalArgumentException("pq can't be null");
    }
    Questionnaire newlist = new QuestionnaireImpl();
    for (Wrapper q : questions) {
      if (pq.test(q.getQuestions())) {
        newlist.addQuestion(q.getIdentifier(),q.getQuestions().copy());
      }
    }
    return newlist;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    questions.sort((Wrapper q1, Wrapper q2) -> comp.compare(q1.getQuestions(), q2.getQuestions()));
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    for (Wrapper q : this.questions) {
      seed = bf.apply(q.getQuestions(), seed);
    }
    return seed;
  }

  @Override
  public String toString() {
    String question = "";
    for (Wrapper q1 : questions) {
      if (q1 == questions.get(questions.size() - 1)) {
        question += "Question: " +  q1.getQuestions().getPrompt() + "\n\n"
                + "Answer: " + q1.getAnswer();
        return question;
      }
      question +=  "Question: " + q1.getQuestions().getPrompt() + "\n\n"
              + "Answer: " + q1.getAnswer() + "\n\n";
    }
    return question;
  }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * This is a test class for the Questions project.
 */
public class QuestionsTest {

  @Test
  public void testLikertQuestion() {
    Likert question = new Likert("Java is easy to learn.");
    assertEquals("Correct", question.answer("1"));
    assertEquals("Correct", question.answer("5"));
    assertEquals("Incorrect", question.answer("10"));
    assertEquals("Incorrect", question.answer("abc"));
  }

  @Test
  public void testTrueFalseQuestion() {
    TrueFalse question = new TrueFalse("Is Java a programming language?", "true");
    assertEquals("Correct", question.answer("True"));
    assertEquals("Incorrect", question.answer("False"));
    assertEquals("Incorrect", question.answer("Yes"));
  }

  @Test
  public void testMultipleChoiceQuestion() {
    MultipleChoice question = new MultipleChoice("Which is not a primitive data type in Java?", "3",
        "int", "char", "String", "boolean");
    assertEquals("Correct", question.answer("3"));
    assertEquals("Incorrect", question.answer("1"));
    assertEquals("Incorrect", question.answer("Five"));
  }

  @Test
  public void testMultipleSelectQuestion() {
    MultipleSelect question = new MultipleSelect("Which of these are colors of the rainbow?", "1 3",
        "Red", "Gray", "Blue");
    assertEquals("Correct", question.answer("1 3"));
    assertEquals("Incorrect", question.answer("1 2 3"));
    assertEquals("Incorrect", question.answer("2"));
  }

  @Test
  public void testQuestionSorting() {
    TrueFalse q1 = new TrueFalse("Is Java a programming language?", "true");
    MultipleChoice q2 = new MultipleChoice("Which one is an OOP principle?", "3", "Polymorphism",
        "Interpolation", "Encapsulation", "Inheritance");
    MultipleChoice q3 = new MultipleChoice("Which planet is third from the Sun?", "1", "Earth",
        "Mars", "Venus");
    MultipleSelect q4 = new MultipleSelect("Which of these are prime numbers?", "1 3", "2", "4",
        "3", "6");
    Likert q5 = new Likert("Java is fun.");

    Question[] questionnaire = { q5, q4, q2, q3, q1 };
    Arrays.sort(questionnaire);

    assertTrue(questionnaire[0] instanceof TrueFalse);
    assertTrue(questionnaire[1] instanceof MultipleChoice);
    assertTrue(questionnaire[2] instanceof MultipleChoice);
    assertTrue(questionnaire[3] instanceof MultipleSelect);
    assertTrue(questionnaire[4] instanceof Likert);
  }
}

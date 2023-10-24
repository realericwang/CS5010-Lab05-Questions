package questions;

import java.util.Arrays;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

    // Creating questions
    TrueFalse q1 = new TrueFalse("Is Java a programming language?", "true");
    MultipleChoice q2 = new MultipleChoice("Which one is an OOP principle?", "3", "Polymorphism",
        "Interpolation", "Encapsulation", "Inheritance");
    MultipleChoice q3 = new MultipleChoice("Which planet is third from the Sun?", "1", "Earth",
        "Mars", "Venus");
    MultipleSelect q4 = new MultipleSelect("Which of these are prime numbers?", "1 3", "2",
        "4", "3", "6");
    Likert q5 = new Likert("Java is fun.");

    // Placing in an array
    Question[] questionnaire = { q5, q4, q2, q3, q1 };

    // Sorting
    Arrays.sort(questionnaire);

    // Displaying
    for (Question q : questionnaire) {
      System.out.println(q.getText());
    }

    // Testing answer methods
    System.out.println(q1.answer("True"));  // Correct
    System.out.println(q2.answer("3"));     // Correct
    System.out.println(q3.answer("2"));     // Incorrect
    System.out.println(q4.answer("1 3"));   // Correct
    System.out.println(q5.answer("5"));     // Correct (since any valid likert option is correct)
  }
}

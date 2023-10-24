package questions;

/**
 * Represents a multiple-choice question.
 * <p>
 * This class extends the {@link AbstractQuestion} class and provides a specific implementation for
 * multiple-choice questions. Each multiple-choice question has a set of options and one correct
 * option among them.
 * </p>
 */
public class MultipleChoice extends AbstractQuestion {

  /** The correct option's number for the multiple-choice question. */
  private final int correctOption;

  /**
   * Constructs a new MultipleChoice question with the provided text, correct option, and other
   * options.
   *
   * @param text             the content of the question
   * @param correctOptionStr the correct option number as a String
   * @param options          the set of options for the multiple-choice question
   * @throws IllegalArgumentException if the number of options is not between 3 and 8, or if the
   *                                  correct option is out of range
   */
  public MultipleChoice(String text, String correctOptionStr, String... options) {
    super(text);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("Number of options should be between 3 and 8");
    }
    try {
      this.correctOption = Integer.parseInt(correctOptionStr);
      if (this.correctOption < 1 || this.correctOption > options.length) {
        throw new IllegalArgumentException("Correct option number is out of range");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Correct option should be an integer");
    }
  }

  /**
   * Evaluates the provided answer against the correct option and returns "Correct" or "Incorrect".
   *
   * @param answer the user's answer as a String
   * @return "Correct" if the provided answer matches the correct option, otherwise "Incorrect"
   */
  @Override
  public String answer(String answer) {
    int option;
    try {
      option = Integer.parseInt(answer);
    } catch (NumberFormatException e) {
      return INCORRECT;
    }
    return option == correctOption ? CORRECT : INCORRECT;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  protected int getClassOrder() {
    return 2;  // Represents priority for MultipleChoice questions
  }
}

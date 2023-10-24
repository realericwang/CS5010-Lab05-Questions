package questions;

/**
 * Represents a Likert-scale question.
 * <p>
 * A Likert-scale question allows for a response between 1 and 5, where each number corresponds to a
 * certain level of agreement or disagreement. This class extends the {@link AbstractQuestion} class
 * and provides a specific implementation for Likert-scale questions.
 * </p>
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructs a new Likert-scale question with the provided text.
   *
   * @param text the content of the Likert-scale question
   */
  public Likert(String text) {
    super(text);
  }

  @Override
  public String answer(String answer) {
    int option;
    try {
      option = Integer.parseInt(answer);
    } catch (NumberFormatException e) {
      return INCORRECT;
    }

    return (option >= 1 && option <= 5) ? CORRECT : INCORRECT;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  protected int getClassOrder() {
    return 4;  // Represents priority for Likert questions
  }
}

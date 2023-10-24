package questions;

/**
 * Represents a True/False type question.
 * <p>
 * A True/False question provides a statement and requires a boolean answer: either "true" or
 * "false". This class extends the {@link AbstractQuestion} class and provides a specific
 * implementation for True/False questions.
 * </p>
 */
public class TrueFalse extends AbstractQuestion {

  private final boolean correctAnswer;

  /**
   * Constructs a new True/False question with the provided text and answer.
   *
   * @param text             the content of the True/False question
   * @param correctAnswerStr the correct answer as a string ("true" or "false")
   * @throws IllegalArgumentException if the correctAnswerStr is not "true" or "false"
   */
  public TrueFalse(String text, String correctAnswerStr) {
    super(text);
    if (!"true".equalsIgnoreCase(correctAnswerStr) && !"false".equalsIgnoreCase(correctAnswerStr)) {
      throw new IllegalArgumentException("Correct answer should be 'true' or 'false'");
    }
    this.correctAnswer = Boolean.parseBoolean(correctAnswerStr);
  }

  @Override
  public String answer(String answer) {
    return ("True".equalsIgnoreCase(answer) && correctAnswer) || ("False".equalsIgnoreCase(answer)
        && !correctAnswer) ? CORRECT : INCORRECT;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  protected int getClassOrder() {
    return 1;  // Represents priority for TrueFalse questions
  }
}

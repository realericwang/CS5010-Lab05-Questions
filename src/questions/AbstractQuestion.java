package questions;

/**
 * This abstract class provides a skeletal implementation of the {@link Question} interface to
 * minimize the effort required to implement this interface.
 * <p>
 * It includes implementations for common functionalities among the types of questions and provides
 * an abstract method {@code getClassOrder()} for determining the order of question types.
 * </p>
 */
public abstract class AbstractQuestion implements Question {

  /** The text content of the question. */
  protected String text;

  /**
   * Constructs a new AbstractQuestion with the given text.
   *
   * @param text the content of the question
   */
  public AbstractQuestion(String text) {
    this.text = text;
  }

  /**
   * An abstract method to determine the order of the question types. Concrete subclasses should
   * provide an implementation for this method.
   *
   * @return an integer representing the order of the question type
   */
  protected abstract int getClassOrder();

  /**
   * Compares the current question object with another question for order. Questions are first
   * sorted by their type order, then lexicographically by their text.
   *
   * @param o the question to be compared
   * @return a negative integer, zero, or a positive integer as this question is less than, equal
   *     to, or greater than the specified question
   */
  @Override
  public int compareTo(Question o) {
    if (!(o instanceof AbstractQuestion)) {
      return 0;
    }
    AbstractQuestion other = (AbstractQuestion) o;
    if (this.getClassOrder() != other.getClassOrder()) {
      return this.getClassOrder() - other.getClassOrder();
    }
    return this.text.compareTo(other.getText());
  }
}

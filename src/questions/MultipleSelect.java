package questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a MultipleSelect type of question.
 * <p>
 * A MultipleSelect question provides a list of options and expects one or more correct answers.
 * Users can select multiple options as their answer. This class extends the
 * {@link AbstractQuestion} class and provides a specific implementation for MultipleSelect
 * questions.
 * </p>
 */
public class MultipleSelect extends AbstractQuestion {

  private final Set<Integer> correctOptions;

  /**
   * Constructs a new MultipleSelect question with the provided text and answers.
   *
   * @param text             the content of the MultipleSelect question
   * @param correctOptionStr a string representation of the correct options, separated by spaces
   * @param options          the list of answer options for the question
   * @throws IllegalArgumentException if the number of options is not between 3 and 8
   */
  public MultipleSelect(String text, String correctOptionStr, String... options) {
    super(text);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("Number of options should be between 3 and 8");
    }

    // Parse the correct options string into a Set of Integers
    this.correctOptions = Arrays.stream(correctOptionStr.split(" ")).map(Integer::parseInt)
        .collect(Collectors.toSet());
  }

  @Override
  public String answer(String answer) {
    String[] splits = answer.split(" ");
    Set<Integer> answeredOptions = new HashSet<>();
    for (String split : splits) {
      try {
        answeredOptions.add(Integer.parseInt(split));
      } catch (NumberFormatException e) {
        return INCORRECT;
      }
    }

    return correctOptions.equals(answeredOptions) ? CORRECT : INCORRECT;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  protected int getClassOrder() {
    return 3;  // Represents priority for MultipleSelect questions
  }
}

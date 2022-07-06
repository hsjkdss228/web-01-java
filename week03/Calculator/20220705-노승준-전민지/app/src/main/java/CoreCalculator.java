public class CoreCalculator {

  public final static String[] OPERATORS = new String[]{"+", "-", "*", "/", "="};

  private long currentNumber = 0;
  private String currentOperator = "";
  private long accumulator = 0;

  public long getCurrentNumber() {
    return currentNumber;
  }

  public long getAccumulator() {
    return accumulator;
  }

  public void addNumber(int number) {
    currentNumber *= 10;
    currentNumber += number;
  }

  public void updateOperator(String operator) {
    currentOperator = operator;
  }

  public void calculate() {
    switch (currentOperator) {
      case "" -> accumulator = currentNumber;
      case "+" -> accumulator += currentNumber;
      case "-" -> accumulator -= currentNumber;
      case "*" -> accumulator *= currentNumber;
      case "/" -> accumulator /= currentNumber;
    }
    currentNumber = 0;
  }
}

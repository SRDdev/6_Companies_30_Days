package Microsoft;
import java.util.Arrays;
import java.util.Stack;

public class RPNCalculator {

  public static double calculate(String expression) {
    //Creates a new object of the Stack class that stores elements of type Double. 
    Stack<Double> stack = new Stack<>();

    //Split the expression into tokens using the expression.split & \\s+ for all the input Strings
    String[] tokens = expression.split("\\s+");

    //Print the Expression using Arrays.toString
    System.out.println("Tokens: "+ Arrays.toString(tokens));
    
    //Create a for loop to check each and every element in the string and classify them.
    for (String token : tokens)
    {
      // If the token is a number , push it to the stack.
      // The \\d+ -> (0 to 9)
      // The \\. -> point 
      // The ? means to match zero or one occurrence of the preceding group.

      if(token.matches("\\d+(\\.\\d+)?"))
      {stack.push(Double.parseDouble(token));}

      // If the element is an Operand

      else
      {
        double operand2 = stack.pop();
        double operand1 = stack.pop();

        if(token.equals("+"))
        {stack.push(operand1 + operand2);}
        else if(token.equals("-"))
        {stack.push(operand1 - operand2);}
        else if(token.equals("*"))
        {stack.push(operand1*operand2);}
        else if(token.equals("/"))
        {stack.push(operand1/operand2);}
      }
    }
    return stack.pop();
  }
  public static void main(String[] args) {
    String expression = "2 1 + 3 *";
    System.out.println("The calculated value of the expresion is : "+calculate(expression));  
  }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Boolean;
import java.util.Scanner;
import jsjf.*;

public class ExpressionTreeEvaluator {

    /**
     * Creates an infix to postfix evaluator, and then uses the Postfix Evaluator to execute the program
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Boolean isCommentOrEmptyLine = false;

        System.out.print("Enter name of file you wish to perform binary tree functions on : ");
        Scanner fileToExecute = new Scanner(new File(scan.nextLine()));

        while (fileToExecute.hasNextLine()) {
            String infixExpression = fileToExecute.nextLine();

            isCommentOrEmptyLine = infixExpression.startsWith("#") || infixExpression.isEmpty();

            if (!isCommentOrEmptyLine) {
                InfixEvaluator infixEvaluator = new InfixEvaluator();
                String postfixExpression = infixEvaluator.toPostFix(infixExpression);

                System.out.println("Expression being evaluated: " + infixExpression);

                //Postfix Evaluator Output
                PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
                int result = postfixEvaluator.evaluate(postfixExpression);
                System.out.println();
                System.out.println(infixExpression + " equals: " + result);

                //Binary Tree output
                String binaryTree = postfixEvaluator.getTree();
                System.out.println("Expression Tree for " + infixExpression + " is: " + binaryTree);
            }
        }
    }
}

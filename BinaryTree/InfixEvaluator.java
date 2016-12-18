import jsjf.*;

/**
 * Takes an Infix Expression and outputs it as an Postfix
 *
 * @author joshuabrown + help from StackOverflow and Java Foundations
 */
public class InfixEvaluator {

    private static ArrayUnorderedList<String> expressionList;

    /**
     * These are to get rid of magic strings for easier readability
     */
    private static final String[] infixAndPostfixOperators = {"(", ")", "*", "/", "+", "-"};
    private static final String LEFTPARENTHESES = "(";
    private static final String RIGHTPARENTHESES = ")";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String MODULUS = "%";

    /**
     * Constructs an empty InfixEvaluator
     */
    public InfixEvaluator() {
        expressionList = new ArrayUnorderedList<String>();
    }

    /**
     * Split the line into operands and operators
     *
     * @param infixExpression line to parse
     * @return list of tokens in the correct order
     */
    private static String parseExpression(String infixExpression) {

        for (int index = 0; index < infixAndPostfixOperators.length; index++) {
            infixExpression = infixExpression.replace(infixAndPostfixOperators[index], " " +
                    infixAndPostfixOperators[index] + " ");
        }

        infixExpression = infixExpression.trim().replaceAll(" +", " ");

        return infixExpression;
    }


    /**
     * Returns the order of importance of the operator
     */
    private static int getOperatorImportance(String operator) {
        if (operator.equals(MULTIPLICATION) || operator.equals(MODULUS) || operator.equals(DIVISION)) {
            return 2;
        }

        return 1;
    }

    /**
     * Verifies if valid operator
     */
    private static boolean isOperator(String currentOperator) {
        for (String operator : infixAndPostfixOperators) {
            if (currentOperator.equals(operator)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Converts infix expression to postFix
     */
    public static String toPostFix(String lineToParse) {
        String infixExpressionToEvaluate = parseExpression(lineToParse);
        String postfixResult = "";
        String[] alphanumericAndSpecialCharactersArray = infixExpressionToEvaluate.split(" ");

        for (int index = 0; index < alphanumericAndSpecialCharactersArray.length; index++) {
            String alphanumericOrSpecialCharacter = alphanumericAndSpecialCharactersArray[index];

            if (!isOperator(alphanumericOrSpecialCharacter)) {
                postfixResult += alphanumericOrSpecialCharacter + " ";
            } else if (isOperator(alphanumericOrSpecialCharacter)) {
                if (expressionList.isEmpty()) {
                    expressionList.addToFront(alphanumericOrSpecialCharacter);
                } else if (alphanumericOrSpecialCharacter.contains(LEFTPARENTHESES) || alphanumericOrSpecialCharacter.contains(RIGHTPARENTHESES)) {

                    if (alphanumericOrSpecialCharacter.contains(LEFTPARENTHESES)) {
                        expressionList.addToFront(alphanumericOrSpecialCharacter);
                    } else if (alphanumericOrSpecialCharacter.contains(RIGHTPARENTHESES)) {
                        Boolean skip = false;
                        while (!expressionList.isEmpty() && !skip) {
                            String alphanumericOrSpecialChar = expressionList.remove(expressionList.first());

                            if (alphanumericOrSpecialChar.contains(LEFTPARENTHESES)) {
                                skip = true;
                            } else {
                                postfixResult += alphanumericOrSpecialChar + " ";
                            }
                        }
                    }
                } else {

                    //Defined these here, so it's clear they used in this specific section
                    Boolean breakOutOfWhileLoop = false;
                    Boolean breakOutOfWhileLoopTwo = false;
                    while (!expressionList.isEmpty() && !breakOutOfWhileLoop && !breakOutOfWhileLoopTwo) {
                        if (expressionList.first().contains(LEFTPARENTHESES)) {
                            expressionList.addToFront(alphanumericOrSpecialCharacter);
                            breakOutOfWhileLoopTwo = true;
                        }

                        // We will end up causing Empty Stack errors without this check
                        if (!breakOutOfWhileLoopTwo) {
                            if (getOperatorImportance(expressionList.first()) >= getOperatorImportance(alphanumericOrSpecialCharacter)) {
                                postfixResult += expressionList.remove(expressionList.first()) + " ";
                            } else {
                                expressionList.addToFront(alphanumericOrSpecialCharacter);
                                breakOutOfWhileLoop = true;
                            }
                        }
                    }
                }
            }
        }

        //build the postFix expression
        while (!expressionList.isEmpty()) {
            postfixResult += expressionList.remove(expressionList.first()) + " ";
        }

        //remove any whitespace
        return postfixResult.trim();
    }
}

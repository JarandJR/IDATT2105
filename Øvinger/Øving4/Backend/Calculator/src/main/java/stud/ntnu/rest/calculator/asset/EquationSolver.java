package stud.ntnu.rest.calculator.asset;

public class EquationSolver {

    public static double solveEquation(String e) {
        String[] tokens = multiplyAndDivide(e);
        if (tokens.length > 1 && tokens[1] != null)
            return addAndSubtract(tokens);
        return Double.parseDouble(tokens[0]);
    }

    private static String[] multiplyAndDivide(String e) {
        String[] tokens = e.split(" ");
        String[] temp = new String[tokens.length];
        int counter = 0;
        boolean calculated = false;

        for (int i = 0; i < tokens.length; i++) {

            if (isOperator(tokens[i]) && i > 0) {
                if (tokens[i].equals("*") || tokens[i].equals("/")){
                    double result = useOperator(tokens[i], Double.parseDouble(tokens[i - 1]), Double.parseDouble(tokens[i+1]));

                    if (calculated) {
                        if (tokens[i].equals("*"))
                            temp[counter - 1] = String.valueOf(Double.parseDouble(temp[counter - 1]) * Double.parseDouble(tokens[i+1]));
                        else
                            temp[counter - 1] = String.valueOf(Double.parseDouble(temp[counter - 1]) / Double.parseDouble(tokens[i+1]));
                    }
                    else {
                        calculated = true;
                        temp[counter - 1] = String.valueOf(result);
                    }
                    i++;
                } else {
                    temp[counter++] = tokens[i];
                }
            } else {
                temp[counter++] = tokens[i];
            }
        }
        return temp;
    }

    private static double addAndSubtract(String[] t) {
        double result = 0;
        for (int i = 0; i < t.length; i+=2) {

            if (t[i] == null)
                break;
            if (i == 0) {
                result += useOperator(t[i + 1], Double.parseDouble(t[i]), Double.parseDouble(t[i + 2]));
                i++;
            }
            else
                result = useOperator(t[i], result, Double.parseDouble(t[i + 1]));
        }
        return result;
    }

    private static boolean isOperator(String s) {
        String[] operators = {"+", "-", "*", "/"};
        for (String o : operators)
            if (o.equalsIgnoreCase(s))
                return true;
        return false;
    }

    private static double useOperator(String o, double n1, double n2) {
        return switch (o) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new IllegalArgumentException("Could not find operator: " + o);
        };
    }
}
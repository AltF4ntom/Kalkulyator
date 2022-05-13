import java.util.Scanner;

public class Kalkulyator {
    public static int result;
    public static boolean flag = false;
    public static void main(String[] args) throws ScannerException, ResultException, LengthException {
        Scanner x = new Scanner(System.in);
        String input = x.nextLine();
        String result = Kalkulyator.calc(input);
        System.out.println(result);

    }

    public static String calc(String input) throws ScannerException, ResultException, LengthException {
        String[] primer = input.split(" ");
        if (primer.length > 3 || primer.length == 2){
            throw new LengthException("the format of the mathematical operation does not match the task");
        }
        if (primer.length == 1){
            throw new LengthException("the string is not a mathematical operation");
        }
        String firstOperand = primer[0];
        String operator = primer[1];
        String secondOperand = primer[2];
        int firstOperandArab = 0;
        int secondOperandArab = 0;
        try {
            firstOperandArab = Integer.parseInt(firstOperand);
            secondOperandArab = Integer.parseInt(secondOperand);
        } catch (NumberFormatException exception) {
            flag = true;
            RimNum firstRimNum = RimNum.valueOf(firstOperand);
            firstOperandArab = firstRimNum.getTranslation();
            RimNum secondRimNum = RimNum.valueOf(secondOperand);
            secondOperandArab = secondRimNum.getTranslation();
        }
        if (firstOperandArab < 11 && firstOperandArab > 0 && secondOperandArab < 11 && secondOperandArab > 0) {
            switch (operator) {
                case "+":
                    result = firstOperandArab + secondOperandArab;
                    break;
                case "-":
                    result = firstOperandArab - secondOperandArab;
                    break;
                case "*":
                    result = firstOperandArab * secondOperandArab;
                    break;
                case "/":
                    result = firstOperandArab / secondOperandArab;
                    break;
            }
        } else {
            throw new ScannerException("numbers more or less than it is needed by the condition of the task");
        }
        if (flag){
            if (result < 1){
                throw new ResultException("there are no negative numbers in the Roman system");
            }
            return RimNum.values()[result] + "";
        }
        else{
            return result + "";
        }
    }
}

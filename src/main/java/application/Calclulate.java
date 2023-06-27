package application;

public class Calclulate {

    public float calculateOneNumber(float number1, String operator){
        switch(operator){
            case "√":
                return (float) Math.sqrt(number1);
            case "1/x":
                return (float) 1 / number1;
            default:
                break;
        }
        return 0;
        }
    public float calculateTwoNumber(float number1,float number2,String operator){
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if(number2==0)
                    return 0;
                return number1 / number2;
            case "Mod":
                return number1 % number2;
            case "^":
                if(number2 == 0) {
                    return (float)1;
                }
                return (float) Math.pow(number1, number2);
            case "(%)":
                return (number1 / 100)*number2;
            default:
                break;
        }
        return 0;
    }
}

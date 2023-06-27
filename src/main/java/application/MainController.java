package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.util.Objects;

public class MainController {


    @FXML
    private Button kj;
    @FXML
    private Button kj151;
    @FXML
    private Button C;
    @FXML
    private Button kj1;

    @FXML
    private Button kj10;

    @FXML
    private Button kj11;

    @FXML
    private Button kj12;

    @FXML
    private Button kj13;

    @FXML
    private Button kj14;

    @FXML
    private Button kj15;

    @FXML
    private Button kj16;

    @FXML
    private Button kj17;

    @FXML
    private Button kj18;

    @FXML
    private Button kj19;

    @FXML
    private Button kj22;

    @FXML
    private Button kj2;

    @FXML
    private Button kj20;

    @FXML
    private Button kj21;

    @FXML
    private Button kj3;

    @FXML
    private Button kj4;

    @FXML
    private Button kj5;

    @FXML
    private Button kj6;

    @FXML
    private Button kj7;

    @FXML
    private Button kj8;

    @FXML
    private Button kj9;
    @FXML
    private Label result;
    @FXML
    public static Label result1;
    private float number1 = 0;

    private float number2 = 0;

    private String operator = "";


    private boolean start = true;
    private Calclulate calculate = new Calclulate();
    private int counter;

    @FXML
    public void onOpsButtonClick(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/application/scView.fxml"));
        kj151.getScene().setRoot(newRoot);
    }

    @FXML
    public void processNumber(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        for (int i = 0; i < result.getText().length(); ++i) {
            if (result.getText().charAt(i) == '.' && value.equals(".")) {
                value = "";
            }
        }
        result.setText(result.getText() + value);
    }

    @FXML
    public void TwoOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Float.parseFloat(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;

            number2 = Float.parseFloat(result.getText());
            float output = calculate.calculateTwoNumber(number1, number2, operator);
            result.setText(String.valueOf(output));
            if (output == 0 && (operator.equals("/")) || operator.equals("Mod")) {
                result.setText("Деление на 0");
            }
            try (FileWriter history = new FileWriter("History.txt", true)) {
                history.write(Float.toString(number1));
                history.write(' ');
                history.write(operator);
                history.write(' ');
                history.write(Float.toString(number2));
                history.write(' ');
                history.write('=');
                history.write(' ');
                history.write(Float.toString(output));
                history.write('\n');
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
            operator = "";
        }
    }

    public void OneOperator(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();
        if (!operator.isEmpty())
            return;

        operator = value;
        number1 = Float.parseFloat(result.getText());
        result.setText("");
        if (Objects.equals(operator, "√") && number1 < 0) {
            result.setText("Корень из отрицательного числа");
            return;
        }
        if (Objects.equals(operator, "1/x") && number1 == 0){
            result.setText("Деление на 0");
            return;
        }

        float output = calculate.calculateOneNumber(number1, operator);
        result.setText(String.valueOf(output));



        try (FileWriter history = new FileWriter("History.txt")) {
            history.write(operator);
            history.write(' ');
            history.write(Float.toString(number1));
            history.write(' ');
            history.write('=');
            history.write(Float.toString(output));
            history.write('\n');
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        operator = "";
    }

    public void ClearFunction(ActionEvent event) {
        operator = "";
        start = true;
        result.setText("");
        Enabler();
    }

    public void ClearFunctionCM(ActionEvent event) {
        operator = "";
        number1 = Float.parseFloat(result.getText());
        start = true;
        int counter = 0;
        for (int i = 0; i < Float.toString(number1).length(); i++) {
            if (Float.toString(number1).charAt(i) == '.' && Float.toString(number1).charAt(i + 1) == '0') {
                counter = 3;
            }
            if (Float.toString(number1).charAt(i) == '.' && Float.toString(number1).charAt(i + 1) != '0') {
                counter = 1;
            }
        }
        char[] number = new char[Float.toString(number1).length() - counter];
        for (int i = 0; i < Float.toString(number1).length() - counter; ++i) {
            number[i] = Float.toString(number1).charAt(i);
        }
        String newNumber = new String(number);
        result.setText(newNumber);
    }


    public void Disabler() {
        kj.setDisable(true);
        kj1.setDisable(true);
        kj2.setDisable(true);
        kj3.setDisable(true);
        kj4.setDisable(true);
        kj5.setDisable(true);
        kj6.setDisable(true);
        kj7.setDisable(true);
        kj8.setDisable(true);
        kj9.setDisable(true);
        kj10.setDisable(true);
        kj11.setDisable(true);
        kj12.setDisable(true);
        kj13.setDisable(true);
        kj14.setDisable(true);
        kj15.setDisable(true);
        kj16.setDisable(true);
        kj17.setDisable(true);
        kj18.setDisable(true);
        kj19.setDisable(true);
        kj20.setDisable(true);
        kj21.setDisable(true);
    }

    public void Enabler() {
        kj.setDisable(false);
        kj1.setDisable(false);
        kj2.setDisable(false);
        kj3.setDisable(false);
        kj4.setDisable(false);
        kj5.setDisable(false);
        kj6.setDisable(false);
        kj7.setDisable(false);
        kj8.setDisable(false);
        kj9.setDisable(false);
        kj10.setDisable(false);
        kj11.setDisable(false);
        kj12.setDisable(false);
        kj13.setDisable(false);
        kj14.setDisable(false);
        kj15.setDisable(false);
        kj16.setDisable(false);
        kj17.setDisable(false);
        kj18.setDisable(false);
        kj19.setDisable(false);
        kj20.setDisable(false);
        kj21.setDisable(false);
    }

}


package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ScViewController {

    public TextField textMels;
    public TextField textSols;
    public TextField textPrims;
    public Button btnPlus;
    public Button btnMin;
    public Button btnExit;
    public Button btnEval;
    public Label textLits;

    @FXML
    public void onBtnExitClick(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
        btnExit.getScene().setRoot(newRoot);
    }

    private Double mels;
    private Double sols;
    private Double prims;

    private void saveNums(){

        mels = textMels.getText().isEmpty() ? 0 : Double.parseDouble(textMels.getText());
        sols = textSols.getText().isEmpty() ? 0 : Double.parseDouble(textSols.getText());
        prims = textPrims.getText().isEmpty() ? 0 : Double.parseDouble(textPrims.getText());
    }

    private int isPlus = 0;

    public void onBtnPlusClick(ActionEvent actionEvent) {
        saveNums();
        isPlus = 1;

        textMels.setText("");
        textSols.setText("");
        textPrims.setText("");
    }

    public void onBtnMinClick(ActionEvent actionEvent) {
        saveNums();
        isPlus = -1;

        textMels.setText("");
        textSols.setText("");
        textPrims.setText("");
    }
/*
1 Примат (Primat) = 36 бутылкам = 27 литрам
1 Соломон = 25 литрам
1 Мельхиор (Melchior)= 24 бутылкам = 18 литрам
*/
    public void onBtnEvalClick(ActionEvent actionEvent) {
        if (isPlus == 1){
            mels = mels + (textMels.getText().isEmpty() ? 0 : Double.parseDouble(textMels.getText()));
            sols = sols + (textSols.getText().isEmpty() ? 0 : Double.parseDouble(textSols.getText()));
            prims = prims + (textPrims.getText().isEmpty() ? 0 : Double.parseDouble(textPrims.getText()));
        } else if (isPlus == -1){
            mels = mels - (textMels.getText().isEmpty() ? 0 : Double.parseDouble(textMels.getText()));
            sols = sols - (textSols.getText().isEmpty() ? 0 : Double.parseDouble(textSols.getText()));
            prims = prims - (textPrims.getText().isEmpty() ? 0 : Double.parseDouble(textPrims.getText()));
        } else
            saveNums();
        Double lits = mels * 18 + sols * 25 + prims * 27;


        textMels.setText(String.valueOf(mels));
        textSols.setText(String.valueOf(sols));
        textPrims.setText(String.valueOf(prims));
        textLits.setText(lits + " л");
    }
}

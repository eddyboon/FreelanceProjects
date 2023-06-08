package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import backend.javafx.Controller;
import model.TipModel;

public class TipController extends Controller<TipModel> {

    private String tipText = "Tip: $";
    private String totalBillString = ", TotalBill: $";

    @FXML
    private TextField billAmountField;

    @FXML
    private Text billInformation;

    @FXML
    private void fifteenTip() throws Exception {
        if (billAmountField.getText().equals("")) {
            model.setBillAmount(0.0);
        } else {
            model.setBillAmount(Double.parseDouble(billAmountField.getText()));
        }
        model.setTipAmount(0.15 * model.getBillAmount());
        model.setTotalAmount(model.getBillAmount() + model.getTipAmount());
        billInformation.setText(
                tipText + String.format("%.2f", model.getTipAmount()) + totalBillString
                        + String.format("%.2f", model.getTotalAmount()));
    }

    @FXML
    private void eightTeenTip() throws Exception {
        if (billAmountField.getText().equals("")) {
            model.setBillAmount(0.0);
        } else {
            model.setBillAmount(Double.parseDouble(billAmountField.getText()));
        }
        model.setTipAmount(0.18 * model.getBillAmount());
        model.setTotalAmount(model.getBillAmount() + model.getTipAmount());
        billInformation.setText(
                tipText + String.format("%.2f", model.getTipAmount()) + totalBillString
                        + String.format("%.2f", model.getTotalAmount()));
    }

    @FXML
    private void twentyTip() throws Exception {
        if (billAmountField.getText().equals("")) {
            model.setBillAmount(0.0);
        } else {
            model.setBillAmount(Double.parseDouble(billAmountField.getText()));
        }
        model.setTipAmount(0.2 * model.getBillAmount());
        model.setTotalAmount(model.getBillAmount() + model.getTipAmount());
        billInformation.setText(
                tipText + String.format("%.2f", model.getTipAmount()) + totalBillString
                        + String.format("%.2f", model.getTotalAmount()));
    }

}

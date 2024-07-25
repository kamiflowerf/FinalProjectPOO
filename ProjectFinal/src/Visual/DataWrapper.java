package Visual;

import javax.swing.ImageIcon;

public class DataWrapper {
    private ImageIcon icon;
    private String textField;
    private int spinnerValue;
    private boolean radioButtonSelected;

    public DataWrapper(ImageIcon icon, String textField, int spinnerValue, boolean radioButtonSelected) {
        this.icon = icon;
        this.textField = textField;
        this.spinnerValue = spinnerValue;
        this.radioButtonSelected = radioButtonSelected;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public int getSpinnerValue() {
        return spinnerValue;
    }

    public void setSpinnerValue(int spinnerValue) {
        this.spinnerValue = spinnerValue;
    }

    public boolean isRadioButtonSelected() {
        return radioButtonSelected;
    }

    public void setRadioButtonSelected(boolean radioButtonSelected) {
        this.radioButtonSelected = radioButtonSelected;
    }
}



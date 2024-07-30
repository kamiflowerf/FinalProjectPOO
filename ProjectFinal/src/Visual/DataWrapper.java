package Visual;

import javax.swing.ImageIcon;

import logic.Administration;
import logic.Component;

public class DataWrapper {
    private ImageIcon icon;
    private String txtID;
    private String txtName;
    private int spinnerValue;
    private boolean radioButtonSelected;
    

    public DataWrapper(ImageIcon icon, String id, String name, int spinnerValue, boolean radioButtonSelected) {
        this.icon = icon;
        this.txtID = id;
        this.txtName = name;
        this.spinnerValue = spinnerValue;
        this.radioButtonSelected = radioButtonSelected;
    }

    public void updateData() {
    	Component comp = Administration.getInstance().searchComponentById(this.getTextField());
    	comp.setUnits(this.spinnerValue);
    	Administration.getInstance().updateComponent(comp);
    }
    
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getTextField() {
        return txtID;
    }

    public void setTextField(String textField) {
        this.txtID = textField;
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

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}
}



package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BodyMassIndexController 
{
	private String awake = "null";
	
    @FXML
    private Label height;

    @FXML
    private Label weight;
    
    @FXML 
    private void wake(ActionEvent event)
    {
		String value = ((Button)event.getSource()).getText();
		if(value.equals("Weight (kg)"))
		{
			weight.setText("0");
			awake = "weight";
		}
		else if(value.equals("Height (cm)"))
		{
			weight.setText("0");
			awake = "height";
		}
    }
    
    @FXML 
    private void processNumber(ActionEvent event)
    {
    	return;
    }
    
    @FXML
    private void clear()
    {
    	return;
    }
   
}

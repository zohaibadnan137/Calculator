package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CalculatorController 
{
	private int number1;
	private String operator = "";
	private Boolean start = true;
	
	@FXML
	private Label output;	

	@FXML
	private void processNumber(ActionEvent event) 
	{
		if(start == true)
		{
			output.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		output.setText(output.getText() + value);
	}
	
	@FXML
	private void processOperator(ActionEvent event) 
	{
		if(output.getText().equals("Error"))
			return;
		String value = ((Button)event.getSource()).getText();
		if(!value.equals("="))
		{
			if(!operator.isEmpty())
				return;
			else
			{
				operator = value;
				number1 = Integer.parseInt(output.getText());
				output.setText("");
			}
		}	
		else
		{
			if(operator.isEmpty())
				return;
			if(output.getText().isEmpty())
			{
				output.setText("Error");
				operator = "";
				start = true;
				return;
			}
			output.setText(calculate(number1, Integer.parseInt(output.getText()), operator));
			operator = "";
			start = true;
		}
	}
	
	@FXML
	private void clear(ActionEvent event)
	{
		output.setText("0");
		operator = "";
		start = true;
	}
	
	@FXML 
	private void bmi(ActionEvent event)
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("BodyMassIndex.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Body Mass Index");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String calculate(int number1, int number2, String operator) 
	{
		switch(operator) 
		{
		case "÷":
			if(number2 == 0)
				return "Error";
			else
				return String.valueOf(number1 / number2);
		case "×":
			return String.valueOf(number1 * number2);
		case "-":
			return String.valueOf(number1 - number2);
		case "+":
			return String.valueOf(number1 + number2);
		}
		return "Error";
	}
}

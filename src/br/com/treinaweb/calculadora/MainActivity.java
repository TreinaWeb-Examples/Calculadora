package br.com.treinaweb.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText display;
	int valor1, valor2;
	String operador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		display = (EditText) findViewById(R.id.display);
	}
	
	public void numeros(View v){
		Editable str = display.getEditableText();
		Button b = (Button)v;
		if(valor2 != 0){
			valor2 = 0;
			display.setText("");
		}
		str.append(b.getText().toString());
	}
	
	public void cancelar(View v){
		valor1 = 0;
		valor2 = 0;
		display.setText("");
		display.setHint("Digite um número");
	}
	
	public void operadores(View v){
		try{
			Button b = (Button)v;
			operador = b.getText().toString();
			if(valor1 == 0){
				valor1 = Integer.parseInt(display.getText().toString());
				display.setText("");
			}else if(valor2 != 0){
				valor2 = 0;
				display.setText("");
			}else{
				valor2 = Integer.parseInt(display.getText().toString());
				display.setText(Integer.toString(calcular()));
			}
		}catch(Exception e){
			
		}
	}
	
	private int calcular(){
		if(operador.equals("+")){
			valor1 = valor1 + valor2;
		} else if (operador.equals("-")){
			valor1 = valor1 - valor2;
		} else if (operador.equals("*")){
			valor1 = valor1 * valor2;
		} else if (operador.equals("/")){
			valor1 = valor1 / valor2;
		}
		
		return valor1;
	}
	
	public void resultado(View v){
		try{
			if(!operador.equals(null)){
				if(valor2 != 0){
					display.setText(Integer.toString(valor1));
				} else {
					valor2 = Integer.parseInt(display.getText().toString());
					display.setText(Integer.toString(calcular()));
				}
			}
		}catch(Exception e){
			
		}
	}
}

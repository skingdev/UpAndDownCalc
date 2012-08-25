package com.example.upanddowncalc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;
import android.view.View;
 
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;
 
public class tableLayoutPlayer extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
 
    //initialize a button and a counter
    Button button_add_playerButton;
    int counter = 0;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        // setup the layout
        setContentView(R.layout.activity_main);
 
        // add a click-listener on the button
        //addListenerOnButton();
        
        
        this.button_add_playerButton = (Button) findViewById(R.id.button_add_player);
        //this.button_add_playerButton.setOnClickListener(this);        
 
        //event listener for the button
        OnClickListener listener = new OnClickListener() {
        	@Override
        	public void onClick(View view) {
        		Button b = (Button)view;
        		b.setText("Yo");
        		
        	}
        };
        button_add_playerButton.setOnClickListener(listener);
    }

	@Override
	public void onClick(View v) {
		Button b = (Button)v;
		b.setText("Sup");
		
	}
 
//    public void addListenerOnButton() {
//    	this.button_add_playerButton = (Button) findViewById(R.id.button_add_player);
//    	this.button_add_playerButton.setOnClickListener(new OnClickListener() {
//    		@Override
//    		public void onClick (View view) {
//    			Context context = getApplicationContext();
//    			CharSequence text = "Hello toast!";
//    			int duration = Toast.LENGTH_SHORT;
//
//    			Toast toast = Toast.makeText(context, text, duration);
//    			toast.show();
//    		}
//    	});
//    }
//
//	@Override
//	public void onClick(View v) {
//		Context context = getApplicationContext();
//		CharSequence text = "Hello toast 2!";
//		int duration = Toast.LENGTH_SHORT;
//
//		Toast toast = Toast.makeText(context, text, duration);
//		toast.show();
//		
//	}
    
    // run when the button is clicked
//    @Override
//    public void onClick(View view) {
//    	Toast.makeText(this, "You clicked the button", Toast.LENGTH_SHORT).show();
//
//        // get a reference for the TableLayout
//        TableLayout table = (TableLayout) findViewById(R.id.tableLayoutPlayer);
// 
//        // create a new TableRow
//        TableRow row = new TableRow(this);
// 
//        // count the counter up by one
//        counter++;
// 
//        // create a new TextView
//        TextView t = new TextView(this);
//        // set the text to "text xx"
//        t.setText("text " + counter);
// 
//        // create a CheckBox
//        CheckBox c = new CheckBox(this);
// 
//        // add the TextView and the CheckBox to the new TableRow
//        row.addView(t);
//        row.addView(c);
// 
//        // add the TableRow to the TableLayout
//        table.addView(row,new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
// 
//    }
}
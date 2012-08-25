package com.example.upanddowncalc;

import android.R.drawable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button button = (Button) findViewById(R.id.button_add_player);
        button.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		final Context appContext = getApplicationContext();

        		TableLayout playerTable = (TableLayout)findViewById(R.id.tableLayoutPlayer);
        		TableRow row = new TableRow(appContext);
        		
        		EditText playerName = new EditText(appContext);
        		playerName.setId(findId());
        		playerName.setWidth(150);
        		playerName.setInputType(96);
        		playerName.setTextColor(Color.BLACK);
        		playerName.requestFocus();
        		
        		Spinner bid = new Spinner(appContext);
        		bid.setId(findId());
        		bid.setClickable(true);
        		//bid.setVisibility(4);
        		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
        	            appContext, R.array.bid, android.R.layout.simple_spinner_item);
        	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        	    bid.setAdapter(adapter);
        	    
        	    final TextView playerScore = new TextView(appContext);
        	    
        	    Button playerMadeBid = new Button(appContext);
        	    playerMadeBid.setId(findId());
        	    playerMadeBid.setMinimumWidth(75);
        	    playerMadeBid.setWidth(75);
        	    playerMadeBid.setText("Y");
        	    playerMadeBid.setOnClickListener(new View.OnClickListener() { 
        	    	public void onClick(View v) {
        	    	TextView thisScore = (TextView)((TableRow)v.getParent()).getChildAt(4);
        	    	Spinner thisBid = (Spinner)((TableRow)v.getParent()).getChildAt(1);
        	    	int currentBid = Integer.parseInt(thisBid.getSelectedItem().toString());
        	    	int currentScore = Integer.parseInt(thisScore.getText().toString());
        	    	int newScore = currentScore + 10 + currentBid;
        	    	
        	    	thisScore.setText(Integer.toString(newScore));
        	    	
        	    	if (newScore == 0) {
						thisScore.setTextColor(Color.BLACK);
					}
        	    	else if (newScore < 0) {
						thisScore.setTextColor(Color.RED);
					}
        	    	else if (newScore > 0) {
						thisScore.setTextColor(Color.GREEN);
					}
        	    	
//            		Toast toast = Toast.makeText(appContext, "Made bid", Toast.LENGTH_SHORT);
//        			toast.show();
        	    	}
        	    });
        	    
        	    Button playerMissedBid = new Button(appContext);
        	    playerMissedBid.setId(findId());
        	    playerMissedBid.setMinimumWidth(75);
        	    playerMissedBid.setWidth(75);
        	    playerMissedBid.setText("N");
        	    playerMissedBid.setOnClickListener(new View.OnClickListener() { 
        	    	public void onClick(View v) {
        	    	TextView thisScore = (TextView)((TableRow)v.getParent()).getChildAt(4);
        	    	Spinner thisBid = (Spinner)((TableRow)v.getParent()).getChildAt(1);
        	    	int currentBid = Integer.parseInt(thisBid.getSelectedItem().toString());
        	    	int currentScore = Integer.parseInt(thisScore.getText().toString());
        	    	int newScore = currentScore - 10 - currentBid;
        	    	
        	    	thisScore.setText(Integer.toString(newScore));
        	    	
        	    	if (newScore == 0) {
						thisScore.setTextColor(Color.BLACK);
					}
        	    	else if (newScore < 0) {
						thisScore.setTextColor(Color.RED);
					}
        	    	else if (newScore > 0) {
						thisScore.setTextColor(Color.GREEN);
					}
        	    	
        	    	}
        	    });
        	    
        	    
        	    playerScore.setId(findId());
        	    playerScore.setGravity(5);
        	    playerScore.setWidth(100);
        	    playerScore.setTextSize(30);
        	    playerScore.setText("0");
        	    playerScore.setTag(playerScore);
        	    
        		row.addView(playerName);
        		row.addView(bid);
        		row.addView(playerMadeBid);
        		row.addView(playerMissedBid);
        		row.addView(playerScore);
        		
        		playerTable.addView(row, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        		
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { 	
    	//check selected menu item
    	if(item.getItemId() == R.id.menu_new_game){
    		Spinner sp = (Spinner)findViewById(R.id.number_of_cards);
    		sp.setVisibility(0);
    		TextView labelNumberOfCards = (TextView)findViewById(R.id.label_number_of_cards);
    		labelNumberOfCards.setVisibility(0);
//    		TableRow firstTableRow = (TableRow)findViewById(R.id.tableRow1);
//    		firstTableRow.setVisibility(0);
    		Button buttonDeal = (Button)findViewById(R.id.button_deal);
    		buttonDeal.setVisibility(0);
    		Button buttonAddPlayer = (Button)findViewById(R.id.button_add_player);
    		buttonAddPlayer.setVisibility(0);
    		return true;
    	}
    	return false;
    }
    
    static int createId = 1;

	// Returns a valid id that isn't in use
	public int findId(){  
	    View v = findViewById(createId);  
	    while (v != null){  
	        v = findViewById(++createId);  
	    }  
	    return createId++;  
	}
 
}

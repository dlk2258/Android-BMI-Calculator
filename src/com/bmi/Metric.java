package com.bmi;




import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Metric extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private Button cal, cancel;
	private EditText wpe,hie,hfe,bmie;
	private String wps,his,hfs,bmis;
	private float bmi,hii;
	private int hf,hi,wp;

	
	static final int DIALOG_CANCEL_ID = 0;
	static final int DIALOG_ACCEPT_ID = 1;
	

	
    //@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
 
        
        cal = (Button)findViewById(R.id.calculate);
        cal.setOnClickListener(this);
       
        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

        
        wpe = (EditText)findViewById(R.id.wp);
       
        hfe = (EditText)findViewById(R.id.hf);
 
    }
    private void showMessage(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
      
   
    protected Dialog onCreateDialog(int id) {
    	
    	AlertDialog dialog = null;

    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);

    	
    	switch(id) {

    	
    	case DIALOG_CANCEL_ID:
    		
    		this.finish();
    		break;

    	
    	case DIALOG_ACCEPT_ID:
    		
           
    		
    		builder.setMessage("Your BMI : '"+bmis+"'")
    			   .setCancelable(false) 
    			   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
    				   public void onClick(DialogInterface dialog, int id) {
    					   dialog.dismiss();
    				   }
    			   });
    		
    		dialog = builder.create();
    		break;
  
    	
    	default: dialog = null;
    	}

    	return dialog;
    }

   
    protected void onPrepareDialog(int id, Dialog dialog) {
    	if(id == DIALOG_ACCEPT_ID) {
    		((AlertDialog) dialog).setMessage(bmis);
    	}
    }
    
	public void onClick(View v) {
	
    	switch(v.getId()) {
    			case R.id.calculate:
    				try{
    					wp = Integer.parseInt("0"+wpe.getText().toString());
    			        hf = Integer.parseInt("0"+hfe.getText().toString());
    					}
    				catch(Exception e)
    				{
    					showMessage("Invalid Input");
    					return;
    				}
    			    
    					if(wp==0 || hf==0)
    					{	showMessage("Invalid Values");
    						return;
    					}
    					
    			        hii=hf/100.0f;
    			        bmi=((float)wp/(hii*hii));    
    			        bmis="Your BMI is : "+(Float.toString(bmi));
    			     

    				showDialog(DIALOG_ACCEPT_ID); break;
    			case R.id.cancel: showDialog(DIALOG_CANCEL_ID); break;
    		}
    
		
	}

	
   
}
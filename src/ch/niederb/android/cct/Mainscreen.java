package ch.niederb.android.cct;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Mainscreen extends Activity implements OnClickListener, OnInitListener {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup vg = (ViewGroup) li.inflate(R.layout.main, null);
        
        recursiveSetOnClickListener(vg, this);
        setContentView(vg);
    }
    
    private void recursiveSetOnClickListener(ViewGroup vg, OnClickListener listener) {
        for (int i = 0; i < vg.getChildCount(); i++) {
        	View v = vg.getChildAt(i);
        	if (v instanceof ViewGroup) {
        		recursiveSetOnClickListener((ViewGroup) v, listener);
        	} else if (v.isClickable()) {
        		v.setOnClickListener(this);
        	}
        }
	}

	public void onClick(View v) {
    	String tag = (String) v.getTag();
    	Action a = ActionContainer.getInstance().getAction(tag);
    	if (tag != null) {
    		int textId = getResources().getIdentifier(tag, "string", "ch.niederb.android.cct");
    		Speaker.getInstance().speak(getResources().getString(textId));
    		//Speak.speak(, 0, null);
    	}
    }
    
    public void onInit(int status) {
    	// nothing to do
    }
}
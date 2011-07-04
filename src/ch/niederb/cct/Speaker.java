package ch.niederb.cct;

import java.util.Locale;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

public class Speaker implements OnInitListener {
	private static Speaker INSTANCE;
	
	public static Speaker getInstance() {
		return INSTANCE;
	}
	public static void init(Context context) {
		if (INSTANCE == null) { 
			INSTANCE = new Speaker(context);
		} else {
			throw new IllegalStateException("Speaker INSTANCE already initialized");
			
		}
	}
	
	private TextToSpeech speaker;
	
	public Speaker(Context context) {
        speaker = new TextToSpeech(context, this);
        speaker.setLanguage(Locale.GERMAN);
        speaker.setPitch(0.8f);
	}
	
	public void speak(String text) {
		speaker.speak(text, 0, null);
	}
	
	public void onInit(int status) {
		// TODO Auto-generated method stub
	}

	
}

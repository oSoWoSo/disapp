package org.disroot.disrootapp.ui.listener;

import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class FirstTapCheckerListener implements OnClickListener {

	private final SharedPreferences firstStart;

	public FirstTapCheckerListener(SharedPreferences firstStart) {
		this.firstStart = firstStart;
	}

	public abstract void onServiceClick(View v);
	public abstract void onFirstTap();

	public void onClick(View view) {
		//first time tap check
		if (firstStart.getBoolean("firsttap", true)){
			onFirstTap();
			firstStart.edit().putBoolean("firsttap", false).apply();
			return;
		}
		else{
			onServiceClick(view);
		}

	}
}

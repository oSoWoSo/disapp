package org.disroot.disrootapp.model;

import android.content.Intent;

public class ActivityEntryPoint extends DashboardEntryPoint {

	private final Intent targetIntent;

	public ActivityEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, Intent targetIntent, String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.targetIntent = targetIntent;
	}

	public Intent getTargetIntent() {
		return targetIntent;
	}

}

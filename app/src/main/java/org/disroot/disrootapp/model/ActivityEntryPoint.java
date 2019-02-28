package org.disroot.disrootapp.model;

import android.content.Intent;

public class ActivityEntryPoint {
	private final int buttonId;
	private final int serviceInfoTitleId;
	private final int serviceInfoText;
	private final Intent targetIntent;
	private final String helpUrl;

	public ActivityEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoText, Intent targetIntent, String helpUrl) {
		this.buttonId = buttonId;
		this.serviceInfoTitleId = serviceInfoTitleId;
		this.serviceInfoText = serviceInfoText;
		this.targetIntent = targetIntent;
		this.helpUrl = helpUrl;
	}

	public int getButtonId() {
		return buttonId;
	}

	public int getServiceInfoTitleId() {
		return serviceInfoTitleId;
	}

	public int getServiceInfoText() {
		return serviceInfoText;
	}

	public Intent getTargetIntent() {
		return targetIntent;
	}

	public String getHelpUrl() {
		return helpUrl;
	}
}

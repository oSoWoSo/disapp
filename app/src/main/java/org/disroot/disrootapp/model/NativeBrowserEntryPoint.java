package org.disroot.disrootapp.model;

public class NativeBrowserEntryPoint {
	private final int buttonId;
	private final int serviceInfoTitleId;
	private final int serviceInfoId;
	private final String appUrl;
	private final String helpUrl;

	public NativeBrowserEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoId, String appUrl, String helpUrl) {
		this.buttonId = buttonId;
		this.serviceInfoTitleId = serviceInfoTitleId;
		this.serviceInfoId = serviceInfoId;
		this.appUrl = appUrl;
		this.helpUrl = helpUrl;
	}

	public int getButtonId() {
		return buttonId;
	}

	public int getServiceInfoTitleId() {
		return serviceInfoTitleId;
	}

	public int getServiceInfoId() {
		return serviceInfoId;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public String getHelpUrl() {
		return helpUrl;
	}
}

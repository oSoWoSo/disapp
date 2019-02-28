package org.disroot.disrootapp.model;

public class WebviewEntryPoint {
	private final int buttonId;
	private final int serviceTitleId;
	private final int serviceInfoId;
	private final String appUrl;
	private final String helpUrl;

	public WebviewEntryPoint(int buttonId, int serviceTitleId, int serviceInfoId, String appUrl, String helpUrl) {
		this.buttonId = buttonId;
		this.serviceTitleId = serviceTitleId;
		this.serviceInfoId = serviceInfoId;
		this.appUrl = appUrl;
		this.helpUrl = helpUrl;
	}

	public int getButtonId() {
		return buttonId;
	}

	public int getServiceTitleId() {
		return serviceTitleId;
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

package org.disroot.disrootapp.model;

public class WebviewEntryPoint extends DashboardEntryPoint {

	private final String appUrl;

	public WebviewEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, String appUrl, String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

}

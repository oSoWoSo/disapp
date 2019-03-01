package org.disroot.disrootapp.model;

public class DashboardEntryPoint {
	private final int buttonId;
	private final int serviceInfoTitleId;
	private final int serviceInfoTextId;
	private final String helpUrl;

	public DashboardEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, String helpUrl) {
		this.buttonId = buttonId;
		this.serviceInfoTitleId = serviceInfoTitleId;
		this.serviceInfoTextId = serviceInfoTextId;
		this.helpUrl = helpUrl;
	}

	public int getButtonId() {
		return buttonId;
	}

	public int getServiceInfoTitleId() {
		return serviceInfoTitleId;
	}

	public int getServiceInfoTextId() {
		return serviceInfoTextId;
	}

	public String getHelpUrl() {
		return helpUrl;
	}
}

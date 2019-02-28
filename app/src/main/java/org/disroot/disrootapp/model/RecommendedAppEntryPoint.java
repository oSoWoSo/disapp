package org.disroot.disrootapp.model;

public class RecommendedAppEntryPoint {
	private final int buttonId;
	private final String serviceAppPackageId;
	private final int serviceInfoTitleId;
	private final int serviceInfoTextId;
	private final int installServiceAppTextId;
	private final String helpUrl;

	public RecommendedAppEntryPoint(int buttonId, String serviceAppPackageId, int serviceInfoTitleId, int serviceInfoTextId, int installServiceAppTextId, String helpUrl) {
		this.buttonId = buttonId;
		this.serviceAppPackageId = serviceAppPackageId;
		this.serviceInfoTitleId = serviceInfoTitleId;
		this.serviceInfoTextId = serviceInfoTextId;
		this.installServiceAppTextId = installServiceAppTextId;
		this.helpUrl = helpUrl;
	}

	public int getButtonId() {
		return buttonId;
	}

	public String getServiceAppPackageId() {
		return serviceAppPackageId;
	}

	public int getServiceInfoTitleId() {
		return serviceInfoTitleId;
	}

	public int getServiceInfoTextId() {
		return serviceInfoTextId;
	}

	public int getInstallServiceAppTextId() {
		return installServiceAppTextId;
	}

	public String getHelpUrl() {
		return helpUrl;
	}
}

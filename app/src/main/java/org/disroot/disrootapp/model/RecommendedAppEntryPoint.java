package org.disroot.disrootapp.model;

public class RecommendedAppEntryPoint extends DashboardEntryPoint {

	private final String serviceAppPackageId;
	private final int installServiceAppTextId;

	public RecommendedAppEntryPoint(int buttonId, String serviceAppPackageId, int serviceInfoTitleId, int serviceInfoTextId, int installServiceAppTextId, String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.serviceAppPackageId = serviceAppPackageId;
		this.installServiceAppTextId = installServiceAppTextId;
	}


	public String getServiceAppPackageId() {
		return serviceAppPackageId;
	}

	public int getInstallServiceAppTextId() {
		return installServiceAppTextId;
	}

}

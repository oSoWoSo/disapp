package org.disroot.disrootapp.model;

public class ActivityEntryPoint extends DashboardEntryPoint {

	private final Class targetAcivityClass;

	public ActivityEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, Class targetActivityClass, String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.targetAcivityClass = targetActivityClass;
	}

	public Class getTargetAcivityClass() {
		return targetAcivityClass;
	}

}

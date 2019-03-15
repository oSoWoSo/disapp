package org.disroot.disrootapp.model;

import org.disroot.disrootapp.R;
import org.disroot.disrootapp.ui.AboutActivity;
import org.disroot.disrootapp.ui.StateActivity;

public class ActivityEntryPoint extends DashboardEntryPoint {

	private static final ActivityEntryPoint STATE = new ActivityEntryPoint(R.id.StateBtn,
			R.string.StateTitle, R.string.StateInfo, StateActivity.class, null);
	private static final ActivityEntryPoint ABOUT = new ActivityEntryPoint(R.id.AboudBtn,
			R.string.AboutTitle, R.string.AboutInfo,
			AboutActivity.class, null);
	public static final ActivityEntryPoint[] activityEntryPoints = new ActivityEntryPoint[]{
			STATE, ABOUT
	};
	private final Class targetAcivityClass;

	private ActivityEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, Class targetActivityClass,
			String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.targetAcivityClass = targetActivityClass;
	}

	public Class getTargetAcivityClass() {
		return targetAcivityClass;
	}

}

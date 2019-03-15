package org.disroot.disrootapp.model;

import org.disroot.disrootapp.R;
import org.disroot.disrootapp.utils.Constants;

public class NativeBrowserEntryPoint extends DashboardEntryPoint {

	public static final NativeBrowserEntryPoint UPLOAD = new NativeBrowserEntryPoint(R.id.UploadBtn,
			R.string.UploadTitle, R.string.UploadInfo,
			Constants.URL_DisApp_UPLOAD, Constants.URL_DisApp_UPLOADHELP);

	public static final NativeBrowserEntryPoint[] nativetBrowserEntryPoints = new NativeBrowserEntryPoint[]{
			UPLOAD
	};

	private final String appUrl;

	private NativeBrowserEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, String appUrl,
			String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

}

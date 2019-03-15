package org.disroot.disrootapp.model;

import org.disroot.disrootapp.R;
import org.disroot.disrootapp.utils.Constants;

public class WebviewEntryPoint extends DashboardEntryPoint {

	private static final WebviewEntryPoint BIN = new WebviewEntryPoint(R.id.BinBtn, R.string.BinTitle,
			R.string.BinInfo,
			Constants.URL_DisApp_BIN,
			Constants.URL_DisApp_BINHELP);
	private static final WebviewEntryPoint SEARX = new WebviewEntryPoint(R.id.SearxBtn, R.string.SearxTitle,
			R.string.SearxInfo,
			Constants.URL_DisApp_SEARX, Constants.URL_DisApp_SEARXHELP);
	private static final WebviewEntryPoint POLLS = new WebviewEntryPoint(R.id.PollsBtn, R.string.PollsTitle,
			R.string.PollsInfo,
			Constants.URL_DisApp_POLL, Constants.URL_DisApp_POLLHELP);
	private static final WebviewEntryPoint BOARD = new WebviewEntryPoint(R.id.BoardBtn, R.string.BoardTitle,
			R.string.BoardInfo,
			Constants.URL_DisApp_BOARD, Constants.URL_DisApp_BOARDHELP);
	private static final WebviewEntryPoint HOWTO = new WebviewEntryPoint(R.id.HowtoBtn, R.string.HowToTitle,
			R.string.HowToInfo,
			Constants.URL_DisApp_HOWTO, null);
	private static final WebviewEntryPoint USER = new WebviewEntryPoint(R.id.UserBtn, R.string.UserTitle,
			R.string.UserInfo,
			Constants.URL_DisApp_USER,
			null);
	private static final WebviewEntryPoint CALC = new WebviewEntryPoint(R.id.CalcBtn, R.string.CalcTitle,
			R.string.CalcInfo,
			Constants.URL_DisApp_CALC,
			Constants.URL_DisApp_CALCHELP);
	private static final WebviewEntryPoint FORUM = new WebviewEntryPoint(R.id.ForumBtn, R.string.ForumTitle,
			R.string.ForumInfo,
			Constants.URL_DisApp_FORUM, Constants.URL_DisApp_FORUMHELP);
	public static final WebviewEntryPoint[] webViewEntryPoints = new WebviewEntryPoint[]{
			FORUM,
			CALC,
			BIN,
			SEARX,
			POLLS,
			BOARD,
			HOWTO,
			USER
	};

	private final String appUrl;

	private WebviewEntryPoint(int buttonId, int serviceInfoTitleId, int serviceInfoTextId, String appUrl,
			String helpUrl) {
		super(buttonId, serviceInfoTitleId, serviceInfoTextId, helpUrl);
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

}

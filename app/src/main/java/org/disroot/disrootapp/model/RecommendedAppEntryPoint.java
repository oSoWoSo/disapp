package org.disroot.disrootapp.model;

import org.disroot.disrootapp.R;
import org.disroot.disrootapp.utils.Constants;

public class RecommendedAppEntryPoint extends DashboardEntryPoint {

	private static final String CONVERSATIONS = "eu.siacs.conversations";
	// TODO: Let user choose the client
	private static final RecommendedAppEntryPoint CHAT = new RecommendedAppEntryPoint(R.id.ChatBtn, CONVERSATIONS,
			R.string.ChatTitle, R.string.ChatInfo, R.string.ChatDialog, Constants.URL_DisApp_XMPPHELP);
	private static final RecommendedAppEntryPoint MAIL = new RecommendedAppEntryPoint(R.id.MailBtn, "com.fsck.k9",
			R.string.MailInfoTitle,
			R.string.MailInfo,
			R.string.MailDialog, Constants.URL_DisApp_K9HELP);
	private static final RecommendedAppEntryPoint CLOUD = new RecommendedAppEntryPoint(R.id.CloudBtn, "com.nextcloud" +
			".client",
			R.string.CloudInfoTitle,
			R.string.CloudInfo, R.string.CloudDialog, Constants.URL_DisApp_CLOUDHELP);
	private static final RecommendedAppEntryPoint DIASPORA = new RecommendedAppEntryPoint(R.id.DiasporaBtn, "com" +
			".github.dfa" +
			".diaspora_android",
			R.string.DiasporaTitle, R.string.DiasporaInfo, R.string.DiasporaDialog,
			Constants.URL_DisApp_DIAHELP);
	private static final RecommendedAppEntryPoint PAD = new RecommendedAppEntryPoint(R.id.PadBtn, "com.mikifus" +
			".padland",
			R.string.PadTitle,
			R.string.PadInfo,
			R.string.PadDialog, Constants.URL_DisApp_PADHELP);
	private static final RecommendedAppEntryPoint NOTES = new RecommendedAppEntryPoint(R.id.NotesBtn, "it.niedermann" +
			".owncloud.notes",
			R.string.NotesTitle,
			R.string.NotesInfo, R.string.NotesDialog, Constants.URL_DisApp_NOTESHELP);
	public static final RecommendedAppEntryPoint[] recomendedAppEntryPoints = new RecommendedAppEntryPoint[]{
			MAIL,
			CLOUD,
			DIASPORA,
			CHAT,
			PAD,
			NOTES
	};
	private final String serviceAppPackageId;
	private final int installServiceAppTextId;

	private RecommendedAppEntryPoint(int buttonId, String serviceAppPackageId, int serviceInfoTitleId,
			int serviceInfoTextId, int installServiceAppTextId, String helpUrl) {
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

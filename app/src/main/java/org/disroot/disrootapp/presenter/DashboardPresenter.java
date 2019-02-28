package org.disroot.disrootapp.presenter;

import org.disroot.disrootapp.R;
import org.disroot.disrootapp.model.ActivityEntryPoint;
import org.disroot.disrootapp.model.NativeBrowserEntryPoint;
import org.disroot.disrootapp.model.RecommendedAppEntryPoint;
import org.disroot.disrootapp.model.WebviewEntryPoint;
import org.disroot.disrootapp.ui.MainActivity;
import org.disroot.disrootapp.ui.listener.FirstTapCheckerListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;

public class DashboardPresenter {

	private final Activity activity;
	private final WebView webView;
	private final SharedPreferences firstStart;

	public DashboardPresenter(Activity activity, WebView webView, SharedPreferences firstStart) {
		this.activity = activity;
		this.webView = webView;
		this.firstStart = firstStart;
	}

	public void launch(RecommendedAppEntryPoint entryPoint) {
		configureRecommendedApp(entryPoint);
	}

	public void launch(WebviewEntryPoint entryPoint) {
		configureWebviewEntryPoint(entryPoint);
	}

	public void launch(ActivityEntryPoint activityEntryPoint) {
		configureActivityEntryPoint(activityEntryPoint);
	}

	public void launch(final NativeBrowserEntryPoint nativeBrowserEntryPoint) {
		configureNativeBrowserEntryPoint(nativeBrowserEntryPoint);
	}

	private void configureNativeBrowserEntryPoint(final NativeBrowserEntryPoint nativeBrowserEntryPoint) {
		Button button = activity.findViewById(nativeBrowserEntryPoint.getButtonId());
		button.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				showIconInfo(nativeBrowserEntryPoint.getServiceInfoTitleId(), nativeBrowserEntryPoint.getHelpUrl(),
						(ScrollView) activity.findViewById(R.id.dashboard), activity,
						activity.getString(nativeBrowserEntryPoint.getServiceInfoId()), webView);
				return true;
			}
		});
		button.setOnClickListener(new FirstTapCheckerListener(firstStart) {
			@Override
			public void onServiceClick(View v) {
				Uri uri = Uri.parse(nativeBrowserEntryPoint.getAppUrl());
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				activity.startActivity(intent);
			}

			@Override
			public void onFirstTap() {
				showFirstTap(firstStart, activity.getString(R.string.FirstInfo), activity.getApplicationContext());
			}
		});
	}

	private void configureActivityEntryPoint(final ActivityEntryPoint activityEntryPoint) {
		Button button = activity.findViewById(activityEntryPoint.getButtonId());//StateBtn
		button.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				showIconInfo(activityEntryPoint.getServiceInfoTitleId(), activityEntryPoint.getHelpUrl(),
						(ScrollView) activity.findViewById(R.id.dashboard), activity,
						activity.getString(activityEntryPoint.getServiceInfoText()), webView);
				return true;
			}
		});
		button.setOnClickListener(new FirstTapCheckerListener(firstStart) {
			@Override
			public void onServiceClick(View v) {
				activity.startActivity(activityEntryPoint.getTargetIntent());
			}

			@Override
			public void onFirstTap() {
				showFirstTap(firstStart, activity.getString(R.string.FirstInfo), activity);
			}
		});
	}

	private void configureRecommendedApp(final RecommendedAppEntryPoint recommendedAppEntryPoint) {
		Button button = activity.findViewById(recommendedAppEntryPoint.getButtonId());
		button.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				showIconInfo(recommendedAppEntryPoint.getServiceInfoTitleId(), recommendedAppEntryPoint.getHelpUrl(),
						(ScrollView) activity.findViewById(R.id.dashboard), activity,
						activity.getString(recommendedAppEntryPoint.getServiceInfoTextId()),
						webView);
				return true;
			}
		});
		button.setOnClickListener(new FirstTapCheckerListener(firstStart) {
			@Override
			public void onServiceClick(View v) {
				Intent mail = activity.getPackageManager().getLaunchIntentForPackage(recommendedAppEntryPoint.getServiceAppPackageId());
				if(mail == null) {
					showInstallRecommendedAppDialog(recommendedAppEntryPoint.getInstallServiceAppTextId(),
							recommendedAppEntryPoint.getServiceAppPackageId(), activity);
					return;
				}
				activity.startActivity(mail);
			}

			@Override
			public void onFirstTap() {
				showFirstTap(firstStart, activity.getString(R.string.FirstInfo), activity.getApplicationContext());
			}
		});
	}

	private void configureWebviewEntryPoint(final WebviewEntryPoint webviewEntryPoint) {
		Button button = activity.findViewById(webviewEntryPoint.getButtonId());

		button.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				showIconInfo(webviewEntryPoint.getServiceTitleId(), webviewEntryPoint.getHelpUrl(), (ScrollView) activity.findViewById(R.id.dashboard),
						activity, activity.getString(webviewEntryPoint.getServiceInfoId()), webView);
				return true;
			}
		});
		button.setOnClickListener(new FirstTapCheckerListener(firstStart) {
			@Override
			public void onServiceClick(View v) {
				webView.loadUrl(webviewEntryPoint.getAppUrl());
				webView.setVisibility(View.VISIBLE);
				activity.findViewById(R.id.dashboard).setVisibility(View.GONE);
			}

			@Override
			public void onFirstTap() {
				showFirstTap(firstStart, activity.getString(R.string.FirstInfo), activity.getApplicationContext());
			}
		});
	}

	private static void showIconInfo(int titleId, final String helpUrl, final ScrollView dashboard,
			Context context,
			String message, final WebView webView1) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(false);
		builder.setTitle(titleId);
		builder.setMessage(message);
		builder.setPositiveButton(R.string.global_ok, null);
		if (helpUrl != null) {
			builder.setNegativeButton(R.string.more_help, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					webView1.loadUrl(helpUrl);
					webView1.setVisibility(View.VISIBLE);
					dashboard.setVisibility(View.GONE);
				}
			});
		}

		builder.show();
	}

	private static void showFirstTap(SharedPreferences firstStart, String firstTapMessage, Context context) {
		firstStart.edit().putBoolean("firsttap", false).apply();
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(false);
		builder.setTitle(R.string.FirstTitle);
		builder.setMessage(firstTapMessage);
		builder.setPositiveButton(R.string.global_ok, null);
		builder.show();
	}

	private static void showInstallRecommendedAppDialog(int installDialogTextId, final String appPackage,
			final Activity activity){
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setCancelable(false);
		builder.setTitle(R.string.DiaInstallTitle);
		builder.setMessage(activity.getString(installDialogTextId));
		builder.setPositiveButton(R.string.global_install, new DialogInterface.OnClickListener() {
			Intent mail = activity.getPackageManager().getLaunchIntentForPackage(appPackage);
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mail = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackage));
				activity.startActivity(mail);
			}
		});
		builder.setNegativeButton(R.string.global_cancel , null);
		builder.show();
	}
}

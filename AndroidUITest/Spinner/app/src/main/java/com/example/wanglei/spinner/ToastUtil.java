package com.example.wanglei.spinner;


import android.content.Context;
import android.widget.Toast;

public abstract class ToastUtil {
	public static void showLongToast(Context context, CharSequence msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	public static void showShortToast(Context context, CharSequence msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}
}

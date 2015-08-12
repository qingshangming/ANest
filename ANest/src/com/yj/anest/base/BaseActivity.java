/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yj.anest.base;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity {
	
	/**
	 * 盛放所有的ActiWWvity
	 * */
	 public static List<FragmentActivity> activityManagers = new  ArrayList<FragmentActivity>();
	 public static  Context context;
	 public static List<Fragment> fragmentManagers = new ArrayList<Fragment>();
	@Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bmob.initialize(this, "5ee56d057515f17e853b76368054d46f");
		context=this;
    } 	

    /**
     * 返回
     * 
     * @param view
     */
    public void back(View view) {
        finish();
    }
    
   
    /***
     * Yuan Activity
     * 
     */
    /**
	 * 添加Activity
	 * 
	 * 返回值：void
	 * 
	 * 参数：Activity a
	 * 
	 * **/
	public void addActivity(FragmentActivity a){
		activityManagers.add(a);
	}
	public void addFragment(Fragment f){
		fragmentManagers.add(f);
	}
	/**
	 * 描述：将加入的的Activity 遍历 finish（）：退出Activity
	 * 参数：
	 * 返回值：void
	 * **/
	public void exitApplication(){
		for(FragmentActivity a : activityManagers){
			a.finish();
		}
	}
	/***
	 * 描述：杀死fragment
	 * 
	 */
	
	@SuppressLint("NewApi") 
	public void exitAppFragment(){
		for(Fragment a : fragmentManagers){
			a.onDestroy();
		}
	}
	
	/** Debug输出Log日志 **/
	protected void showLogDebug(String tag, String msg) {
		Log.d(tag, msg);
	}

	/** Error输出Log日志 **/
	protected void showLogError(String tag, String msg) {
		Log.e(tag, msg);
	}



	/** 含有Bundle通过Class跳转界面 **/
	protected void startActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	/** 通过Action跳转界面 **/
	protected void startActivity(String action) {
		startActivity(action, null);
	}

	/** 含有Bundle通过Action跳转界面 **/
	protected void startActivity(String action, Bundle bundle) {
		Intent intent = new Intent();
		intent.setAction(action);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}
	
	//
	public void alert(String s){
		Toast.makeText(this,s,Toast.LENGTH_LONG).show();
	}
	/** 短暂显示Toast提示(来自String) **/
	protected void showShortToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	/** 长时间显示Toast提示(来自String) **/
	protected void showLongToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}
	
	/** 含有标题和内容的对话框 **/
	protected AlertDialog showAlertDialog(String title, String message) {
		AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title)
				.setMessage(message).show();
		return alertDialog;
	}

	/** 含有标题、内容、两个按钮的对话框 **/
	protected AlertDialog showAlertDialog(String title, String message,
			String positiveText,
			DialogInterface.OnClickListener onPositiveClickListener,
			String negativeText,
			DialogInterface.OnClickListener onNegativeClickListener) {
		AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title)
				.setMessage(message)
				.setPositiveButton(positiveText, onPositiveClickListener)
				.setNegativeButton(negativeText, onNegativeClickListener)
				.show();
		return alertDialog;
	}

	/** 含有标题、内容、图标、两个按钮的对话框 **/
	protected AlertDialog showAlertDialog(String title, String message,
			int icon, String positiveText,
			DialogInterface.OnClickListener onPositiveClickListener,
			String negativeText,
			DialogInterface.OnClickListener onNegativeClickListener) {
		AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title)
				.setMessage(message).setIcon(icon)
				.setPositiveButton(positiveText, onPositiveClickListener)
				.setNegativeButton(negativeText, onNegativeClickListener)
				.show();
		return alertDialog;
	}

	/** 默认退出 **/
	protected void defaultFinish() {
		super.finish();
	}
	/**
	 * 退出当前进程
	 */
	public void killAll(Context context){
		//获取一个ActivityManager 对象
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		//获取系统中所有正在运行的进程
		List<RunningAppProcessInfo> appProcessInfos = activityManager.getRunningAppProcesses();
		//获取当前activity所在的进程
		String currentProcess = context.getApplicationInfo().processName;
		//对系统中所有正在运行的进程进行迭代，如果进程名不是当前进程，则Kill掉	}
		for(RunningAppProcessInfo appProcessInfo : appProcessInfos){
				String processName = appProcessInfo.processName;
				if(!processName.equals(currentProcess)){
					java.lang.System.out.println("Applicationinfo:" + processName);
					activityManager.killBackgroundProcesses(processName);
					java.lang.System.out.println("Killed -->PID:"+appProcessInfo.pid+"--ProcessName:"+processName);
				}
			}
		}
}

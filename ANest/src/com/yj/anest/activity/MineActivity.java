package com.yj.anest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.bmob.v3.Bmob;

import com.yj.anest.R;
/**
 * 我的个人中心页面
 * @author Administrator
 *
 */
public class MineActivity extends Fragment{
	public View v;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_mine,null);
		initDate();
		return v;
	}
	private void initDate(){
		
	}
}

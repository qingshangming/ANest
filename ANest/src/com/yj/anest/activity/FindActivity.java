package com.yj.anest.activity;

import cn.bmob.v3.Bmob;

import com.yj.anest.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * faxian
 * @author Administrator
 *
 */
public class FindActivity extends Fragment{
	public View v;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_find,null);
		initDate();
		Bmob.initialize(getActivity(), "5ee56d057515f17e853b76368054d46f");
		return v;
	}
	private void initDate(){
		
	}
}
 
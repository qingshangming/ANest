package com.yj.anest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import cn.bmob.v3.Bmob;

import com.yj.anest.R;

/**
 * 心情 主界面
 * mood 
 * @author Administrator
 *
 */
public class MoodActivity extends Fragment implements OnClickListener{
	public View v;
	ImageButton publish_mood;//发表心情
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_mood,null);
		initDate();
		Bmob.initialize(getActivity(), "5ee56d057515f17e853b76368054d46f");
		return v;
	}
	private void initDate(){
		publish_mood = (ImageButton) v.findViewById(R.id.publish_mood);
		publish_mood.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		//发表帖子
		case R.id.publish_mood:
			Intent s = new Intent(getActivity(),PublishMood.class);
			startActivity(s);
			break;

		default:
			break;
		}
	}
}

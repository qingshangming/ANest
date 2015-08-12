package com.yj.anest.activity;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import com.yj.anest.R;
import com.yj.anest.base.BaseActivity;
import com.yj.anest.entity.MyUser;
import com.yj.anest.entity.Post;
import com.yj.anest.util.CustomProgress;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PublishMood extends BaseActivity implements OnClickListener{
	Button publish_start;
	EditText mood_title,mood_content;
	private String title,content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publih_mood);
		initData();
		addActivity(this);
		Bmob.initialize(this, "5ee56d057515f17e853b76368054d46f");
	}
	/***
	 * 初始化界面
	 */
	private void initData(){
		publish_start = (Button) findViewById(R.id.publish_start);
		publish_start.setOnClickListener(this);
		mood_title = (EditText) findViewById(R.id.mood_title);
		mood_content = (EditText) findViewById(R.id.mood_content);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		//点击发表
		case R.id.publish_start:
			title = mood_title.getText().toString();
			content = mood_content.getText().toString();
			CustomProgress.show(this, "请稍后...", true, null);
			MyUser user = BmobUser.getCurrentUser(this, MyUser.class);
			// 创建帖子信息
			Post post = new Post();
			post.setTitle(title);
			post.setContent(content);
			//添加一对一关联
			post.setAuthor(user);
			post.save(this, new SaveListener() {
			    @Override
			    public void onSuccess() {
			        // TODO Auto-generated method stub
			       CustomProgress.dissmiss();
			       alert("成功");
			       
			    }
			    @Override
			    public void onFailure(int code, String msg) {
			         // TODO Auto-generated method stub
			         //...
			    	CustomProgress.dissmiss();
			    	alert("error:"+msg);
			    }
			});
			break;

		default:
			break;
		}
	}
}

package com.yj.anest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.bmob.v3.Bmob;

import com.yj.anest.R;
import com.yj.anest.base.BaseActivity;

public class FragmentActivity extends BaseActivity{
	protected static final String TAG = "MainActivity";
	//未读消息textview显示
	private TextView unreadLabel;
	
	private Button[] mTabs;
	private MoodActivity moodActivity;
	private FindActivity findActivity;
	
	private NewsActivity newsActivity;
	
	private MineActivity mineActivity;
	private Fragment[] fragments;
	private int index;
	
	// 当前fragment的index
	private int currentTabIndex;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.fragmentactivity);
		addActivity(this);
		Bmob.initialize(this, "5ee56d057515f17e853b76368054d46f");
		initView();
		
		moodActivity = new MoodActivity();
		findActivity = new FindActivity();
		newsActivity = new NewsActivity();
		mineActivity = new MineActivity();
		fragments = new Fragment[] { moodActivity, findActivity, newsActivity,mineActivity };
		// 添加显示第一个fragment
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, moodActivity)
				.add(R.id.fragment_container, findActivity).hide(findActivity).show(moodActivity)
				.commit();
	}
	
	/**
	 * 初始化组件
	 */
	private void initView() {
		//unreadLabel = (TextView) findViewById(R.id.unread_msg_number);
		mTabs = new Button[4];
		mTabs[0] = (Button) findViewById(R.id.btn_conversation);
		mTabs[1] = (Button) findViewById(R.id.btn_address_list);
		mTabs[2] = (Button) findViewById(R.id.btn_faxian);
		mTabs[3] = (Button) findViewById(R.id.btn_piaoke);
		// 把第一个tab设为选中状态
		mTabs[0].setSelected(true);

	}
	
	/**
	 * button点击事件
	 * 
	 * @param view
	 */
	public void onTabClicked(View view) {
		switch (view.getId()) {
		case R.id.btn_conversation:
			index = 0;
			break;
		case R.id.btn_address_list:
			index = 1;
			break;
		case R.id.btn_faxian:
			index = 2;
			break;
		case R.id.btn_piaoke:
			index = 3;
			break;
		}
		if (currentTabIndex != index) {
			FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
			trx.hide(fragments[currentTabIndex]);
			if (!fragments[index].isAdded()) {
				trx.add(R.id.fragment_container, fragments[index]);
			}
			trx.show(fragments[index]).commit();
		}
		mTabs[currentTabIndex].setSelected(false);
		// 把当前tab设为选中状态
		mTabs[index].setSelected(true);
		currentTabIndex = index;
	}
	
}

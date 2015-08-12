package com.yj.anest.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import com.yj.anest.R;
import com.yj.anest.base.BaseActivity;
import com.yj.anest.util.ClearEditText;
import com.yj.anest.util.CustomProgress;
import com.yj.anest.util.NetWorkUtils;
/***
 * 登陆界面
 * login interfacrace
 * @author Administrator
 *
 */
public class LoginActivity extends BaseActivity implements OnClickListener{
	Button login_strart;
	com.yj.anest.util.ClearEditText login_username_edit,login_password_edit;
	String userName,passWord;
	BmobUser bu2 = new BmobUser();
	SharedPreferences sp;
	public static String un,up;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.login_activity);
		if(NetWorkUtils.isConnected(context) == false){
			alert("无网络！");
		}
		init();
		addActivity(this);
		Bmob.initialize(this, "5ee56d057515f17e853b76368054d46f");
		sp = getSharedPreferences("automaticlogin", Context.MODE_PRIVATE);
		un = sp.getString("userName", "");
		up = sp.getString("passWord", "");
		login_username_edit.setText(un);
		login_password_edit.setText(up);
		if(un!=null && un!="" && up!=null &up!=""){
			 startActivity(FragmentActivity.class,null);
			 defaultFinish();
		}else{
			return;
		}
		
	}
	private void init(){
		login_strart = (Button) findViewById(R.id.login_start);
		login_strart.setOnClickListener(this);
		login_username_edit = (ClearEditText) findViewById(R.id.login_username_edit);
		login_password_edit = (ClearEditText) findViewById(R.id.login_password_edit);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// click login
		case R.id.login_start:
			userName = login_username_edit.getText().toString();
			passWord = login_password_edit.getText().toString();
			bu2.setUsername(userName);
			bu2.setPassword(passWord);
			CustomProgress.show(LoginActivity.this, "登录中...", true, null);
			bu2.login(this,new SaveListener() {
				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					 alert("登录成功:");
				     sp = getSharedPreferences("automaticlogin", 0);
            		 Editor eduser = sp.edit();//创建文件夹
		    		 eduser.putString("userName",userName);
		    		 eduser.putString("passWord",passWord);
		    		 eduser.commit();
					 startActivity(FragmentActivity.class,null);
					 CustomProgress.dissmiss();
					 defaultFinish();
				}
				
				@Override
				public void onFailure(int arg0, String arg1) {
					// TODO Auto-generated method stub
					alert("登录失败:"+arg1);
					CustomProgress.dissmiss();
				}
			});
			
			break;

		default:
			break;
		}
	}
	
	
	
}

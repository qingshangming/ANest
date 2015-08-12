package com.yj.anest;

import com.yj.anest.activity.LoginActivity;
import com.yj.anest.base.BaseActivity;

import android.os.Bundle;
import android.view.Window;
/**
 * A nest class
 * @author Administratorh
 *	shan pin
 */

public class MainActivity extends BaseActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        addActivity(this);
        new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					new Thread().sleep(2000);
					startActivity(LoginActivity.class,null);
					defaultFinish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
    }
}

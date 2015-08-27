package com.example.jartest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.sumile.MDReceiver;
import cn.sumile.MDReceiver.GetProgressInterface;
import cn.sumile.MultiDownload.MDIntent;
import cn.sumile.entity.FileInfo;

public class MainActivity extends ActionBarActivity {
	private Button button;
	private MDReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FileInfo fileInfo = new FileInfo("http://www.imooc." + "com/mobile/mukewang.apk", "muke.apk", Environment.getExternalStorageDirectory().toString());
				new MDIntent(MainActivity.this, fileInfo).start();
				// ÔÝÍ£
//				new MDIntent(MainActivity.this, fileInfo).stop();
			}
		});
		receiver = new MDReceiver(MainActivity.this);
		receiver.getProgress(new GetProgressInterface() {

			@Override
			public void doingSomething(int progress) {
				button.setText(String.valueOf(progress));
			}
		});
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		super.onDestroy();
	}

}

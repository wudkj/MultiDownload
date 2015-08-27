# MultiDownload
文件断点续传（视频貌似有些问题，别的没发现）
## 使用方法 ##
    //按钮下载或者暂停下载
    button.setOnClickListener(new OnClickListener() {
    	@Override
    	public void onClick(View v) {
    	FileInfo fileInfo = new FileInfo("http://www.imooc.com/mobile/mukewang.apk", "muke.apk", Environment.getExternalStorageDirectory().toString());
    	new MDIntent(MainActivity.this, fileInfo).start();
    		// 暂停
    //new MDIntent(MainActivity.this, fileInfo).stop();
    	}
    });
    //获得receiver
    receiver = new MDReceiver(MainActivity.this);
    //获得进度
    receiver.getProgress(new GetProgressInterface() {
    	@Override
    	public void doingSomething(int progress) {
    		button.setText(String.valueOf(progress));
    	}
    });
## 注意事项 ##
    onDestroy中记得写unregisterReceiver(receiver);
    记得申请权限
    记得注册receiver
    一定要有这句话：
    <service android:name="cn.sumile.service.DownloadService" >
# LICENSE #
    Copyright   2015    wudkj
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
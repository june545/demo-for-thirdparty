package com.june.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity-========";
	TextView editText;
	WebView webView;

	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		editText = (TextView) findViewById(R.id.edittext);
		webView = (WebView) findViewById(R.id.webview);
		webView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				Log.d(TAG,"===================" + newProgress);
			}
		});

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("action", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								testOkhttp();
							}
						}).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}else if(id == R.id.okhttp){
			testOkhttp();
		}else if(id == R.id.retrofit){
			testRetrofit();
		}

		return super.onOptionsItemSelected(item);
	}


	private void testOkhttp(){
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder().url("https://github.com/june545").build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				int code = response.code();
				String msg = response.message();
				ResponseBody body = response.body();
				final String s = body.string();
//				Log.w(TAG, " code:" + code + ", msg:" + msg + ", body:" + s);

				handler.post(new Runnable() {
					@Override
					public void run() {
						Log.w(TAG, "body:" + s);
						editText.setText(s);
//						webView.loadDataWithBaseURL("about:blank", s	, "text/html", "UTF-8", null);
					}
				});
			}
		});
	}

	private void testRetrofit(	){
		Toast.makeText(getApplicationContext(), "this is under construction !", Toast.LENGTH_LONG).show();
	}

}

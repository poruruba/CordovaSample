package jp.or.sample.SamplePlugin;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main extends CordovaPlugin {
	public static String TAG = "SamplePlugin.Main";
	private Activity activity;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView)
	{
		Log.d(TAG, "[Plugin] initialize called");
		super.initialize(cordova, webView);

		activity = cordova.getActivity();
	}

	@Override
	public void onResume(boolean multitasking)
	{
		Log.d(TAG, "[Plugin] onResume called");
		super.onResume(multitasking);
	}

	@Override
	public void onPause(boolean multitasking)
	{
		Log.d(TAG, "[Plugin] onPause called");
		super.onPause(multitasking);
	}

	@Override
	public void onNewIntent(Intent intent)
	{
		Log.d(TAG, "[Plugin] onNewIntent called");
		super.onNewIntent(intent);
	}

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException
	{
		Log.d(TAG, "[Plugin] execute called");
		if( action.equals("func1") ){
			int arg0 = args.getInt(0);
			String arg1 = args.getString(1);
			JSONArray input_array = args.getJSONArray(2);
			int[] arg2 = new int[input_array.length()];
			for( int i = 0 ; i < arg2.length ; i++ )
				arg2[i] = input_array.getInt(i);
			
			JSONArray output_array = new JSONArray();
			for( int i = 0 ; i < arg2.length ; i++ )
				output_array.put(arg2[i]);
			
			JSONObject result = new JSONObject();
			result.put("arg0", arg0);
			result.put("arg1", arg1);
			result.put("arg2", output_array);
			callbackContext.success(result);
		}else
		if( action.equals("func2") ){
			String arg0 = args.getString(0);
			if( arg0.equals("int") ){
				callbackContext.success(1234);
			}else
			if( arg0.equals("string") ){
				callbackContext.success("Hello World");
			}else
			if( arg0.equals("array") ){
				JSONArray output_array = new JSONArray();
				for( int i = 0 ; i < 5 ; i++ )
					output_array.put(i);
				callbackContext.success(output_array);
			}else{
				callbackContext.error("Unknown arg0");
				return false;
			}
		}else {
			String message = "Unknown action : (" + action + ") " + args.getString(0);
			Log.d(TAG, message);
			callbackContext.error(message);
			return false;
		}

		return true;
	}
}


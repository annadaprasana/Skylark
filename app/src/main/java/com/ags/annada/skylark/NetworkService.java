package com.ags.annada.skylark;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import com.ags.annada.skylark.events.NetworkResponse;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by Annada on 20/10/2015.
 */
public class NetworkService extends IntentService {
    private static final String TAG = NetworkService.class.getSimpleName();

    private static String BASE_URL = "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/";
    private static String SET_URL = "api/sets/";

    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_FAILED = "failed";

    private String mUrl;

    public NetworkService() {
        super(NetworkService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "NetworkService Started!");

        mUrl = BASE_URL + SET_URL;

        NetworkResponse response = new NetworkResponse();

        if (!TextUtils.isEmpty(mUrl)) {
            try {
                String data = loadData();
                if(data != null){
                    response.setStatus(STATUS_SUCCESS);
                    response.setResult(data);
                    EventBus.getDefault().post(response);

                }
            } catch (IOException | JSONException e) {
                Log.e(TAG, e.getMessage());

                response.setStatus(STATUS_FAILED);
                EventBus.getDefault().post(response);
            }
        }

        Log.d(TAG, "NetworkService Stopping!");
        this.stopSelf();
    }

    private String loadData() throws IOException, JSONException {
        URL url = new URL(mUrl);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = null;

        try {
            inputStream = new BufferedInputStream(urlConnection.getInputStream());
            byte[] buffer = read(inputStream);

            String charset = parseCharset(urlConnection.getRequestProperty("Content-Type"));

            String jsonText = new String(buffer, charset);

            return new String(jsonText);
        } finally {
            urlConnection.disconnect();
            inputStream.close();
        }
    }

    public static byte[] read(InputStream stream) throws IOException {
        ArrayList<Byte> data = new ArrayList<>();
        while (true) {
            int result = stream.read();
            if (result == -1) {
                break;
            }
            data.add((byte) result);
        }

        byte[] bytes = new byte[data.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = data.get(i);
        }

        return bytes;
    }

    public static String parseCharset(String contentType) {
        if (contentType != null) {
            String[] params = contentType.split(",");
            for (int i = 1; i < params.length; i++) {
                String[] pair = params[i].trim().split("=");
                if (pair.length == 2) {
                    if (pair[0].equals("charset")) {
                        return pair[1];
                    }
                }
            }
        }
        return "UTF-8";
    }
}

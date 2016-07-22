package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.zac.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.zacmckenney.displayjokes.DisplayJokeActivity;

import java.io.IOException;

/**
 * Created by Zac on 7/18/16.
 */
    public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
        private static MyApi myApiService = null;
        private Context context;

        ProgressDialog pd;

        public static String resultJoke;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(MainActivity.context);
        pd.setMessage(MainActivity.context.getString(R.string.loading_joke));
        pd.show();

    }

    @Override
        protected String doInBackground(Context... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-1377.appspot.com/_ah/api/");
                // end options for devappserver

                myApiService = builder.build();
            }

            context = params[0];

            try {
                return myApiService.tellJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            resultJoke = result;

            if (pd.isShowing()){
                pd.dismiss();
            }

            DisplayJokeActivity displayJokeActivity = new DisplayJokeActivity();
            Intent intent = new Intent(context, displayJokeActivity.getClass()).putExtra("JOKE_EXTRA", result);
            context.startActivity(intent);
        }
    }

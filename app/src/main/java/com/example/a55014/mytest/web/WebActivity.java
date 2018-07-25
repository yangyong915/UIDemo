package com.example.a55014.mytest.web;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a55014.mytest.R;

/**
 * crate by yy on 2018-1-1
 * describle:
 */
public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        new myAsyncTask(this).execute();
    }

    class myAsyncTask extends AsyncTask<Void, Integer, Boolean> {
        Context mContext;

        myAsyncTask(Context context) {
            this.mContext = context;
        }

        /**
         * 准备方法
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * 后台任务
         *
         * @param voids
         * @return
         */
        @Override
        protected Boolean doInBackground(Void... voids) {
            publishProgress(2);
            return null;
        }

        /**
         * 任务过程监听
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /**
         * 任务完成
         *
         * @param aBoolean
         */
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);
        }
    }
}

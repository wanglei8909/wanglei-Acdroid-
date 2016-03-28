package com.example.wanglei.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
    }

    public void download(View source) throws MalformedURLException{
        DownTask task = new DownTask(this);
        task.execute(new URL("http://www.crazyit.org/ethos.php"));
    }
    class DownTask extends AsyncTask<URL,Integer,String>{
        ProgressDialog pdialog;
        int hasRead = 0;
        Context mContext;
        public DownTask(Context ctx){
            mContext = ctx;
        }
        @Override
        protected  String doInBackground(URL...params){
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URLConnection conn = params[0].openConnection();
                //打开conn连接对应的输入流，并将它包装成BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
                String line = null;
                while ((line = br.readLine()) != null){
                    stringBuilder.append(line+"\n");
                    hasRead++;
                    publishProgress(hasRead);
                }
                return (stringBuilder.toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result){
            //返回HTML页面的内容
            show.setText(result);
            pdialog.dismiss();
        }
        @Override
        protected void onPreExecute(){
            pdialog = new ProgressDialog(mContext);
            pdialog.setTitle("任务进行中");
            pdialog.setMessage("任务正在进行中，敬请等待。。。");
            pdialog.setCancelable(false);
            pdialog.setMax(202);
            pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pdialog.setIndeterminate(false);
            pdialog.show();
        }
        @Override
        protected void onProgressUpdate(Integer...value){
            //更新进度
            show.setText("已经读取了【"+value[0]+"】行!");
            pdialog.setProgress(value[0]);
        }
    }
}














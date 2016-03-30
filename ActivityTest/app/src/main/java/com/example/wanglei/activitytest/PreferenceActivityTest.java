package com.example.wanglei.activitytest;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by wanglei on 16/3/28.
 */
public class PreferenceActivityTest extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //该方法用于给界面设置一个标题按钮
        if (hasHeaders()){
            Button button = new Button(this);
            button.setText("设置操作");
            //将按钮添加
            setListFooter(button);
        }
    }

    //重写该方法，负责加载界面布局文件
    @Override
    public void onBuildHeaders(List<Header> target){
        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    //重写该方法，验证各PreferenceFragment是否有效
    @Override
    public boolean isValidFragment(String fragmentName){
        return true;
    }

    public static class Prefs1Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    public static class Prefs2Fragment extends PreferenceFragment{

        @Override
        public void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);
            //获取传入该 Fragment 的参数
            String website = getArguments().getString("website");
            Toast.makeText(getActivity(),"网站域名是"+website,Toast.LENGTH_LONG).show();
        }
    }
}

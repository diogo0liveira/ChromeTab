package com.dao.chrome;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dao.chrome.helper.CustomChromeHelper;
import com.dao.chrome.helper.CustomTabsHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
//    private CustomChromeHelper chromeHelper;
//    private MainCustomTabsService customTabsService;
//    private Uri uri = Uri.parse("https://blog.guaraniafv.com.br");
    private Uri uri = Uri.parse("https://www.guaranisistemas.com.br");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
//        chromeHelper.bindCustomTabsService(this);
//        customTabsService.bindService(this);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
//        chromeHelper.unbindCustomTabsService(this);
//        customTabsService.unbindService(this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
//        chromeHelper.setConnectionCallback(null);
    }

    private void initializeView()
    {
        Button buttonStart = this.findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(this);

//        chromeHelper = new CustomChromeHelper();
//        chromeHelper.mayLaunchUrl(uri, null, null);
//        customTabsService = new MainCustomTabsService(uri.toString());
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.buttonStart)
        {
            startBrowser();
        }
    }

    private void startBrowser()
    {


        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        builder.addDefaultShareMenuItem();
        builder.setShowTitle(true);

        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, uri);

//        CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent);

//        CustomChromeHelper.openCustomTab(this, customTabsIntent, uri, new CustomChromeHelper.CustomTabFallback() {
//                    @Override
//                    public void openUri(Activity activity, Uri uri)
//                    {
//
//                    }
//                });
    }
}

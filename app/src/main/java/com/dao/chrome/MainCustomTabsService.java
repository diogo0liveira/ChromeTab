package com.dao.chrome;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;

/**
 * Created in 14/02/19 21:22.
 *
 * @author Diogo Oliveira.
 */
public class MainCustomTabsService extends CustomTabsServiceConnection
{
    private CustomTabsClient customTabsClient;
    private final Uri uri;

    MainCustomTabsService(String url)
    {
        uri = Uri.parse(url);
    }

    @Override
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient)
    {
        this.customTabsClient = customTabsClient;
        this.customTabsClient.warmup(0L);
        CustomTabsSession customTabsSession = this.customTabsClient.newSession(null);
        customTabsSession.mayLaunchUrl(uri, null, null);
    }

    @Override
    public void onServiceDisconnected(ComponentName name)
    {
        customTabsClient = null;
    }

    public void bindService(Context context)
    {
        CustomTabsClient.bindCustomTabsService(context, "com.android.chrome", this);
    }

    public void unbindService(Context context)
    {
        context.unbindService(this);
    }
}

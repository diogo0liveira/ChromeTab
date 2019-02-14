package com.dao.chrome.helper;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;

import java.lang.ref.WeakReference;

/**
 * Created in 14/02/19 20:24.
 *
 * @author Diogo Oliveira.
 */
public class ServiceConnection extends CustomTabsServiceConnection
{
    private WeakReference<ServiceConnectionCallback> mConnectionCallback;

    public ServiceConnection(ServiceConnectionCallback connectionCallback)
    {
        mConnectionCallback = new WeakReference<>(connectionCallback);
    }

    @Override
    public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client)
    {
        ServiceConnectionCallback connectionCallback = mConnectionCallback.get();
        if(connectionCallback != null)
        {
            connectionCallback.onServiceConnected(client);
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name)
    {
        ServiceConnectionCallback connectionCallback = mConnectionCallback.get();
        if(connectionCallback != null)
        {
            connectionCallback.onServiceDisconnected();
        }
    }
}

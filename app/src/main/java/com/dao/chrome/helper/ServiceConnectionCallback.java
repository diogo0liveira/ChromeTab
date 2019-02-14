package com.dao.chrome.helper;

import android.support.customtabs.CustomTabsClient;

/**
 * Created in 14/02/19 20:25.
 *
 * @author Diogo Oliveira.
 */
public interface ServiceConnectionCallback
{
    /**
     * Called when the service is connected.
     *
     * @param client a CustomTabsClient
     */
    void onServiceConnected(CustomTabsClient client);

    /**
     * Called when the service is disconnected.
     */
    void onServiceDisconnected();
}

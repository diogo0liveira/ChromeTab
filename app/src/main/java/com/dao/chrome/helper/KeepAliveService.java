package com.dao.chrome.helper;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created in 14/02/19 20:23.
 *
 * @author Diogo Oliveira.
 */
public class KeepAliveService extends Service
{
    private static final Binder sBinder = new Binder();

    @Override
    public IBinder onBind(Intent intent)
    {
        return sBinder;
    }
}

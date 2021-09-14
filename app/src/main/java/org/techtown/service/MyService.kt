package org.techtown.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    } //onBind()는 스타티드 서비스에서는 사용 안합니다.

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Log.d("SartedService", "action = $action")
        return super.onStartCommand(intent, flags, startId)
    }

    companion object {
        val ACTION_START = "kr.co.hanbit.servicetest.START"
        val ACTION_RUN = "kr.co.hanbit.servicetest.RUN"
        val ACTION_STOP = "kr.co.hanbit.servicetest.STOP"
    }

    override fun onDestroy() {
        Log.d("Service", "서비스가 종료되었습니다.")
        super.onDestroy()
    }

    inner class MyBinder : Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }

    val binder = MyBinder()

    fun serviceMessage(): String {
        return "Hello Activity! I am Service!"
    }
}
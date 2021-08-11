package com.example.tripplanner

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

// 전역으로 사용 가능한 context (GlobalApplication)
class App : Application() {

    //singleton 사용
    companion object{
        var instance : App? = null
    }

    override fun onCreate() {
        super.onCreate()
        // 카카오 SDK 초기화
        // KakaoSdk.init(this, getString(R.string.kakao_app_key))
        KakaoSdk.init(this, KakaoSdkAdapter().toString())
        instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }
    fun getAppContext() : App{
        checkNotNull(instance){
            "This Application does not inherit com.kakao.App"
        }
        return instance!!
    }
}
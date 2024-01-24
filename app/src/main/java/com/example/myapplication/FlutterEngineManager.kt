package com.example.myapplication

import android.content.Context
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor

object FlutterEngineManager {
    private var flutterEngine: FlutterEngine? = null

    fun startFlutterEngine(context: Context) {
        if(flutterEngine == null) {
            flutterEngine = FlutterEngine(context)
            flutterEngine!!.navigationChannel.setInitialRoute("test")
            flutterEngine!!.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        }
    }

    fun stopFlutterEngine() {
        if(flutterEngine != null) {
            flutterEngine!!.destroy()
            flutterEngine = null
        }
    }

    fun getFlutterEngine(): FlutterEngine {
        return flutterEngine!!
    }
}
package com.piccmaq.disk_space_plus

import android.content.Context
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

class DiskSpacePlusPlugin: FlutterPlugin {

    private var channel: MethodChannel? = null
    private lateinit var handler: MethodHandlerImpl
    private lateinit var context: Context

    private fun registerChannel(messenger: BinaryMessenger) {
        channel = MethodChannel(messenger, "disk_space_plus")
        channel!!.setMethodCallHandler(handler)
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        context = binding.applicationContext
        handler = MethodHandlerImpl(context)
        registerChannel(binding.binaryMessenger)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel?.setMethodCallHandler(null)
        channel = null
    }
}

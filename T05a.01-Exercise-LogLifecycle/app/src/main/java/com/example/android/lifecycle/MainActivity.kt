package com.example.android.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /*
     * This TextView will contain a running log of every lifecycle callback method called from this
     * Activity. This TextView can be reset to its default state by clicking the Button labeled
     * "Reset Log"
     */
    private var mLifecycleDisplay: TextView? = null

    /**
     * Called when the activity is first created. This is where you should do all of your normal
     * static set up: create views, bind data to lists, etc.

     * Always followed by onStart().

     * @param savedInstanceState The Activity's previously frozen state, if there was one.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLifecycleDisplay = findViewById(R.id.tv_lifecycle_events_display) as TextView

        // COMPLETED (1) Use logAndAppend within onCreate
        logAndAppend(ON_CREATE)
    }

    // COMPLETED (2) Override onStart, call super.onStart, and call logAndAppend with ON_START

    override fun onStart() {
        super.onStart()
        logAndAppend(ON_START)
    }

    // COMPLETED (3) Override onResume, call super.onResume, and call logAndAppend with ON_RESUME

    override fun onResume() {
        super.onResume()
        logAndAppend(ON_RESUME)
    }

    // COMPLETED (4) Override onPause, call super.onPause, and call logAndAppend with ON_PAUSE

    override fun onPause() {
        super.onPause()
        logAndAppend(ON_PAUSE)
    }

    // COMPLETED (5) Override onStop, call super.onStop, and call logAndAppend with ON_STOP
    override fun onStop() {
        super.onPause()
        logAndAppend(ON_STOP)
    }

    // COMPLETED (6) Override onRestart, call super.onRestart, and call logAndAppend with ON_RESTART
    override fun onRestart() {
        super.onPause()
        logAndAppend(ON_RESTART)
    }

    // COMPLETED (7) Override onDestroy, call super.onDestroy, and call logAndAppend with ON_DESTROY
    override fun onDestroy() {
        super.onPause()
        logAndAppend(ON_DESTROY)
    }

    /**
     * Logs to the console and appends the lifecycle method name to the TextView so that you can
     * view the series of method callbacks that are called both from the app and from within
     * Android Studio's Logcat.

     * @param lifecycleEvent The name of the event to be logged.
     */
    private fun logAndAppend(lifecycleEvent: String) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent)

        mLifecycleDisplay!!.append(lifecycleEvent + "\n")
    }

    /**
     * This method resets the contents of the TextView to its default text of "Lifecycle callbacks"

     * @param view The View that was clicked. In this case, it is the Button from our layout.
     */
    fun resetLifecycleDisplay(view: View) {
        mLifecycleDisplay!!.text = "Lifecycle callbacks:\n"
    }

    companion object {

        /*
     * This tag will be used for logging. It is best practice to use the class's name using
     * getSimpleName as that will greatly help to identify the location from which your logs are
     * being posted.
     */
        private val TAG = MainActivity::class.java!!.getSimpleName()

        /* Constant values for the names of each respective lifecycle callback */
        private val ON_CREATE = "onCreate"
        private val ON_START = "onStart"
        private val ON_RESUME = "onResume"
        private val ON_PAUSE = "onPause"
        private val ON_STOP = "onStop"
        private val ON_RESTART = "onRestart"
        private val ON_DESTROY = "onDestroy"
        private val ON_SAVE_INSTANCE_STATE = "onSaveInstanceState"
    }
}

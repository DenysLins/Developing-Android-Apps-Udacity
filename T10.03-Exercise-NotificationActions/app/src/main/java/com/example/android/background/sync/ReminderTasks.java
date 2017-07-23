/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.background.sync;

import android.content.Context;

import com.example.android.background.utilities.PreferenceUtilities;

import static com.example.android.background.utilities.NotificationUtils.clearNotification;

public class ReminderTasks {

    public static final String ACTION_INCREMENT_WATER_COUNT = "increment-water-count";
    //  Completed (2) Add a public static constant called ACTION_DISMISS_NOTIFICATION
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";

    public static void executeTask(Context context, String action) {
        //      Completed (3) If the user ignored the reminder, clear the notification
        switch (action) {
            case ACTION_INCREMENT_WATER_COUNT:
                incrementWaterCount(context);
                break;
            case ACTION_DISMISS_NOTIFICATION:
                clearNotification(context);
                break;
            default:
                throw new UnsupportedOperationException("Invalid action: " + action);
        }
    }

    private static void incrementWaterCount(Context context) {
        PreferenceUtilities.incrementWaterCount(context);
        //      Completed (4) If the water count was incremented, clear any notifications
        clearNotification(context);
    }
}
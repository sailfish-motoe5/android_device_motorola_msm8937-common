/*
 * Copyright (C) 2017 The AOSP Project
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

package com.moto.actions;

import android.os.Bundle;
import androidx.preference.PreferenceCategory;
import android.support.v14.preference.PreferenceFragment;

import com.moto.actions.actions.CameraActivationSensor;

public class ActionsPreferenceFragment extends PreferenceFragment {
    private final String KEY_ACTIONS_CATEGORY = "actions_key";
    private final String KEY_GESTURE_CAMERA_ACTION = "gesture_camera_action";
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

        if (!CameraActivationSensor.hasSensor(getContext())) {
            PreferenceCategory category = findPreference(KEY_ACTIONS_CATEGORY);
            category.removePreferenceRecursively(KEY_GESTURE_CAMERA_ACTION);
        }
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.main_panel);
    }
}

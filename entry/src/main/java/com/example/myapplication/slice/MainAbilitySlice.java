/*
 * Copyright (C) 2020-21 Application Library Enigineering Group
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

package com.example.myapplication.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import com.example.myapplication.ResourceTable;
import com.singhajit.sherlock.core.Sherlock;

/**
 * MainAbilitySlice class.
 */
public class MainAbilitySlice extends AbilitySlice {

    /**
     * onStart.
     */
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Sherlock.init(this);
        Button button = (Button) findComponentById(ResourceTable.Id_button);
        button.setClickedListener(component -> {
            int x = 10;
            int y = 0;
            x = x / y;
        });
    }

    /**
     * onActive.
     */
    @Override
    public void onActive() {
        super.onActive();
    }

    /**
     * onForeground.
     */
    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

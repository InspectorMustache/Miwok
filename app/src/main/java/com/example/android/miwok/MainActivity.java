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
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        View colors = findViewById(R.id.colors);
        View family = findViewById(R.id.family);
        View numbers = findViewById(R.id.numbers);
        View phrases = findViewById(R.id.phrases);

        colors.setOnClickListener(this);
        family.setOnClickListener(this);
        numbers.setOnClickListener(this);
        phrases.setOnClickListener(this);

    }

//    callback method for onClick events
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.colors:
                moveToActivity(ColorsActivity.class);
            break;
            case R.id.family:
                moveToActivity(FamilyActivity.class);
            break;
            case R.id.numbers:
                moveToActivity(NumbersActivity.class);
            break;
            case R.id.phrases:
                moveToActivity(PhrasesActivity.class);
            break;
        }
    }

    private void moveToActivity(Class activityClass) {
        Intent moveIntent = new Intent(this, activityClass);
        startActivity(moveIntent);
    }
}

/*
 * Copyright 2018 Dan Brough
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package danbroid.util.demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import danbroid.test.Test;

/**
 * Created by dan on 15/02/18.
 * Evidently.
 */

public class DemoActivity extends AppCompatActivity {
  private static final Logger log = LoggerFactory.getLogger(DemoActivity.class);

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);

  }

  @Override
  protected void onStart() {
    super.onStart();

    Toast.makeText(this, "Test message is : " + Test.getMessage(), Toast.LENGTH_SHORT).show();

    Logger log = LoggerFactory.getLogger(DemoActivity.class);

    log.trace("onStart() trace");
    log.debug("onStart() debug");
    log.info("onStart() info");
    log.warn("onStart() warn");
    log.error("onStart() error");

    log = LoggerFactory.getLogger("package1.Class1");
    log.debug("package1.Class1 debug");
    log.info("package1.Class1 info");
    log.warn("package1.Class1 warn");


    log = LoggerFactory.getLogger("package1.Class2");
    log.debug("package1.Class2 debug");
    log.info("package1.Class2 info");
    log.warn("package1.Class2 warn");


    log = LoggerFactory.getLogger("package2");
    log.debug("package2 debug");
    log.info("package2 info");
    log.warn("package2 warn");


  }
}


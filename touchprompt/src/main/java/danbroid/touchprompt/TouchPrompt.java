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

package danbroid.touchprompt;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * Created by dan on 16/02/18.
 */

public class TouchPrompt {
  private static final org.slf4j.Logger
      log = org.slf4j.LoggerFactory.getLogger(TouchPrompt.class);


  private TouchPromptImpl impl;
  private static final long SHORT_DELAY = 800;
  protected String singleShotID;
  private TouchPrompt next;
  private static TouchPrompt ACTIVE_PROMPT;
  private static Handler handler = new Handler();

  public static final String PREFS = "touch_prompt";

  public static final SharedPreferences getPrefs(Context context) {
    return context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
  }

  public static Class<? extends TouchPromptImpl> IMPLEMENTATION;


  public static boolean SHOW_ALL = false;

  public TouchPrompt(Activity activity) {
    if (IMPLEMENTATION == null)
      throw new IllegalArgumentException("IMPLEMENTATION not set");

    try {
      impl = IMPLEMENTATION.getConstructor(TouchPrompt.class, Activity.class)
          .newInstance(this, activity);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }


  public void close() {
    impl.close();
  }

  public TouchPrompt setPrimaryText(CharSequence primaryText) {
    impl.primaryText = primaryText;
    return this;
  }

  public TouchPrompt setPrimaryText(@StringRes int stringID) {
    impl.primaryTextID = stringID;
    return this;
  }

  public TouchPrompt setSecondaryText(CharSequence secondaryText) {
    impl.secondaryText = secondaryText;
    return this;
  }

  public TouchPrompt setSecondaryText(@StringRes int stringID) {
    impl.secondaryTextID = stringID;
    return this;
  }

  public TouchPrompt setTarget(float left, float top) {
    impl.left = left;
    impl.top = top;
    return this;
  }

  public TouchPrompt setTarget(@IdRes int targetID) {
    impl.targetID = targetID;
    return this;
  }

  public TouchPrompt setTarget(View target) {
    impl.target = target;
    return this;
  }

  public TouchPrompt setDelay(long delay) {
    impl.delay = delay;
    return this;
  }

  public TouchPrompt setSingleShotID(String id) {
    singleShotID = id;
    return this;
  }

  public TouchPrompt setSingleShotID(Enum id) {
    return setSingleShotID(id.name());
  }

  public TouchPrompt setShortDelay() {
    return setDelay(SHORT_DELAY);
  }

  public TouchPrompt show() {
    if (singleShotID != null && !SHOW_ALL &&
        !getPrefs(impl.activity).getBoolean(singleShotID, true)) {
      showNext();
      return this;
    }

    if (impl.delay != 0L) {
      handler.postDelayed(() -> show2(), impl.delay);
    } else {
      show2();
    }
    return this;
  }

  private void show2() {
    if (ACTIVE_PROMPT != null) {
      log.trace("ACTIVE PROMPT EXISTS");
      ACTIVE_PROMPT.append(this);
      return;
    }

    if (!onBeforeShow()) {
      showNext();
      return;
    }

    impl.show();
  }

  private void showNext() {
    if (next != null) {
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          if (next != null) next.show();
        }
      }, SHORT_DELAY);
    }
  }

  private void append(TouchPrompt touchPrompt) {
    if (next == null) next = touchPrompt;
    else next.append(touchPrompt);
  }

  public static void closeChain() {
    if (ACTIVE_PROMPT != null) {
      ACTIVE_PROMPT.next = null;
      ACTIVE_PROMPT.close();
      ACTIVE_PROMPT = null;
    }
  }

  protected void onShown() {
    ACTIVE_PROMPT = this;
    if (singleShotID != null)
      getPrefs(impl.activity).edit().putBoolean(singleShotID, false).apply();
  }

  protected void onClosed() {
    ACTIVE_PROMPT = null;
    showNext();
  }

  protected boolean onBeforeShow() {
    return true;
  }
}

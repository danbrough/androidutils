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
import android.view.View;

/**
 * Created by dan on 7/06/17.
 */

 abstract class AbstractTouchPromptImpl {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractTouchPromptImpl.class);

  protected CharSequence primaryText;
  protected CharSequence secondaryText;
  protected Activity activity;
  protected float left = -1;
  protected float top = -1;
  protected int targetID;
  protected View target;
  protected long delay = 0L;
  protected int primaryTextID = 0;
  protected int secondaryTextID = 0;
  protected final TouchPrompt touchPrompt;


  protected AbstractTouchPromptImpl(TouchPrompt touchPrompt, Activity activity) {
    this.activity = activity;
    this.touchPrompt = touchPrompt;
  }


  protected abstract void show();

  public abstract void close();

  protected final void onClosed() {
    touchPrompt.onClosed();
  }


}

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

/**
 * Created by dan on 7/06/17.
 */

class TouchPromptImpl extends AbstractTouchPromptImpl {

  public TouchPromptImpl(TouchPrompt touchPrompt, Activity activity) {
    super(touchPrompt, activity);
  }

  @Override
  public void close() {
    throw new UnsupportedOperationException();
  }

  @Override
  protected void show() {
    throw new UnsupportedOperationException();
  }
}

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

package danbroid.touchprompt.material;

import android.app.Activity;
import android.widget.Toast;

import danbroid.touchprompt.TouchPrompt;
import danbroid.touchprompt.TouchPromptImpl;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Created by dan on 7/06/17.
 */

public class MaterialTouchPrompt extends TouchPromptImpl {


  public static void install() {
    TouchPrompt.IMPLEMENTATION = MaterialTouchPrompt.class;
  }

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TouchPromptImpl.class);

  private MaterialTapTargetPrompt prompt;

  public MaterialTouchPrompt(TouchPrompt touchPrompt, Activity activity) {
    super(touchPrompt, activity);
  }


  @Override
  public void close() {
    if (prompt != null) {
      prompt.finish();
      prompt = null;
    }
  }

  @Override
  protected void show() {
    log.trace("show()");

    MaterialTapTargetPrompt.Builder builder = new MaterialTapTargetPrompt.Builder(activity);

    if (primaryTextID != 0) {
      builder.setPrimaryText(primaryTextID);
    } else {
      builder.setPrimaryText(primaryText.toString());
    }

    if (secondaryTextID != 0) {
      builder.setSecondaryText(secondaryTextID);
    } else {
      builder.setSecondaryText(secondaryText.toString());
    }

    if (left != -1f) {
      builder.setTarget(left, top);
    } else if (targetID != 0) {
      builder.setTarget(targetID);
    } else if (target != null) {
      builder.setTarget(target);
    }

    builder.setAutoDismiss(true);
    builder.setAutoFinish(true);
    builder.setCaptureTouchEventOutsidePrompt(true);
    builder.setCaptureTouchEventOnFocal(false);

    builder.setPromptStateChangeListener((materialTapTargetPrompt, state) -> {


      switch (state) {
        case MaterialTapTargetPrompt.STATE_DISMISSED:
          log.trace("STATE_DISMISSED");
          break;
        case MaterialTapTargetPrompt.STATE_DISMISSING:
          log.trace("STATE_DISMISSING");
          onClosed();
          break;
        case MaterialTapTargetPrompt.STATE_FINISHED:
          log.trace("STATE_FINISHED");
          break;
        case MaterialTapTargetPrompt.STATE_REVEALED:
          log.trace("STATE_REVEALED");
          break;
        case MaterialTapTargetPrompt.STATE_REVEALING:
          log.trace("STATE_REVEALING");
          break;
      }
    });


    if (!builder.isTargetSet()) {
      if (BuildConfig.DEBUG) {
        Toast.makeText(activity, "Target not set :" + this, Toast.LENGTH_SHORT).show();
      } else {
        log.error("target not set");
      }
      return;
    }

    prompt = builder.show();

    if (prompt != null) {
      onShown();
    } else {
      log.error("prompt failed to show");
    }

  }


}

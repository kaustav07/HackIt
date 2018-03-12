package com.madcoders.chatterjeekaustav.hackit;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

/**
 * Created by Kaustav on 06-03-2018.
 */

public class MyAccessibilityService extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if(event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED){
            AccessibilityNodeInfo source = event.getSource();
            if (source.getText().toString().equals("Android")) {
                Bundle arguments = new Bundle();
                arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
                        "Hacked");
                source.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT,arguments);
            }
        }
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Toast.makeText(this,"Replacement hack started",Toast.LENGTH_SHORT).show();
    }
}

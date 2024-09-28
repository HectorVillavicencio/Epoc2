package com.example.epoc2.keyboard;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardManager {

    private final Context context;

    public KeyboardManager(Context context) {
        this.context = context;
    }

    public void closeKeyboard(View view) {
        if (view != null) {
            InputMethodManager inm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

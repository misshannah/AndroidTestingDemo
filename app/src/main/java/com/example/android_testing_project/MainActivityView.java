package com.example.android_testing_project;

public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);
}

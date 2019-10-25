package com.example.android_testing_project;

import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }


    @Test
    public  void editTextUpdatesTextView() throws Exception {
        //Arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        //Act
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        //Assert
        String actualString = activity.textView.getText().toString();
        assertEquals(givenString, actualString);

    }

}

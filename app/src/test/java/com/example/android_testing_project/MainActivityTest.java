package com.example.android_testing_project;

import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setup() {
        activity = new MainActivity();
        activity.onCreate(null);
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

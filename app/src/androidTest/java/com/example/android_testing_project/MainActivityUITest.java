package com.example.android_testing_project;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;

import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new
            ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        //Using a view matcher to an action
        onView(withId(R.id.editText)).perform(typeText(givenString));
        // Act
        onView(withId(R.id.editText)).perform(pressImeActionButton());

        // Assert
        onView(withId(R.id.textView)).check(matches(withText(givenString)));

    }


    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        final int givenColor = Color.GREEN;
        String spinnerItemText = "Green";

        // Act
        onView(withId(R.id.colorSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(spinnerItemText))).perform(click());

        // Assert
        BoundedMatcher backgroundColorMatcher = new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
            @Override
            protected boolean matchesSafely(LinearLayout linearLayout) {
                int actualColor = ((ColorDrawable)linearLayout.getBackground()).getColor();

                return givenColor == actualColor;
            }

            @Override
            public void describeTo(Description description) {
                    description.appendText("Background color should equal: " + givenColor);
            }
        };
        onView(withId(R.id.linearLayout)).check(matches(backgroundColorMatcher));


    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        String otherActivityString = "Other Activity";

        // Act
        onView(withId(R.id.launchActivityButton)).perform(click());

        // Assert
        onView(withText(otherActivityString)).check(matches(notNullValue()));

    }
}

package com.example.android_testing_project;


import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)

public class MainActivityPresenterTest {
    MainActivityPresenter presenter;

    @Mock
    MainActivityView view;


    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() {
        //Arrange
        String givenString = "test123";

        //Act
        presenter.editTextUpdated(givenString);

        //Assert
        Mockito.verify(view).changeTextViewText(givenString);
    }

    @Test
    public void colorSelected() {
        //Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        //Act
        presenter.colorSelected(index);

        //Assert
        Mockito.verify(view).changeBackgroundColor(givenColor);
    }

    @Test
    public void launchOtherActivityButtonClicked() {

        //Arrange
        Class clazz = OtherActivity.class;

        //Act
        presenter.launchOtherActivityButtonClicked(clazz);
        //Assert
        Mockito.verify(view).launchOtherActivity(clazz);
    }
}
package it.feio.android.omninotes.helpers;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

import it.feio.android.omninotes.MainActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class EspressoTestBase {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
}

package it.feio.android.omninotes.Helpers;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import it.feio.android.omninotes.MainActivity;

public class StartTheApplication {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
}

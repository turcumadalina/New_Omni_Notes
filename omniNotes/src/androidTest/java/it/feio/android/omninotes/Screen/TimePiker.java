package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.EspressoMethods;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class TimePiker {
    public static void clickOnAddReminderButton() {
        HelpersMethods.clickAction(withId(R.id.datetime));
    }

    public static void clickOnTimePikerDoneButton() {
        HelpersMethods.clickAction(withId(R.id.done));
    }

    public static boolean isTimePikerVisible() {
        return HelpersMethods.isVisible(withId(R.id.time_picker_dialog));
    }

    public static void swipeRightTheRepeatWeeklyButton() {
        HelpersMethods.swipeRightAction(withId(R.id.repeat_switch));
    }

    public static boolean isIntervalInTheLeftOfWeekText() {
        return HelpersMethods.isFirstObjectToTheLeftOfSecondObject(withId(R.id.interval), withId(R.id.intervalPostText));
    }

    public static boolean isIntervalInTheRightOfEveryText() {
        return HelpersMethods.isFirstObjectToTheRightOfSecondObject(withId(R.id.interval), withId(R.id.intervalPreText));
    }

    public static void clickOnFridayButton() {
        HelpersMethods.clickAction(EspressoMethods.childAtPosition(withId(R.id.weekGroup2), 1));
    }

    public static boolean reminderSetIsVisible() {
        return HelpersMethods.isVisible(withId(R.id.snackbar_placeholder));
    }

    public static void clickOnClockDoneButton() {
        HelpersMethods.clickAction(withId(R.id.done_button));
    }

    public static void clickOnAnyDayFromTimePiker() {
        HelpersMethods.clickAction(EspressoMethods.childAtPosition(withId(R.id.animator), 0));
    }
}

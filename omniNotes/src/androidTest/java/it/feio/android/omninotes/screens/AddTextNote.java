package it.feio.android.omninotes.screens;

import android.view.View;

import org.hamcrest.Matcher;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.EspressoMatchers;
import it.feio.android.omninotes.helpers.HelperMethods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;

public class AddTextNote {

    public static void clickTitleContainer() {
        HelperMethods.performClick(withId(R.id.detail_title));
    }

    public static void typeDoctorAppointment() {
        HelperMethods.typeSomeText(withId(R.id.detail_title), Constants.DOCTOR_APPOINTMENT);
    }

    public static void clickContentContainer() {
        HelperMethods.performClick(withId(R.id.detail_content));
    }

    public static void typeDateAndTime() {
        HelperMethods.typeSomeTextANoOfTimes(withId(R.id.detail_content), Constants.TUESDAY_17_JUL_2018_18_30, 3);
    }

    public static void clickAddReminder() {
        HelperMethods.performClick(withId(R.id.datetime));
    }

    public static void clickDone() {
        HelperMethods.performClick(withId(R.id.done));
    }

    public static boolean isTimePickerDisplayed() {
        return HelperMethods.isObjectDisplayed(withId(R.id.time_picker_dialog));
    }

    public static void clickDoneButton() {
        HelperMethods.performClick(withId(R.id.done_button));
    }

    public static void enableRepeatWeekly() {
        HelperMethods.performClick(withId(R.id.repeat_switch));
    }

    public static boolean isWeekNoRightOfEveryText() {
        return HelperMethods.isFirstObjectRightOfSecondObject(withId(R.id.interval), withId(R.id.intervalPreText));
    }

    public static boolean isWeekNoLeftOfWeekText() {
        return HelperMethods.isFirstObjectLeftOfSecondObject(withId(R.id.interval), withId(R.id.intervalPostText));
    }

    public static void clickFriday() {
        HelperMethods.performClick(EspressoMatchers.nthChildOf(withId(R.id.weekGroup2), 1));
    }

    public static void clickBackButton() {
        HelperMethods.performClick(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static boolean isContentBoxDescendantOfLinearLayout() {
        Matcher<View> addReminder = allOf(withId(R.id.detail_content), isDescendantOfA(withParent(withParent(withParent(withId(R.id.content_wrapper))))));
        return HelperMethods.isObjectDisplayed(addReminder);
    }

    public static boolean isAddReminderDescendantOfLinearLayout() {
        Matcher<View> addReminder = allOf(withId(R.id.datetime), isDescendantOfA(withId(R.id.reminder_layout)));
        return HelperMethods.isObjectDisplayed(addReminder);
    }

    public static boolean isContentParentSiblingWithAddReminderParent() {
        Matcher<View> contentSiblingAddReminder = allOf(withChild(withId(R.id.detail_content)), hasSibling(withId(R.id.reminder_layout)));
        return HelperMethods.isObjectDisplayed(contentSiblingAddReminder);
    }

    public static void clickOnADay() {
        EspressoMatchers.clickXYCoordinates(900, 1800);
    }

    public static int getExpectedTextSizeOfContentContainer() {
        return EspressoMatchers.getTextSize(withId(R.id.detail_content));
    }

    public static boolean isFontSizeOfContentContainerExpectedSize() {
        return HelperMethods.isFontSizeExpectedSize(withId(R.id.detail_content), 16);
    }

    public static int getExpectedNoOfLinesOfContentContainer() {
        return EspressoMatchers.getTextLineNo(withId(R.id.detail_content));
    }

    public static boolean isContentContainerTextOnExpectedNoOfLines() {
        return HelperMethods.isNoOfLinesExpectedSize(withId(R.id.detail_content), 2);
    }

    public static void typePayTheBills() {
        HelperMethods.typeSomeTextANoOfTimes(withId(R.id.detail_content), Constants.PAY_THE_BILLS, 1);
    }

    public static void clickCollapseButton() {
        HelperMethods.performClick(withContentDescription(Constants.COLLAPSE));
    }

    public static void add5ItemsOneIsASpecialItem() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Home.clickAddButton();
            Home.clickTextNoteButton();
            if (i == 4) {
                HelperMethods.typeSomeText(withId(R.id.detail_title), Constants.MY_NOTE);
            } else {
                HelperMethods.typeSomeText(withId(R.id.detail_title), EspressoMatchers.generateRandomString(7));
            }
            AddTextNote.clickBackButton();
            Thread.sleep(1000);
        }
    }
}
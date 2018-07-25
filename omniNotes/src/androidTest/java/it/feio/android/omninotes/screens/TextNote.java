package it.feio.android.omninotes.screens;

import android.widget.LinearLayout;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.EspressoMatchers;
import it.feio.android.omninotes.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class TextNote {

    // This is for Hamburger functionality test
    public static void addPayTheBillsNoteTitle() {
        HelpersMethods.typeItemText(withId(R.id.detail_title), Constants.PAY_THE_BILLS);
    }

    public static void addPayBillsNoteContent() {
        HelpersMethods.addItemsContent(withId(R.id.detail_content), 4);
    }

    public static void clickReturnButton() {
        HelpersMethods.clickUIElement(withContentDescription(Constants.DRAWER_OPEN));
    }

    // This is for Appointment details test
    public static boolean isContentAndAddReminderBoxesDescendantsOfALinearLayout() {
        return HelpersMethods.isUIObjectDisplayed(allOf(withId(R.id.detail_content), isDescendantOfA(is(instanceOf(LinearLayout.class))))) &&
                HelpersMethods.isUIObjectDisplayed(allOf(withId(R.id.datetime), isDescendantOfA(is(instanceOf(LinearLayout.class)))));
    }

    public static boolean isContentAndAddReminderParentsSibling() {
        return HelpersMethods.isUIObjectDisplayed(allOf(withChild(withId(R.id.detail_content)), hasSibling(withId(R.id.reminder_layout))));
    }

    public static void addTextNoteWithTitleDoctorAppointment() {
        HelpersMethods.typeItemText(withId(R.id.detail_title), Constants.DOCTOR_APPOINTMENT_TITLE);
    }

    public static void addTextNoteWithContentTuesday17Jul2018_18_30() {
        HelpersMethods.typeItemText(withId(R.id.detail_content), Constants.TUESDAY_17_Jul_2018_18_30);
    }

    public static void addReminderToTheTextNoteWithTitleDoctorAppointment() {
        HelpersMethods.clickUIElement(withId(R.id.datetime));
    }

    public static void clickOnReminderDay() {
        EspressoMatchers.clickUIObjectOnCoordinates(340, 830);
    }

    public static void clickDoneButton() {
        HelpersMethods.clickUIElement(withId(R.id.done));
    }

    public static void clickDoneButtonAfterCheckingTimePikerVisibility() {
        HelpersMethods.clickUIElement(withId(R.id.done_button));
    }

    public static boolean isTimePikerDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withId(R.id.time_picker_dialog));
    }

    public static void clickRepeatWeeklyButton() {
        HelpersMethods.clickUIElement(withId(R.id.repeat_switch));
    }

    public static boolean isNumberOfWeeksOnTheRightOfEveryText() {
        return HelpersMethods.isUIObjectRightOfAnotherUIObject(withId(R.id.interval), withId(R.id.intervalPreText));
    }

    public static boolean isNumberOfWeeksOnTheLeftOfWeekText() {
        return HelpersMethods.isUIObjectLeftOfAnotherUIObject(withId(R.id.interval), withId(R.id.intervalPostText));
    }

    public static void clickOnFridayButton() {
        HelpersMethods.clickUIElement(withText(Constants.FRIDAY));
    }
}
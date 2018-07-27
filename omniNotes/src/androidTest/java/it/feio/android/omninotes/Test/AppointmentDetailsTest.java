package it.feio.android.omninotes.Test;

import org.junit.Test;

import it.feio.android.omninotes.Helpers.StartTheApplication;
import it.feio.android.omninotes.Screen.Home;
import it.feio.android.omninotes.Screen.TextNote;
import it.feio.android.omninotes.Screen.TimePiker;

import static junit.framework.Assert.assertTrue;

public class AppointmentDetailsTest extends StartTheApplication {

    @Test
    public void testAppointmentDetails() throws InterruptedException {
        // Step 1. Start the app.

        // Expected Result: Image with "Nothing here!" is displayed and clickable.
        assertTrue("Image with \"Nothing here!\" text is not displayed.", Home.isNothingHereTextVisible());
        assertTrue("Image with \"Nothing here!\" text is not clickable.", Home.isNothingHereTextClickable());

        // Expected Result: "Add" button is displayed and clickable.
        assertTrue("Add button is not displayed.", Home.isAddButtonVisible());
        assertTrue("Add button is not clickable.", Home.isAddButtonClickable());

        // Step 2. Click "Add" button
        Home.clickAddButton();

        // Expected Result: Test "Checklist" is between 2 other texts.
        assertTrue("Text \"Checklist\" is not above Text note text.", TextNote.isChecklistTextAboveTextNoteText());
        assertTrue("Text \"Checklist\" is not below Photo Text.", TextNote.isChecklistTextBelowPhotoText());

        // Expected Result: The suggestive picture of "Photo" text is above "Checklist" suggestive picture.
        assertTrue("The suggestive picture of \"Photo\" text is NOT above \"Checklist\" suggestive picture.", Home.isSuggestivePictureOfPhotoAboveChecklistSuggestivePicture());

        // Step 3. Click "Text note" button.
        TextNote.clickTextNoteButton();

        // Expected Result: "Content" and "Add reminder" are descendent of a LinearLayout and their parents are siblings.
        assertTrue("\"Content\" is NOT a descendant of a LinearLayout.", Home.isContentBoxDescendantOfALinearLayout());
        assertTrue("\"Add reminder\" is NOT a descendant of a LinearLayout.", Home.isAddReminderDescendantOfALinearLayout());
        assertTrue("The \"Content parent and the \"Add reminder\" parent are NOT siblings.", Home.isContentParentSiblingWithAddReminder());

        // Step 4. Click "Title" container and Type "Doctor appointment".
        TextNote.clickTitleBox();
        TextNote.typeAppointmentName();

        // Step 5. Click "Content" container and type " Tuesday, 17 Jul 2018, 18:30.".
        TextNote.clickContentBox();
        TextNote.typeAppointmentContent();

        // Step 6. Click on "Add reminder" and Add a reminder for the date from "Content" container.
        TimePiker.clickOnAddReminderButton();
        TimePiker.clickOnAnyDayFromTimePiker();

        // Step 7. Click "Done" button.
        TimePiker.clickOnTimePikerDoneButton();

        // Expected Result: The "Time picker" is displayed.
        assertTrue("The \"Time picker\" is NOT displayed.", TimePiker.isTimePikerVisible());

        // Step 8. Click "Done" button.
        TimePiker.clickOnClockDoneButton();

        // Step 9. Swipe the "repeat weekly" button.
        TimePiker.swipeRightTheRepeatWeeklyButton();

        // Expected Result: The number of weeks is between 2 texts.
        assertTrue("The interval is NOT in the left of \"week\" text.", TimePiker.isIntervalInTheLeftOfWeekText());
        assertTrue("The interval is NOT in the right of \"Every\" text.", TimePiker.isIntervalInTheRightOfEveryText());

        // Step 10. Click on "Friday" button.
        TimePiker.clickOnFridayButton();

        // Step 11. Click on "Done" button.
        TimePiker.clickOnTimePikerDoneButton();

        // Step 12. Press back.
        TextNote.clickReturnButton();
        Thread.sleep(2000);

        // Expected Result: Reminder set is displayed.
        assertTrue("Reminder set is NOT displayed.", TimePiker.reminderSetIsVisible());
    }
}

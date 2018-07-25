package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.AddTextNote;
import it.feio.android.omninotes.screens.Home;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AppointmentDetailsTest extends EspressoTestBase {

    @Test
    public void appointmentDetails() {
        // Step: Start the app

        // Verify: Image with "Nothing here" is displayed and clickable
        assertTrue("NothingHere is not displayed", Home.isNothingHereDisplayed());
        assertTrue("NothingHere is not clickable", Home.isNothingHereClickable());

        // Verify "Add" button is displayed and clickable
        assertTrue("Add button is not displayed", Home.isAddButtonDisplayed());
        assertTrue("Add button is not clickable", Home.isAddButtonClickable());

        // Step: Click "Add" button
        Home.clickAddButton();

        // Verify: Test "Checklist" is between 2 other texts
        assertTrue("CheckList is not above TextNote", Home.isCheckListAboveTextNote());
        assertTrue("CheckList is not Below Photo", Home.isCheckListBelowPhoto());

        // Verify: The suggestive picture of "Photo" text is above "Checklist" suggestive picture
        assertTrue("PicturePhoto is not above PictureCheckList", Home.isPicturePhotoAbovePictureCheckList());

        // Step: Click "Text note" button
        Home.clickTextNoteButton();

        // Verify: "Content" and "Add reminder" are descendant of a LinearLayout and they are siblings
        assertTrue("Content is not descendant of Linear Layout", AddTextNote.isContentBoxDescendantOfLinearLayout());
        assertTrue("Add Reminder is not descendant of Linear Layout", AddTextNote.isAddReminderDescendantOfLinearLayout());
        assertTrue("Content and Add reminder are not siblings", AddTextNote.isContentParentSiblingWithAddReminderParent());

        // Verify: "Content Container text has a font size of 16sp;
        assertEquals("Content text doesn't have a 16sp font size", 16, AddTextNote.getExpectedTextSizeOfContentContainer());
        //Same result, different approach
        assertTrue("Content text doesn't have a 16sp font size", AddTextNote.isFontSizeOfContentContainerExpectedSize());

        // Step: Click "Title" container
        AddTextNote.clickTitleContainer();

        // Step: Type "Doctor appointment"
        AddTextNote.typeDoctorAppointment();

        // Step:Click "Content" container
        AddTextNote.clickContentContainer();

        // Step: Type "Tuesday, 17 Jul 2018, 18:30." 3 times
        AddTextNote.typeDateAndTime();

        //Verify: Content container has 2 lines of text
        assertEquals("Content container doesn't have 2 lines of text", 2, AddTextNote.getExpectedNoOfLinesOfContentContainer());
        //Same result, different approach
        assertTrue("Content container doesn't have 2 lines of text", AddTextNote.isContentContainerTextOnExpectedNoOfLines());

        // Step: Click on "Add reminder"
        AddTextNote.clickAddReminder();

        // Step: Add a reminder for the date from "Content" container
        AddTextNote.clickOnADay();

        // Step: Click "Done" button
        AddTextNote.clickDone();

        // Verify: The "Time picker" is displayed
        assertTrue("Time picker is not displayed", AddTextNote.isTimePickerDisplayed());

        // Step: Click "Done" button
        AddTextNote.clickDoneButton();

        // Step: Swipe the "repeat weekly" button
        AddTextNote.enableRepeatWeekly();

        // Verify: The number of weeks is between 2 texts
        assertTrue("The number of weeks is not right of EveryText", AddTextNote.isWeekNoRightOfEveryText());
        assertTrue("The number of weeks is not left of WeekTest", AddTextNote.isWeekNoLeftOfWeekText());

        // Step: Click on "Friday" button
        AddTextNote.clickFriday();

        // Step: Click on "Done" button
        AddTextNote.clickDone();

        // Step: Press back
        AddTextNote.clickBackButton();

        // Verify: Reminder set is displayed
        assertTrue("Reminder set is not displayed", Home.isReminderSetDisplayed());
    }
}
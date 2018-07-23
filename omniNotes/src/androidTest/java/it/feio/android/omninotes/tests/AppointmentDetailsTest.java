package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.Home;
import it.feio.android.omninotes.screens.TextNote;

import static junit.framework.Assert.assertTrue;

public class AppointmentDetailsTest extends EspressoTestBase {

    @Test
    public void testAppointmentDetails() {
        // Verify: Image with "Nothing here!" is displayed and clickable.
        assertTrue("Image with nothing here text is not visible", Home.isImageWithNothingHereTextDisplayed());
        assertTrue("Image with nothing here text is not clickabe", Home.isImageWithNothingHereTexClickable());

        // Verify: Add button is displayed and clickable.
        assertTrue("Add button is not displayed", Home.isAddButtonDisplayed());
        assertTrue("Add button is not clickable", Home.isAddButtonClickable());

        // Click "Add" button
        Home.clickAddButton();

        // Verify: Checklist button is between Photo and Text note buttons.
        assertTrue("Checklist button is not below Photo button", Home.isChecklistButtonBelowPhotoButton());
        assertTrue("Checklist button is not above Photo button", Home.isChecklistButtonAboveTextNoteButton());

        // Verify: The suggestive picture of "Photo" text is above "Checklist" suggestive picture.
        assertTrue("Photo button image is not above Checklist button image", Home.isPhotoButtonImageAboveChecklistButtonImage());

        // Step: Click Text note button.
        Home.clickTextNoteButton();

        // Verify: "Content" and "Add reminder" are descendent of a LinearLayout and their parents are siblings.
        assertTrue("Content and Add reminder are not descendents of a LynearLayout", TextNote.isContentAndAddReminderBoxesDescendantsOfALinearLayout());
        assertTrue("", TextNote.isContentAndAddReminderParentsSibling());

        // Step: Add Text note with title Doctor appointment
        TextNote.addTextNoteWithTitleDoctorAppointment();

        // Step: Add content to the Text note with title Doctor appointment
        TextNote.addTextNoteWithContentTuesday17Jul2018_18_30();

        // Step: Click on Add reminder button and add a reminder for the date from "Content" container.
        TextNote.addReminderToTheTextNoteWithTitleDoctorAppointment();
        // more on hear

        // Step: Click Done button after setting the reminder
        TextNote.clickReminderDoneButton();

        // Verify: The "Time picker" is displayed.
        assertTrue("The Time piker is not visible", TextNote.isTimePikerDisplayed());

        // Step: Click Done button after checking the Time piker visibility
        TextNote.clickDoneButtonAfterCheckingTimePikerVisibility();

        // Step: Switch on Repeat weekly button
        TextNote.clickRepeatWeeklyButton();

        // Verify: The number of weeks is between Every and Week texts.
        assertTrue("", TextNote.isNumberOfWeeksOnTheRightOfEveryText());
        assertTrue("", TextNote.isNumberOfWeeksOnTheLeftOfWeekText());

        // Step: Click on "Friday" buttton.
        TextNote.clickOnFridayButton();
    }
}
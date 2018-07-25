package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.AddTextNote;
import it.feio.android.omninotes.screens.Home;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class HamburgerTest extends EspressoTestBase {

    @Test
    public void HamburgerViewTest() throws InterruptedException {
        // Step: Click on Add button
        Home.clickAddButton();

        // Step: Click on Text Note button
        Home.clickTextNoteButton();

        // Step: Add note with title "Pay the bills"
        AddTextNote.typePayTheBills();

        // Step: Click return button
        AddTextNote.clickBackButton();

        // Step: Delete (swipe) the note with title "Pay the bills"
        Home.deletePayTheBillsNote();

        // Step: Click on hamburger
        AddTextNote.clickBackButton();

        // Verify: The button with name Archive is displayed and has sibling the button with name Notes
        assertTrue("The button with name Archive is not displayed", Home.isArchiveButtonDisplayed());
        assertTrue("The button with name Archive doesn't have sibling the button with name Notes", Home.isArchiveButtonSiblingWithNotesButton());

        // Step: Click on Archive button
        Home.clickArchiveButton();

        // Verify: Note with title "Pay the bills" is displayed
        assertTrue("Note with title \"Pay the bills\" is not displayed", Home.isReminderSetDisplayed());

        // Step: Delete (swipe) the note with title "Pay the bills"
        Home.deletePayTheBillsNote();

        // Wait 3 seconds
        Thread.sleep(3000);

        // Step: Click on hamburger
        AddTextNote.clickBackButton();

        // Verify: The button with name Trash is displayed //???below the button with name Notes
        assertTrue("The button with name Trash is not displayed", Home.isTrashButtonDisplayed());

        // Verify: The button with name Archive is NOT displayed
        assertFalse("The button with name Archive is displayed", Home.isArchiveButtonDisplayed());

        // Step: Click on Trash button
        Home.clickTrashButton();

        // Verify: Note with title "Pay the bills" is displayed"
        assertTrue("Note with title \"Pay the bills\" is not displayed", Home.isReminderSetDisplayed());

        // Verify: List View has one child
        assertEquals("List View doesn't have one child", 1, Home.getListViewNoOfChildren());

        // Step: Click More option
        Home.clickMoreOptions();

        // Step: Click Empty trash button
        Home.clickEmptyTrash();

        // Step: Click Button with text OK
        Home.clickOKButton();

        // Step: Note with title "Pay the bills" is NOT displayed"
        assertFalse("Note with title \"Pay the bills\" is not displayed", Home.isReminderSetDisplayed());
    }
}
package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.Archives;
import it.feio.android.omninotes.screens.Home;
import it.feio.android.omninotes.screens.NavigationDrawer;
import it.feio.android.omninotes.screens.TextNote;
import it.feio.android.omninotes.screens.Trash;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class HamburgerTest extends EspressoTestBase {

    @Test
    public void testHamburgerValidation() throws InterruptedException {
        // Step: Click Add button
        Home.clickAddButton();

        // Step: Click Text Note button
        Home.clickTextNoteButton();

        // Step: Add note with title "Pay the bills"
        TextNote.addPayTheBillsNoteTitle();

        // Step: Add content to the note with title "Pay the bills"
        TextNote.addPayBillsNoteContent();

        // Step: Click return button
        TextNote.clickReturnButton();

        // Verify: Note content description has 2 lines of text
        assertTrue("Note content description has more/less text lines", Home.isNoteContentTextLines());

        // Verify: Number of text lines from Note content desctiption
        assertEquals("There is not expected number of text lines ", 2, Home.getNoOfTextLines());

        // Step: Delete the note with title "Pay the bills"
        Home.deleteNoteWithTitlePayTheBills();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Step: Click on hamburger button
        Home.clickOnHamburgerButton();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Verify: The button with name Archive is displayed and has sibling the button with name Notes
        assertTrue("Archive button is not displayed and is not sibling with Notes button", NavigationDrawer.isArchiveButtonDisplayedAndHasSiblingTheNoteButton());

        // Step: Click on Archive button
        NavigationDrawer.clickOnArchiveButton();

        // Verify: Note with title "Pay the bills" is displayed"
        assertTrue("Note with text Pay the bills is not displayed", Archives.isNoteWithTextPayTheBillsDisplayed());

        // Step: Delete the note with title "Pay the bills" from archives
        Archives.removeNoteWithTitlePayTheBills();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Step: Click on hamburger button
        Home.clickOnHamburgerButton();

        // Wait 2 seconds
        Thread.sleep(3000);

        // Verify: The button with name Trash is displayed below the button with name Notes
//        assertTrue("Trash button is not below Notes button", NavigationDrawer.isButtonWithNameTrashDisplayedBelowTheButtonWithNameNotes());

        // Verify: The button with name Archive is NOT displayed on navigation drawer
        assertFalse("Archive button is still displayed on navigation drawer", NavigationDrawer.isArchiveButtonOnNavigationDrawer());

        // Step: Click on trash button
        NavigationDrawer.clickOnTrashButton();

        // Verify: Note with title Pay the bills is displayed on Trash
        assertTrue("Note with title Pay the bills is displayed on Trash is not displayed", Trash.isNoteWithTitlePayTheBillsDisplayed());

        // Verify: List View has one child
        assertEquals("List View has more/less then one child", 1, Trash.isListViewWithOneItem());

        // Step: Click on more options button
        Trash.clickOnMoreOptionButton();

        // Step: Click on empty trash button
        Trash.clickOnEmptyTrashButton();

        // Step: Click ok button
        Trash.clickOkButton();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Verify: Note with title Pay the bills is NOT displayed"
        assertFalse("Note with title pay the bills is still visible", Trash.isNoteWithTitlePayTheBillsDisplayed());
    }
}
package it.feio.android.omninotes.Test;

import org.junit.Test;

import it.feio.android.omninotes.Helpers.EspressoMethods;
import it.feio.android.omninotes.Helpers.StartTheApplication;
import it.feio.android.omninotes.R;
import it.feio.android.omninotes.Screen.Archive;
import it.feio.android.omninotes.Screen.Home;
import it.feio.android.omninotes.Screen.TextNote;
import it.feio.android.omninotes.Screen.Trash;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class HamburgerTest extends StartTheApplication {
    @Test
    public void testHamburgerValidation() throws InterruptedException {
        // Step 1. Click on Add button
        Home.clickAddButton();

        // Step 2. Click on Text Note button
        Home.clickTextNoteButton();

        // Step 3. Add note with title "Pay the bills"
        TextNote.typePayTheBillsText();

        // Step 4. Click return button
        TextNote.clickReturnButton();

        // Step 5. Delete (swipe) the note with title "Pay the bills"
        TextNote.deleteTheNote();

        // Step 6. Click on hamburger
        TextNote.clickHamburgerButton();

        // Expected Result: The button with name Archive is displayed and has sibling the button with name Notes
        assertTrue("The button with name\"Archive\" is NOT displayed.", Home.isArchiveTextVisible());
        assertTrue("The \"Archive\" button is NOT sibling with \"Notes\" button.", Home.isArchiveButtonSiblingWithNotesButton());

        // Step 7. Click on Archive button
        Home.clickArchiveButton();

        // Expected Result: Note with title "Pay the bills" is displayed"
        assertTrue("Note with title \"Pay the bills\" is NOT displayed.", Archive.isPayTheBillsTextVisible());

        // Step 8. Delete (swipe) the note with title "Pay the bills"
        Archive.deleteTheNote();

        //Wait 2 seconds
        Thread.sleep(2000);

        // Step 9. Click on hamburger
        Archive.clickHamburgerButton();

        // Expected Result: The button with name Trash is displayed below the button with name Notes -> PASS

        // Expected Result: The button with name Archive is NOT displayed
        assertFalse(" The button with name \"Archive\" is displayed.", Home.isArchiveTextVisible());

        // Step 10. Click on Trash button
        Home.clickTrashButton();

        // Expected Result: Note with title "Pay the bills" is displayed"
        assertTrue("Note with title \"Pay the bills\" is NOT displayed.", Trash.isPayTheBillsTextVisible());

        // Expected Result: List View has one child
        assertEquals("List view has more/less then one child.", 1, EspressoMethods.getChildCountFromListView(withId(R.id.list)));

        // Step 11. Click More option
        Trash.clickMoreOptionsButton();

        // Step 12. Click Empty Trash button
        Trash.clickEmptyTrashButton();

        // Step 13. Click Button with text OK
        Trash.clickTheConfirmButton();

        // Expected Result: Note with title "Pay the bills" is NOT displayed"
        assertFalse("Note with title \"Pay the bills\" is displayed.", Trash.isPayTheBillsTextVisible());
    }
}

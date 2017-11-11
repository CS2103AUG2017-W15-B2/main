package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.model.calendarevent.CalendarEvent;
import seedu.address.testutil.CalendarEventBuilder;

//@@author yilun-zhu

public class AddEventCommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void constructorNullCalendarEventThrowsNullPointerException() {
        thrown.expect(NullPointerException.class);
        new AddEventCommand(null);
    }

    @Test
    public void executeEventSuccessful() {
        CalendarEvent validEvent = new CalendarEventBuilder().build();
        CommandResult commandResult = getAddEventCommandForCalendarEvent(validEvent).execute();
        assertTrue(String.format(AddEventCommand.MESSAGE_SUCCESS, validEvent).equals(commandResult.feedbackToUser));
    }


    @Test
    public void equals() {
        CalendarEvent halloween = new CalendarEventBuilder().withName("Halloween").build();
        CalendarEvent danceClass = new CalendarEventBuilder().withName("Dance class").build();
        AddEventCommand addHalloweenCommand = new AddEventCommand(halloween);
        AddEventCommand addDanceClassCommand = new AddEventCommand(danceClass);

        // same object -> returns true
        assertTrue(addHalloweenCommand.equals(addHalloweenCommand));

        // same values -> returns true
        AddEventCommand addHalloweenCommandCopy = new AddEventCommand(halloween);
        assertTrue(addHalloweenCommand.equals(addHalloweenCommandCopy));

        // different types -> returns false
        assertFalse(addHalloweenCommand.equals(1));

        // different event -> returns false
        assertFalse(addHalloweenCommand.equals(addDanceClassCommand));
    }

    /**
     * Generates a new AddEventCommand with the details of the given event.
     */
    private AddEventCommand getAddEventCommandForCalendarEvent(CalendarEvent event) {
        AddEventCommand command = new AddEventCommand(event);
        return command;
    }


}

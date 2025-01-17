package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Deals with executing command input by user.
 */
public abstract class Command {

    private String response = "Command has not yet been executed";
    private boolean isExit = false;

    public String getResponse() {
        return response;
    }

    protected void setResponse(String response) {
        this.response = response;
    }

    /**
     * Executes command input by user.
     *
     * @param tasks List of tasks.
     * @param ui Handles user interaction.
     * @param storage Handles saving and loading tasks.
     * @throws DukeException if encountering an exception specific to Duke.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /** Checks if Duke should exit. */
    public boolean isExit() {
        return isExit;
    }

    /** Sets program to exit. */
    public void exit() {
        isExit = true;
    }
}

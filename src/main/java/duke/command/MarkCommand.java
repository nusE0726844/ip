package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.task.Task;
import duke.ui.Ui;

/**
 * Handles the marking task as done
 * Changes completion status of task to done
 * Save changes made to list in the hard disk
 * Returns response for changing the status of specified task to done.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Stores the index of the task to be marked as completed
     *
     * @param fullCommand The user's input command
     * @throws DukeException If input from user does not contain a valid index
     */
    public MarkCommand(String fullCommand) throws DukeException {
        try {
            index = Integer.parseInt(fullCommand
                    .split("mark")[1]
                    .trim());
        } catch (NumberFormatException e) {
            throw new DukeException("Index given is not an integer");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("An index for a task was not given");
        }
    }

    /**
     * Executes command input by user.
     *
     * @param tasks List of tasks.
     * @param ui Handles user interaction.
     * @param storage Handles saving and loading tasks.
     * @throws DukeException if encountering an exception specific to Duke.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.mark(index);
        storage.save(tasks);

        setResponse(ui.getMarkMessage()
                + "\n  " + task);
    }
}

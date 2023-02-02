package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Contains the task list
 * Has operations to man tasks in the list
 */
public class TaskList {
    ArrayList<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }
    public TaskList(TaskList tasks) {
        this.tasks = tasks.getTasks();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) throws DukeException {
        try {
            return tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index is not in the list of task");
        }
    }

    /**
     * Adds specified task to list of tasks
     *
     * @param task duke.task.Task to be added
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Removes specified task from list of tasks
     *
     * @param index Index of task to be removed
     */
    public Task delete(int index) throws DukeException {
        try {
            return tasks.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index of task to be removed is not in the list of task");
        }
    }

    /**
     * Marks specified task from list of tasks as done
     *
     * @param index Index of specified task
     */
    public Task mark(int index) throws DukeException {
        try {
            Task task = tasks.get(index - 1);
            task.mark();
            return task;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index of task to be marked is not in the list of task");
        }
    }

    /**
     * Changes the status of specified task from list of tasks back to not done
     *
     * @param index Index of specified task
     */
    public Task unmark(int index) throws DukeException {
        try {
            Task task = tasks.get(index - 1);
            task.unmark();
            return task;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index of task to be unmarked is not in the list of task");
        }
    }

    /**
     * Shows the list of tasks
     */
    public Task[] toArray() {
        return tasks.toArray(new Task[0]);
    }
}
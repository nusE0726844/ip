package duke;

import duke.command.Command;



/**
 * Generates a Duke object
 */
public class Duke {
    public static final String DEFAULT_FILEPATH = "data/tasks.txt";

    private final Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Generates a Duke object.
     * Stores saved data in default filepath.
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage(DEFAULT_FILEPATH);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Generates a Duke object.
     * Stores saved data in specified filepath.
     *
     * @param filePath Location of saved data.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Executes Duke.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Creates and run Duke.
     */
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }

    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}

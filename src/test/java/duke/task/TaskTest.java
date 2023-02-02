package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    public void getDescription() {
        // A unit test for Task#getDescription
        // test setup
        String description = "Hello World";
        Task task = new Task(description);

        // automatically verify the response
        assertEquals(task.getDescription(),
                description);
    }

    @Test
    public void getStatusIcon() {
        // A unit test for Task#getStatusIcon
        // test setup
        String description = "Hello World";
        Task task = new Task(description);

        // automatically verify the response
        assertEquals(task.getStatusIcon(),
                " ");
    }
}
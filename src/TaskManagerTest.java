import static org.junit.Assert.*;
import org.junit.Test;

public class TaskManagerTest {
    @Test
    public void normal1() {
        TaskManager taskManager = new TaskManager(3);
        taskManager.insert("Clean the house", 5);
        taskManager.insert("Do homework", 6);
        taskManager.insert("Arrange meetings", 3);
        taskManager.insert("Fix bugs", 10);
        taskManager.insert("Cooking", 8);
        assertEquals("Fix bugs", taskManager.getNextTask());
        assertEquals("Cooking", taskManager.getNextTask());
        assertEquals("Do homework", taskManager.getNextTask());
        taskManager.insert("Watch dramas", 2);
        taskManager.insert("Update profile", 8);
        assertEquals("Update profile", taskManager.getNextTask());
        assertEquals("Clean the house", taskManager.getNextTask());
        assertEquals("Arrange meetings", taskManager.getNextTask());
        assertEquals("Watch dramas", taskManager.getNextTask());
    }

    @Test
    public void normal2() {
        TaskManager taskManager = new TaskManager();
        taskManager.insert("Buy stationery", 9);
        taskManager.insert("Visit relatives", 3);
        assertEquals("Buy stationery", taskManager.getNextTask());
        assertEquals("Visit relatives", taskManager.getNextTask());
    }

    @Test
    public void oneElem() {
        TaskManager taskManager = new TaskManager();
        taskManager.insert("Do something", 102);
        assertEquals("Do something", taskManager.getNextTask());
    }
}

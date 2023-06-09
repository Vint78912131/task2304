import java.util.List;
import java.util.Map;

/*
Inner 3
*/

public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider implements DbDataProvider<Task> {
        @Override
        public void refreshAllData(Map criteria) {
            //get tasks from server by criteria
            tasks = MockDB.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider<String> {
        @Override
        public void refreshAllData(Map criteria) {
            //get names from server by criteria
            names = MockDB.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {
        new Solution().refresh();
    }
}

/* НЕ ПРИНЯТО ВАЛИДАТОРОМ
public class Solution {

    private List<Task> tasks;
    private List<String> names;


    private class TaskDataProvider implements DbDataProvider <Task>{
        @Override
        public void refreshAllData(Map criteria) {
            MockDB mockTasks = new MockDB();
            Solution.this.tasks.addAll(mockTasks.getFakeTasks(criteria));
        }
    }

    private class NameDataProvider implements DbDataProvider <String>{
        @Override
        public void refreshAllData(Map criteria) {
            MockDB mockNames = new MockDB();
            Solution.this.names.addAll(mockNames.getFakeNames(criteria));
        }
    }
    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }
}
 */

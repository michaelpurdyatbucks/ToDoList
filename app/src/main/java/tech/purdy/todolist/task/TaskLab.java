package tech.purdy.todolist.task;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskLab
{
    private static final String TAG = "TaskLab";

    private static TaskLab sTaskLab;
    private List<Task> mTasks;

    public static TaskLab get()
    {
        if (sTaskLab == null)
        {
            sTaskLab = new TaskLab();
        }
        return sTaskLab;
    }

    private TaskLab()
    {
        mTasks = new ArrayList<>();
    }

    public void addTask(Task task)
    {
        mTasks.add(task);
    }

    public List<Task> getTasks()
    {
        return mTasks;
    }

    public Task getTask(UUID id)
    {
        for (Task task : mTasks)
        {
            if(task.getId().equals(id))
            {
                return task;
            }
        }
        return null;
    }

    public void deleteTask(UUID id)
    {
        for (Task task : mTasks)
        {
            if(task.getId().equals(id))
            {
                mTasks.remove(task);
            }
        }
    }

    public static String saveState()
    {
        JSONArray jsonTasks = new JSONArray();
        try
        {
            for (Task task : sTaskLab.getTasks())
            {
                JSONObject jsonTask = new JSONObject();
                jsonTask.put("title", task.getTitle());
                jsonTask.put("description", task.getDescription());
                jsonTask.put("dueDate", task.getDueDate());
                jsonTask.put("completedDate", task.getCompletedDate());
                jsonTasks.put(jsonTask);
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Failed to form json string");
        }
        return jsonTasks.toString();
    }

    public static void loadState(String tasksAsJson)
    {
        List<Task> tasks = sTaskLab.getTasks();
        if (!tasks.isEmpty())
            return;
        try
        {
            JSONArray jsonTasks = new JSONArray(tasksAsJson);
            for (int i = 0; i < jsonTasks.length(); i++)
            {
                JSONObject jsonTask = jsonTasks.getJSONObject(i);
                Task task = new Task();
                if (!jsonTask.isNull("title"))
                    task.setTitle(jsonTask.getString("title"));
                if (!jsonTask.isNull("description"))
                    task.setDescription(jsonTask.getString("description"));
                if (!jsonTask.isNull("dueDate"))
                    task.setDueDate(jsonTask.getString("dueDate"));
                if (!jsonTask.isNull("completedDate"))
                    task.setCompletedDate(jsonTask.getString("completedDate"));
                tasks.add(task);
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Failed to load json string");
        }
    }
}

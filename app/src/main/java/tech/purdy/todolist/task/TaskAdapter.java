package tech.purdy.todolist.task;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import tech.purdy.todolist.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskHolder>
{
    private List<Task> mTasks;
    private Activity mActivity;

    public TaskAdapter(List<Task> tasks, Activity activity)
    {
        mTasks = tasks;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(mActivity);
        return new TaskHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position)
    {
        Task task = mTasks.get(position);
        holder.bind(task);
    }

    @Override
    public int getItemCount()
    {
        return mTasks.size();
    }
}

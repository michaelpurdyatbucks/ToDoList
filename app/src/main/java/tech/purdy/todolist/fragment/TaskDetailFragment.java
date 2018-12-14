package tech.purdy.todolist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import tech.purdy.todolist.R;
import tech.purdy.todolist.activity.MainActivity;
import tech.purdy.todolist.task.Task;
import tech.purdy.todolist.task.TaskLab;

public class TaskDetailFragment extends Fragment
{
    private static final String TAG = "TaskDetailActivity";

    private TextView mTaskTitle;
    private TextView mTaskDescription;
    private TextView mTaskDueDate;
    private TextView mTaskCompletedDate;
    private Button mTaskDeleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Started.");

        UUID mCurrentTaskUUID = MainActivity.getmCurrentTaskUUID();
        TaskLab taskLab = TaskLab.get();
        Task task = taskLab.getTask(mCurrentTaskUUID);

        mTaskTitle = (TextView) view.findViewById(R.id.task_title);
        mTaskDescription = (TextView) view.findViewById(R.id.task_description);
        mTaskDueDate = (TextView) view.findViewById(R.id.task_duedate);
        mTaskCompletedDate = (TextView) view.findViewById(R.id.task_completeddate);

        mTaskDeleteButton = (Button) view.findViewById(R.id.task_delete);
        mTaskDeleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UUID mCurrentTaskUUID = MainActivity.getmCurrentTaskUUID();
                TaskLab taskLab = TaskLab.get();
                taskLab.deleteTask(mCurrentTaskUUID);
                Toast.makeText(getContext(), "Task deleted", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        if (task != null)
        {
            mTaskTitle.setText(task.getTitle());
            mTaskDueDate.setText(task.getDueDate());
            mTaskDescription.setText(task.getDescription());
            mTaskCompletedDate.setText(task.getCompletedDate());
        }

        return view;
    }
}

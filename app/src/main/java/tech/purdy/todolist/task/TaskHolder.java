package tech.purdy.todolist.task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Calendar;

import tech.purdy.todolist.R;

public class TaskHolder extends RecyclerView.ViewHolder
{
    private Task mTask;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private TextView mDueDateTextView;
    private CheckBox mCheckBox;

    public TaskHolder(LayoutInflater inflater, ViewGroup parent)
    {
        super(inflater.inflate(R.layout.fragment_task, parent, false));

        mTitleTextView = (TextView) itemView.findViewById(R.id.task_title);
        mDescriptionTextView = (TextView) itemView.findViewById(R.id.task_description);
        mDueDateTextView = (TextView) itemView.findViewById(R.id.task_duedate);
        mCheckBox = (CheckBox) itemView.findViewById(R.id.task_checkbox);
        mCheckBox.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mTask.isCompleted())
                {
                    mTask.setCompletedDate(null);
                }
                else
                {
                    mTask.setCompletedDate(Calendar.getInstance().toString());
                }
            }
        });
    }

    public void bind(Task task)
    {
        mTask = task;
        mTitleTextView.setText(mTask.getTitle());
        mDescriptionTextView.setText(mTask.getDescription());
        mDueDateTextView.setText(mTask.getDueDate());
        mCheckBox.setChecked(mTask.isCompleted());
    }
}

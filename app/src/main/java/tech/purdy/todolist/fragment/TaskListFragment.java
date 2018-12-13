package tech.purdy.todolist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tech.purdy.todolist.Constants;
import tech.purdy.todolist.R;
import tech.purdy.todolist.activity.MainActivity;
import tech.purdy.todolist.task.Task;
import tech.purdy.todolist.task.TaskLab;

public class TaskListFragment extends Fragment
{
    private static final String TAG = "TaskListFragment";
    private RecyclerView mTaskRecyclerView;
    private TaskAdapter mTaskAdapter;
    private Button mTaskCreationButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        mTaskRecyclerView = (RecyclerView) view.findViewById(R.id.task_recycler_view);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mTaskCreationButton = (Button) view.findViewById(R.id.new_task_button);
        mTaskCreationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        update();

        return view;
    }

    public void update()
    {
        TaskLab taskLab = TaskLab.get(getActivity());
        List<Task> tasks = taskLab.getTasks();

        mTaskAdapter = new TaskAdapter(tasks);
        mTaskRecyclerView.setAdapter(mTaskAdapter);
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>
    {
        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks)
        {
            mTasks = tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
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

    private class TaskHolder extends RecyclerView.ViewHolder
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
            mTitleTextView.setOnClickListener(getOnclickListener());

            mDescriptionTextView = (TextView) itemView.findViewById(R.id.task_description);
            mDescriptionTextView.setOnClickListener(getOnclickListener());

            mDueDateTextView = (TextView) itemView.findViewById(R.id.task_duedate);
            mDueDateTextView.setOnClickListener(getOnclickListener());

            mCheckBox = (CheckBox) itemView.findViewById(R.id.task_checkbox);
        }

        public void bind(Task task)
        {
            mTask = task;
            mTitleTextView.setText(mTask.getTitle());
            mDescriptionTextView.setText(mTask.getDescription());
            mDueDateTextView.setText(mTask.getDueDateAsString());
            mCheckBox.setChecked(mTask.isCompleted());
        }

        public View.OnClickListener getOnclickListener()
        {
            return new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    MainActivity.setmCurrentTaskUUID(mTask.getId());
                    ((MainActivity)getActivity()).setViewPager(2);
                }
            };
        }
    }
}
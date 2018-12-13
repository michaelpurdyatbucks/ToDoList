package tech.purdy.todolist.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import tech.purdy.todolist.R;
import tech.purdy.todolist.activity.MainActivity;
import tech.purdy.todolist.task.Task;
import tech.purdy.todolist.task.TaskLab;

public class TaskCreationFragment extends Fragment
{
    private static final String TAG = "TaskCreationActivity";
    private EditText mTitleEditText;
    private EditText mDescriptionEditText;
    private CheckBox mDueDateCheckBox;
    private DatePicker mDueDateDatePicker;
    private Button mConfirmButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_task_creation, container, false);
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Started.");

        mTitleEditText = (EditText) view.findViewById(R.id.task_creation_title);

        mDescriptionEditText = (EditText) view.findViewById(R.id.task_creation_description);

        mDueDateCheckBox = (CheckBox) view.findViewById(R.id.task_creation_duedate_checkbox);
        mDueDateCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                mDueDateDatePicker.setEnabled(isChecked);
            }
        });

        mDueDateDatePicker = (DatePicker) view.findViewById(R.id.task_creation_duedate);

        mConfirmButton = (Button) view.findViewById(R.id.task_creation_button);
        mConfirmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TaskLab taskLab = TaskLab.get(getActivity());
                Task task = new Task();
                task.setTitle(mTitleEditText.getText().toString());
                taskLab.addTask(task);

                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        return view;
    }
}

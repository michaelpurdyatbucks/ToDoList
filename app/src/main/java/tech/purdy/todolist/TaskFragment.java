package tech.purdy.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Date;

public class TaskFragment extends Fragment
{
    private Task mTask;
    private TextView mTitleField;
    private TextView mDescriptionField;
    private TextView mDueDateField;
    private CheckBox mCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mTask = new Task();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        mTitleField = (TextView) view.findViewById(R.id.task_title);
        mTitleField.addTextChangedListener(getTitleFieldTextWatcher());

        mDescriptionField = (TextView) view.findViewById(R.id.task_description);
        mDescriptionField.addTextChangedListener(getDescriptionFieldTextWatcher());

        mDueDateField = (TextView) view.findViewById(R.id.task_duedate);
        mDueDateField.addTextChangedListener(getDueDateFieldTextWatcher());

        mCheckBox = (CheckBox) view.findViewById(R.id.task_checkbox);
        mCheckBox.setOnCheckedChangeListener(getCheckBoxOnClickListener());

        return view;
    }

    public CompoundButton.OnCheckedChangeListener getCheckBoxOnClickListener()
    {
        return new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    mTask.setCompletedDate(new Date());
                }
                else
                {
                    mTask.setCompletedDate(null);
                }
            }
        };
    }

    private TextWatcher getDueDateFieldTextWatcher()
    {
        return new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mTask.setDueDate(null);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        };
    }

    private TextWatcher getDescriptionFieldTextWatcher()
    {
        return new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mTask.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        };
    }

    private TextWatcher getTitleFieldTextWatcher()
    {
        return new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mTask.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        };
    }
}

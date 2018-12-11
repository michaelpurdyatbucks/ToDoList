package tech.purdy.todolist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tech.purdy.todolist.R;

public class NewTaskButtonFragment extends Fragment
{
    private Button mNewTaskButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_task_button, container, false);

        mNewTaskButton = (Button) view.findViewById(R.layout.fragment_task_button);

        return view;
    }
}

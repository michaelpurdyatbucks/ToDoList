package tech.purdy.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class TaskListActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);


        //if (findViewById(R.id.fragment_container) != null)
//        {
//            if (savedInstanceState != null)
//            {
//                return;
//            }
//
//            TaskListFragment taskListFragment = new TaskListFragment();
//
//            getSupportFragmentManager().beginTransaction()
//                                       .add(R.id.fragment_container, taskListFragment)
//                                       .commit();
//        }
    }
}

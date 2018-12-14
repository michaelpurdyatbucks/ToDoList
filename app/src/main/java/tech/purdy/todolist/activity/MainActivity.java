package tech.purdy.todolist.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import tech.purdy.todolist.R;
import tech.purdy.todolist.fragment.TaskCreationFragment;
import tech.purdy.todolist.fragment.TaskDetailFragment;
import tech.purdy.todolist.fragment.TaskListFragment;
import tech.purdy.todolist.task.TaskLab;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    private static final String STORAGE = "tasks.json";

    private static UUID mCurrentTaskUUID;
    private int lastActivity = 0;
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        Log.d(TAG, "onCreate: Started.");
        loadState();

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TaskListFragment(), "TaskListFragment");
        adapter.addFragment(new TaskCreationFragment(), "TaskCreationFragment");
        adapter.addFragment(new TaskDetailFragment(), "TaskDetailFragment");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber)
    {
        lastActivity = mViewPager.getCurrentItem();
        SectionsStatePagerAdapter adapter = (SectionsStatePagerAdapter) mViewPager.getAdapter();
        adapter.updateFragments();
        mViewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed()
    {
        if (mViewPager.getCurrentItem() != 0) {
            mViewPager.setCurrentItem(lastActivity, false);
            lastActivity = 0;
        }else{
            finish();
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        saveState();
    }

    private void saveState()
    {
        String jsonString = TaskLab.saveState();
        if (jsonString.isEmpty())
            return;
        try {
            FileOutputStream outputStream = openFileOutput(STORAGE, MODE_PRIVATE);
            outputStream.write(jsonString.getBytes());
            outputStream.close();
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Failed to write tasks. " + exception.getMessage());
        }
    }

    private void loadState()
    {
        TaskLab.get();
        StringBuilder jsonData = new StringBuilder();
        try {
            FileInputStream fis = openFileInput(STORAGE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonData.append(line);
            }
        }
        catch (Exception exception)
        {
            Log.e(TAG, "Failed to read tasks. " + exception.getMessage());
        }
        TaskLab.loadState(jsonData.toString());
    }

    public static void setmCurrentTaskUUID(UUID uuid)
    {
        mCurrentTaskUUID = uuid;
    }

    public static UUID getmCurrentTaskUUID()
    {
        return mCurrentTaskUUID;
    }
}

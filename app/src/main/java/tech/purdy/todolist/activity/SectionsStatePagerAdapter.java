package tech.purdy.todolist.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import tech.purdy.todolist.fragment.TaskListFragment;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter
{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentListTitleList = new ArrayList<>();


    public SectionsStatePagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    public void addFragment(Fragment fragment, String title)
    {
        mFragmentList.add(fragment);
        mFragmentListTitleList.add(title);
    }

    public void updateFragments()
    {
        ((TaskListFragment)mFragmentList.get(0)).update();
    }

    @Override
    public Fragment getItem(int position)
    {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragmentList.size();
    }
}

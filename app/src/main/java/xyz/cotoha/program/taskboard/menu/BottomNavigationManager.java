package xyz.cotoha.program.taskboard.menu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import xyz.cotoha.program.taskboard.R;
import xyz.cotoha.program.taskboard.fragment.PDCAFragment;
import xyz.cotoha.program.taskboard.fragment.ShiftsFragment;
import xyz.cotoha.program.taskboard.fragment.TasksFragment;
import xyz.cotoha.program.taskboard.fragment.WeightManagementFragment;

public class BottomNavigationManager {
    private FragmentManager fragmentManager;
    private int containerViewId;

    public BottomNavigationManager(FragmentManager fragmentManager, int containerViewId) {
        this.fragmentManager = fragmentManager;
        this.containerViewId = containerViewId;
    }

    public void setupBottomNavigation(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;

            // メニュー項目の ID に基づいてフラグメントを切り替え
            if (item.getItemId() == R.id.navigation_tasks) {
                fragment = new TasksFragment();
            } else if (item.getItemId() == R.id.navigation_shifts) {
                fragment = new ShiftsFragment();
            } else if (item.getItemId() == R.id.navigation_weight) {
                fragment = new WeightManagementFragment();
            } else if (item.getItemId() == R.id.navigation_goals) {
                fragment = new PDCAFragment();
            }

            if (fragment != null) {
                fragmentManager.beginTransaction().replace(containerViewId, fragment).commit();
                return true;
            } else {
                return false;
            }
        });
    }

}

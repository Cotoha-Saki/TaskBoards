package xyz.cotoha.program.taskboard;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import xyz.cotoha.program.taskboard.menu.BottomNavigationManager;
import xyz.cotoha.program.taskboard.menu.DrawerManager;

public class MainActivity extends AppCompatActivity {

    private DrawerManager drawerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        drawerManager = new DrawerManager(this, R.id.drawer_layout, R.id.nav_view, toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        BottomNavigationManager navigationManager = new BottomNavigationManager(getSupportFragmentManager(), R.id.fragment_container);
        navigationManager.setupBottomNavigation(bottomNavigationView);
    }

    @Override
    public void onBackPressed() {
        if (!drawerManager.handleBackPressed()) {
            super.onBackPressed();
        }
    }

}
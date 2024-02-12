package xyz.cotoha.program.taskboard.menu;

import android.content.Context;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerManager {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    public NavigationDrawerManager(DrawerLayout drawerLayout, NavigationView navigationView) {
        this.drawerLayout = drawerLayout;
        this.navigationView = navigationView;
        setupDrawerContent(navigationView);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    // メニュー項目の選択イベントを処理
                    // 例: menuItem.getItemId() を使ってIDに基づいた処理を行う
                    drawerLayout.closeDrawers(); // ナビゲーションドロワーを閉じる
                    return true;
                });
    }

    public void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}

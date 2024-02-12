package xyz.cotoha.program.taskboard.menu;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import xyz.cotoha.program.taskboard.R;
import xyz.cotoha.program.taskboard.utils.NotificationUtils;

public class DrawerManager {
    private Context context;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    public DrawerManager(Activity activity, int drawerLayoutId, int navigationViewId, Toolbar toolbar) {
        this.drawerLayout = activity.findViewById(drawerLayoutId);
        this.navigationView = activity.findViewById(navigationViewId);
        this.context = activity; // ここを activity に修正しました。
        setupDrawerToggle(activity, toolbar);
        setupDrawerContent(); // ここで引数を取り除きました。
        setupDrawerListener();
    }

    private void setupDrawerToggle(Activity activity, Toolbar toolbar) {
        // ActionBarDrawerToggle の設定...
    }

    private void setupDrawerContent() {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // メニュー項目に応じたアクションを実行
                        int id = item.getItemId();
                        switch (id) {
                            // ケースに応じてアクションを追加
                        }
                        if (context != null) {
                            NotificationUtils notificationUtils = new NotificationUtils(context);
                            notificationUtils.showPopupNotification("ドロワーメニューを選択しました");
                        }
                        // ナビゲーションドロワーを閉じる
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                }
        );
    }

    private void setupDrawerListener() {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // スライド時の処理はここでは不要
            }

            // DrawerManager の onDrawerOpened メソッド
            @Override
            public void onDrawerOpened(View drawerView) {
                // NotificationUtils インスタンスを作成する前に context が null でないことを確認
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                // ドロワーが閉じた時に選択状態を解除
                int size = navigationView.getMenu().size();
                for (int i = 0; i < size; i++) {
                    navigationView.getMenu().getItem(i).setChecked(false);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                // 状態変更時の処理はここでは不要
            }
        });
    }

    public boolean handleBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}

package com.example.guiaejerciciod10;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initBottomNavBar();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initBottomNavBar() {
        // Recupera la vista de la barra de navegación declarada en el archivo activity_main.xml
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Recupera el Navigation Controller para la navegación
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // Asocia la Bottom Navigation bar con el NavController
        NavigationUI.setupWithNavController(navView, navController);
    }
}
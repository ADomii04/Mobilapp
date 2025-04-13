package com.example.mobil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class UserIndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_index);

        RecyclerView recyclerView = findViewById(R.id.categoryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<String> categories = new ArrayList<>();
        categories.add("Tamási Áron: Énekes madár");
        categories.add("Presser G.-Sztevanovity D.-Horváth P.: A padlás");
        categories.add("Kárpáti Péter: Térkép a túlvilágról");
        categories.add("Czene-Hajdu-Károlyi: Gengszterek");
        categories.add("A. J. Lerner - F. Leowe: My Fair Lady");
        categories.add("Szegedi Kortárs Balett: Jelenetek a házasságról");
        categories.add("Varsányi Anna: A szent");
        categories.add("Erkel Ferenc: Bánk bán");

        CategoryAdapter adapter = new CategoryAdapter(categories, this::onCategorySelected);
        recyclerView.setAdapter(adapter);
    }
    private void onCategorySelected(String category) {
        Intent intent = new Intent(this, CategoryItemsActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}

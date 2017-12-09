package hackers.com.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.*;

/**
 * Created by user on 02-10-2017.
 */

public class Product_activity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardan_product);



        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_rv);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final ArrayList<CategoryModel> categoryList = new ArrayList<>();
        for (int i = 0 ; i < 50 ; i++){
            final ArrayList<ProductModel> productList = new ArrayList<>();


            for (int j = 0 ; j < 100 ; j++){
                final ProductModel productModel = new ProductModel(j,"M1","Product"+j);
                productList.add(productModel);
            }

            final CategoryModel categoryModel = new CategoryModel("Category"+i,productList);

            categoryList.add(categoryModel);

        }

        final CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryList);
        recyclerView.setAdapter(categoryAdapter);







    }


}

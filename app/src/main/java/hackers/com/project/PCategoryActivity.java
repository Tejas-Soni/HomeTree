package hackers.com.project;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by user on 03-11-2017.
 */

public class PCategoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_product);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.category_product_rv);
        final GridLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);
//        final ArrayList<CategoryModel> categoryList = new ArrayList<>();
        final ArrayList<ProductModel> productList = new ArrayList<>();
        for (int j = 0 ; j < 100 ; j++){

            final ProductModel productModel = new ProductModel(j,"M1","Product"+j);
            productList.add(productModel);
        }

        final PCategoryAdapter categoryAdapter = new PCategoryAdapter(productList);
        recyclerView.setAdapter(categoryAdapter);
    }
}

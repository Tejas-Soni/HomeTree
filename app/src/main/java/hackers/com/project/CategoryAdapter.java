package hackers.com.project;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by user on 11-10-2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private ArrayList<CategoryModel> myModelArrayList;
    private Context context;

    public CategoryAdapter(final Context context,final ArrayList<CategoryModel> myModelArrayList) {
        this.myModelArrayList = myModelArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity)parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_catagory,parent,false);
        return new MyViewHolder(view,context,myModelArrayList);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final CategoryModel myModel = myModelArrayList.get(position);
        holder.tv.setText(myModel.getCategoryname());

        final ProductAdapter productAdapter = new ProductAdapter(context,myModel.getProductlist());
        holder.recyclerView.setAdapter(productAdapter);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = holder.getAdapterPosition();
                CategoryModel categoryModels = myModelArrayList.get(position);
                Intent intent = new Intent(context,PCategoryActivity.class);
                intent.putExtra("categoryname",categoryModels.getCategoryname());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {return myModelArrayList.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder  {
    private RecyclerView recyclerView;
    private TextView tv;
    private Button button;
    Context context;
    ArrayList<CategoryModel> myModelArrayList = new ArrayList<CategoryModel>();


    public MyViewHolder(View itemView,Context context,ArrayList<CategoryModel> myModelArrayList) {
        super(itemView);
        this.myModelArrayList = myModelArrayList;
        this.context = context;

        recyclerView = itemView.findViewById(R.id.row_category_rv);
        tv = itemView.findViewById(R.id.row_category_tv_name);
        button=itemView.findViewById(R.id.button);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }


}
}

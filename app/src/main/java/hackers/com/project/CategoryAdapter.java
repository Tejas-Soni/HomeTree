package hackers.com.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CategoryModel myModel = myModelArrayList.get(position);
        holder.tv.setText(myModel.getCategoryname());

        final ProductAdapter productAdapter = new ProductAdapter(context,myModel.getProductlist());
        holder.recyclerView.setAdapter(productAdapter);
    }


    @Override
    public int getItemCount() {return myModelArrayList.size();}

public class MyViewHolder extends RecyclerView.ViewHolder{
    private RecyclerView recyclerView;
    private TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.row_category_rv);
        tv = itemView.findViewById(R.id.row_category_tv_name);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
 }
}

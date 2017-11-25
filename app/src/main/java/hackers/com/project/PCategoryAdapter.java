package hackers.com.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 03-11-2017.
 */

public class PCategoryAdapter extends  RecyclerView.Adapter<PCategoryAdapter.MyViewHolder> {
    private ArrayList<ProductModel> myModelArrayList1;
    public PCategoryAdapter(final ArrayList<ProductModel> myModelArrayList ){
        this.myModelArrayList1 = myModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity)parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_product,parent,false);
        return new MyViewHolder(view);
    }





    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ProductModel myModel = myModelArrayList1.get(position);
        holder.tv.setText(myModel.getName());
//        holder.iv.setImageResource(myModel.getImage());

    }

    @Override
    public int getItemCount() {
        return myModelArrayList1.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
//        private RecyclerView recyclerView;
        private ImageView iv;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.row_product_iv);
//            recyclerView = itemView.findViewById(R.id.row_category_rv);
            tv = itemView.findViewById(R.id.row_product_tv);



        }
    }
}


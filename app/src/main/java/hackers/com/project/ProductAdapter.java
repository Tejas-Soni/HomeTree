package hackers.com.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 11-10-2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private ArrayList<ProductModel> myModelArrayList;
    private Context context;
    public ProductAdapter(final Context context, final ArrayList<ProductModel> myModelArrayList ) {
        this.myModelArrayList = myModelArrayList;
        this.context = context;
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity) parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_product, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ProductModel myModel = myModelArrayList.get(position);
        holder.tv.setText(myModel.getName());

    }

    @Override
    public int getItemCount() {
        return myModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.row_product_iv);
            tv = itemView.findViewById(R.id.row_product_tv);

        }
    }
}

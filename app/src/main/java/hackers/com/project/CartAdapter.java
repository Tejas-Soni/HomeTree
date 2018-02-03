
package hackers.com.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>  {
    private ArrayList<CartModel> myModelArrayList;
    private Context context;

    public CartAdapter( final Context context,final ArrayList<CartModel> myModelArrayList) {
        this.myModelArrayList = myModelArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = ((Activity)parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_catagory,parent,false);
        return new CartAdapter.MyViewHolder(view,context,myModelArrayList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {



        public MyViewHolder(View itemView,Context context ,final ArrayList<CartModel> myModelArrayList) {
            super(itemView);
        }
    }
}


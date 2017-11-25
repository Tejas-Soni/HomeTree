package hackers.com.project;

import java.util.ArrayList;

/**
 * Created by user on 03-11-2017.
 */

public class PCategoryModel {


    private int drawable;
    private String categoryname;
    private ArrayList<ProductModel> productlist= new ArrayList<>();

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}




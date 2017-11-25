package hackers.com.project;

import java.util.ArrayList;

/**
 * Created by user on 11-10-2017.
 */

public class CategoryModel {

    private String categoryname;
    private ArrayList<ProductModel>productlist= new ArrayList<>();

    public CategoryModel(String categoryname, ArrayList<ProductModel> productlist) {
        this.categoryname = categoryname;
        this.productlist = productlist;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public ArrayList<ProductModel> getProductlist() {
        return productlist;
    }

    public void setProductlist(ArrayList<ProductModel> productlist) {
        productlist = productlist;
    }



}



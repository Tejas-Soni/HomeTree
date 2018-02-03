package hackers.com.project;

/**
 * Created by user on 05-01-2018.
 */

public class CartModel {
    private int id;
    private String image;
    private static String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CartModel.name = name;
    }
}

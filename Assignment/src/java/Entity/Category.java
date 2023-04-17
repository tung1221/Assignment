package Entity;

public class Category {
    private int cateId;
    private String cateName;
    private int status;

    public Category(int cateId, String cateName, int status) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.status = status;
    }

    public Category(String cateName, int status) {
        this.cateName = cateName;
        this.status = status;
    }

    public Category() {

    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" + "cateId=" + cateId + ", cateName=" + cateName + ", status=" + status + '}';
    }

}

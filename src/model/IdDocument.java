package model;

/**
 * @author YichenLiu
 * @description: Id document model
 * @date 2022/3/16 16:29
 */
//还是需要的，就把他当作身份证来用，主要是让controller体现多态
public class IdDocument {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

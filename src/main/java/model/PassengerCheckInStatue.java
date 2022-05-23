package model;/**
 * @author Zihao Ye
 * @version 1.0
 */

/**
 * @projectName: workspace.xml
 * @package: model
 * @className: PassengerCheckInStatue
 * @author: Zihao YE
 * @description: TODO
 * @date: 2022/5/23 12:11
 * @version: 1.0
 */
public class PassengerCheckInStatue {
    private Integer IdDocument;
    private boolean isChecked;

    public Integer getIdDocument() {
        return IdDocument;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIdDocument(Integer idDocument) {
        IdDocument = idDocument;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

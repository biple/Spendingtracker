
package in.ezeon;

import java.util.Date;

/**
 *
 * @author Rukato
 */
public class Expense {
    private Long expenseID = System.currentTimeMillis();
    private Long categoryID;
    private Float amount;
    private Date date;
    private String remark;

    public Expense() {
    }

    public Expense(Long categoryID, Float amount, Date date, String remark) {
        this.categoryID = categoryID;
        this.amount = amount;
        this.date = date;
        this.remark = remark;
    }
    
    public Long getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(Long expenseID) {
        this.expenseID = expenseID;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

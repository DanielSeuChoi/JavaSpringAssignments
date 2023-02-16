package daniel.travelcrud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, message = "Expense name must be at least one character")
    private String expense;

    @NotNull
    @Size(min = 2, max = 10, message = "Vendor name must be at least two characters")
    private String vendor;

    private Integer amount;

    public Travel() {
    }

    public Travel(Long id, String expense, String vendor, Integer amount) {
        this.id = id;
        this.expense = expense;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpense() {
        return this.expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}

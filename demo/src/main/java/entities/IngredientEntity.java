package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ingredient", schema = "public", catalog = "pancakes_unlimited_db")
public class IngredientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryByCategoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryByCategoryId.getId();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientEntity that = (IngredientEntity) o;
        return id == that.id && getCategoryId() == that.getCategoryId() && Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name, price, getCategoryId()); }

    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}

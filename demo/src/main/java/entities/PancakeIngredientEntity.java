package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pancake_ingredient", schema = "public", catalog = "pancakes_unlimited_db")
public class PancakeIngredientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "pancake_id", nullable = true)
    private Integer pancakeId;
    @Basic
    @Column(name = "ingredient_id", nullable = true)
    private Integer ingredientId;

    public int getId() {
        return id;
    }

    public Integer getPancakeId() {
        return pancakeId;
    }

    public void setPancakeId(Integer pancakeId) {
        this.pancakeId = pancakeId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PancakeIngredientEntity that = (PancakeIngredientEntity) o;
        return id == that.id && Objects.equals(pancakeId, that.pancakeId) && Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pancakeId, ingredientId);
    }
}

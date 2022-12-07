package entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pancake", schema = "public", catalog = "pancakes_unlimited_db")
public class PancakeEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pancake_id_seq_generator" )
    @SequenceGenerator(name = "pancake_id_seq_generator", sequenceName = "pancake_id_seq", initialValue = 1, allocationSize = 1)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = true)
    private PancakeOrderEntity pancakeOrder;
    public int getId() {
        return id;
    }

    public PancakeEntity setOrder(PancakeOrderEntity order) {
        this.pancakeOrder = order;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PancakeEntity that = (PancakeEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

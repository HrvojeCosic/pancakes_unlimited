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
    public int getId() {
        return id;
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

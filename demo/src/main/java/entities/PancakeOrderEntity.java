package entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "pancake_order", schema = "public", catalog = "pancakes_unlimited_db")
public class PancakeOrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "timestamp", nullable = false)
    private OffsetDateTime timestamp;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public PancakeOrderEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public PancakeOrderEntity setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PancakeOrderEntity that = (PancakeOrderEntity) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, timestamp);
    }
}

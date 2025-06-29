package dev.gutemberg.post.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    private UUID id;
    private String title;
    @Column(columnDefinition = "text")
    private String body;
    private String author;
    private Long wordCount;
    private BigDecimal calculatedValue;
    private Instant createdAt;

    public Post(final String title, final String body, final String author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.body = body;
        this.author = author;
        createdAt = Instant.now();
    }

    public Optional<Long> getWordCount() {
        return Optional.ofNullable(wordCount);
    }

    public Optional<BigDecimal> getCalculatedValue() {
        return Optional.ofNullable(calculatedValue);
    }

    public void setCalculatedValue(double calculatedValue) {
        this.calculatedValue = BigDecimal.valueOf(calculatedValue);
    }
}

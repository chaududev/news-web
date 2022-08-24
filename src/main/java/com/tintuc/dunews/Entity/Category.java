package com.tintuc.dunews.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "Category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "category_name"),
        @UniqueConstraint(columnNames = "category_key") })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AbstractEntity{
    @Column(name = "category_key",unique = true, nullable = false)
    private String categoryKey;
    @Column(name = "category_name",unique = true, nullable = false)
    private String categoryName;
}

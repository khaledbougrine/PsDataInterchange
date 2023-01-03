package com.peoplespheres.entites;

// Lombok imports

import com.google.common.base.Objects;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/** Entity to manage the persistence of the transformations available to transform the data source to provide the expected data target */
@Entity
@Cacheable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transformation")
@EntityListeners(AuditingEntityListener.class)
@Slf4j
@EqualsAndHashCode
public class TransformationEntity extends AAuditableVersionedEntity {
    public TransformationEntity(@NonNull final TransformationEntity referenceTransformation) {
        this.parameters = referenceTransformation.getParameters();
        this.position = referenceTransformation.getPosition();
        this.name = referenceTransformation.getName();
        this.isActive = referenceTransformation.getIsActive();
        this.module = referenceTransformation.getModule();
        this.transformationRule = referenceTransformation.getTransformationRule();
        this.mapping = referenceTransformation.getMapping();
    }

    /** The unique identifier associated to this transformation */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /** A pipe separated list of parameters given to the associated transformation rule */
    @Column(name = "parameters", length = 1000)
    @Nullable
    private String parameters;

    /** The position of application of the associated transformation */
    @Column(name = "\"position\"")
    @NotNull(message = "{transformation.position.not-null}")
    @PositiveOrZero(message = "{transformation.position.positive}")
    private Integer position;

    /** The name given to this transformation */
    @Column(name = "name")
    @Nullable
    private String name;

    /** Boolean flag indicating if this transformation is active */
    @Column(name = "is_active", nullable = false)
    @NotNull(message = "{transformation.active.not-null}")
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransformationEntity)) return false;
        TransformationEntity that = (TransformationEntity) o;
        return Objects.equal(getId(), that.getId()) && Objects.equal(getParameters(), that.getParameters()) && Objects.equal(getName(), that.getName()) && Objects.equal(getMapping(), that.getMapping()) && Objects.equal(getModule(), that.getModule()) && Objects.equal(getTransformationRule(), that.getTransformationRule());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

//////////////////
    // ASSOCIATIONS //
    //////////////////
    /** The flow associated to this data */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mapping_id", nullable = false, foreignKey = @ForeignKey(name = "FK_TRANSFORMATION_FLOW"))
    @NotNull
    private MappingEntity mapping;

    /** The module associated to this data */
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "module_id", nullable = false, foreignKey = @ForeignKey(name = "FK_TRANSFORMATION_MODULE"))
    private ModuleEntity module;

    /** The set of transformation rules composing this data transformation */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transformation_rule_id", foreignKey = @ForeignKey(name = "FK_TRANSFORMATION_TRANSFORMATION_RULE"))
    @Nullable
    private TransformationRuleEntity transformationRule;
}

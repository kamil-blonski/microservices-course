package guru.springframework.mscbeerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
	private UUID id;

	@Version
	private Long version;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createDate;

	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	private String beerName;
	private  String beerStyle;

	@Column(unique = true)
	private String upc;

	private BigDecimal price;
	private Integer minOnHand;
	private Integer quantityToBrew;
}

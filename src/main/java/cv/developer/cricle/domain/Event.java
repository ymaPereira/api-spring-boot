package cv.developer.cricle.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

	@ApiModelProperty(hidden = true)
	@Id
	@Column(length = 36)
	private String id;
	@NotBlank
	@Column(nullable = false)
	private String theme;
	@NotBlank
	@Column(nullable = false)
	private String description;
	@NotBlank
	@Column(length = 100, nullable = false)
	private String autor;
	@FutureOrPresent
	@Column(nullable = false)
	private LocalDate eventDate;
	@NotBlank
	@Column(nullable = false)
	private String organizers;
	@Column(nullable = true)
	private String guests;
}

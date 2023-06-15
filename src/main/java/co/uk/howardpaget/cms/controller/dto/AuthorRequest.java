package co.uk.howardpaget.cms.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record AuthorRequest(
    @NotNull @NotBlank String name,
    @NotNull @NotBlank String bio) {

}

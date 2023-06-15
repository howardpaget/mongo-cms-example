package co.uk.howardpaget.cms.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record PostRequest(
    @NotNull @NotBlank String title,
    @NotNull @NotBlank String authorId,
    @NotNull LocalDateTime publishedDateTime,
    @NotNull List<String> tags,
    @NotNull @NotBlank String body) {

}

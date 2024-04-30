package dev.startup.runner.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        @Positive
        LocalDateTime completedOn,
        Integer miles,
        Location location
)  {

}

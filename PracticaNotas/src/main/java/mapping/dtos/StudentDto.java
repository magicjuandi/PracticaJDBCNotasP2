package mapping.dtos;

import domain.enums.Semester;

public record StudentDto(Long id,
                         String name,
                         String email,
                         String semester) {
}

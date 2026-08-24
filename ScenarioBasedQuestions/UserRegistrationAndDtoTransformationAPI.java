package ScenarioBasedQuestions;

import java.time.LocalDateTime;

class User {
    private Long id;
    private String fullName;
    private String email;
    private String passwordHash;
    private LocalDateTime registeredAt;

    public User(Long id, String fullName, String email, String passwordHash, LocalDateTime registeredAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    @Override
    public String toString() {
        return String.format("User[id=%s, fullName='%s', email='%s', hash='%s', registeredAt=%s]",
        id, fullName, email, passwordHash, registeredAt);
    }
}

class UserRegistrationDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String rawPassword;
    
    public UserRegistrationDto(String firstName, String lastName, String email, String rawPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rawPassword = rawPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRawPassword() {
        return rawPassword;
    }
}

class UserMapper {

    public User toEntity(UserRegistrationDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Registration data cannot be null");
        }

        if (dto.getEmail() == null || !dto.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format: " + dto.getEmail());
        }

        if (dto.getRawPassword() == null || dto.getRawPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        String combinedName = dto.getFirstName() + " " + dto.getLastName();
        String hashedPassword = "HASHED_" + dto.getRawPassword();

        return new User( null,combinedName, dto.getEmail(), hashedPassword, LocalDateTime.now());
    }
}

public class UserRegistrationAndDtoTransformationAPI {
    public static void main(String[] args) {
        UserMapper mapper = new UserMapper();

        System.out.println("--- Test !: Valid User Registration ---");
        UserRegistrationDto validDto = new UserRegistrationDto("Harish", "Swain", "harish@gmail.com", "secret123");
        User user = mapper.toEntity(validDto);
        System.out.println("Mapped Entity: " + user);

        System.out.println("\n--- Test 2: Invalid Short Password ---");
        try {
            UserRegistrationDto invalidDto = new UserRegistrationDto("Amit", "Kumar", "amit@gmail.com", "123");
            mapper.toEntity(invalidDto);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Validation Error: " + e.getMessage());
        }
    }
}

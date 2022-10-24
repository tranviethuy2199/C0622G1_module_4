package codegym.dto;

import org.thymeleaf.util.Validate;

import javax.validation.constraints.*;

public class Userdto  {
    @NotEmpty(message = "không được để trống")
    @Size(min = 5, max = 45 , message = "nhập sai định dạng")
    private String firstName;
    @NotEmpty(message = "không được để trống")
    @Size(min = 5, max = 45 ,message = "nhập sai định dạng")
    private String lastName;
    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8}))" , message = "nhập sai định dạng")
    private String phoneNumber;
    @Min(18)
    private int age;
    @Email(message = "nhập sai định dạng email")
    private String email;


    public Userdto() {
    }

    public Userdto(@NotEmpty
                @Size(min = 5, max = 45) String firstName,
                @NotEmpty
                @Size(min = 5, max = 45) String lastName,
                @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8}))")
                        String phoneNumber,
                @Min(18)
                        int age,
                @Email
                        String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package pl.edu.pjatk.gym_management_system.model;

import pl.edu.pjatk.gym_management_system.model.enums.Gender;
import pl.edu.pjatk.gym_management_system.model.enums.TrainerQualifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "qualifications")
    private TrainerQualifications qualifications;



    public Trainer() {
    }

    public Trainer(Long id, String firstName, String lastName, int age, Gender gender, TrainerQualifications qualifications) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.qualifications = qualifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public TrainerQualifications getQualifications() {
        return qualifications;
    }
}

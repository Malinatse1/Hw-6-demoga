package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static tests.TestData.*;
import static utils.RandomUtils.*;

public class RegistrationWithFakerTests extends TestBase {


    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("en"));
        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Female",
                phone = faker.phoneNumber().subscriberNumber(10),
                birthDay = String.valueOf(faker.number().numberBetween(0, 31)),
                birthMonth = "June",
                birthYear = String.valueOf(faker.number().numberBetween(1900, 2022)) ,
                subject = "English",
                hobbies = "Sports",
                uploadFile = "src/test/resources/Screenshot_188.png",
                currentAdress = faker.lebowski().quote(),
                state = "NCR",
                city = "Delhi",
                pictureName = "Screenshot_188.png";

        //Open page
        registrationPage.openPage()
        // Add  First Name
        .setFirstName(userName)
        // Add Last Name
        .setLastName(lastName)
        // Add Email
        .setEmail(email)
        // Add Gender
        .setGender(gender)
        // Add Mobile
        .setPhone(phone)
        // Add Date of Birth
        .setBirthDate (birthDay,birthMonth,birthYear)
        // Add Subjects
        .setSubject(subject)
        // Add Hobbies
        .setHobbies(hobbies)
        // Add Picture
         .setUploadFile(uploadFile)
        // Add Current Address;
        .setCurrentAddress(currentAdress)
        // Add State
         .setState(state)
        // Add City
         .setCity(city)
        // Click on Submit
        .setSubmit();
        // Check
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", birthDay)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", pictureName)
                .verifyResult("Address", currentAdress)
                .verifyResult("State and City", state + " " + city);


    }
}
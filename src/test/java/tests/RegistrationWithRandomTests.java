package tests;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.randomString;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;
import static utils.RandomUtils.*;
public class RegistrationWithRandomTests extends TestBase {


    @Test
    void fillFormTest() {
        String userName = randomString(10),
                lastName = randomString(10),
                email = randomEmail(10) ,
                gender = "Female",
                phone = randomPhone("10",11111111L,999999999L),
                birthDay = "23",
                birthMonth = "June",
                birthYear = "1992",
                subject = "English",
                hobbies = "Sports",
                uploadFile = "src/test/resources/Screenshot_188.png",
                currentAdress = "Moscow,Lenina 152",
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
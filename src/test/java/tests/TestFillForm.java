package tests;

import com.codeborne.selenide.Condition;
        import com.codeborne.selenide.Configuration;
        import com.codeborne.selenide.WebDriverRunner;
        import org.junit.jupiter.api.AfterAll;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import com.codeborne.selenide.selector.ByText;
import pages.RegistrationPage;


import java.io.File;

        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selenide.*;

public class TestFillForm extends TestBase {


    @Test
    void fillFormTest() {
        String userName = "Nataly";
        String lastName = "Bochkova";
        String email = "Nataly@natal.com";
        String gender = "Female";
        String phone = "7999999999";
        String birthDay = "23";
        String birthMonth = "June";
        String birthYear = "1992";
        String subject = "English";
        String hobbies = "Sports";
        String uploadFile = "src/test/resources/Screenshot_188.png";
        String currentAdress = "Moscow,Lenina 152";
        String state = "NCR";
        String city = "Delhi";
        String pictureName = "Screenshot_188.png";

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
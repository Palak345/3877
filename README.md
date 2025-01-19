# OrangeHRM Website Tested with Selenium and Cucumber

<img src="https://github.com/user-attachments/assets/066a833c-dcd4-4f38-8476-ba146207ae5a" height="150"/>


## 📌 Project Overview

This project focuses on automation testing for the OrangeHRM demo website using **Selenium WebDriver** with the **Page Object Model (POM)** and **Cucumber** for Behavior-Driven Development (BDD). The primary objective is to verify core functionalities such as login, user management, leave management, attendance tracking, and reporting. The framework is designed for modularity, reusability, and scalability, ensuring robust and maintainable test coverage.

---

## 🛠 Tools and Technologies Used

### Testing and Automation

| <img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/Selenium_Logo.png" alt="Selenium" width="50"/> | <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" alt="Java" width="50"/> | <img src="https://static.javatpoint.com/tutorial/cucumber/images/cucumber-testing-tutorial.png" alt="Cucumber" width="53"/> |
|:-----------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------:|
| **Selenium WebDriver**: Automates web browsers for testing.                              | **Java**: The programming language used for writing test scripts.                            | **Cucumber**: Supports Behavior-Driven Development (BDD) with Gherkin syntax for testing.      |

### Build and Reporting

| <img src="https://maven.apache.org/images/maven-logo-black-on-white.png" alt="Maven" width="50"/> | <img src="https://junit.org/junit4/images/junit-logo.png" alt="JUnit" width="50"/> |
|:--------------------------------------------------------------------:|:------------------------------------------------------:|
| **Maven**: Dependency management tool for automating the build process. | **JUnit**: Framework for running and organizing tests. |


### Code Management

| <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" alt="GitHub" width="50"/> | <img src="https://upload.wikimedia.org/wikipedia/commons/8/8e/Page-object-model-diagram.png" alt="POM" width="50"/> |
|:-----------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------:|
| **GitHub**: Used for version control and collaboration on the project.                | **POM (Page Object Model)**: Design pattern used to separate UI logic from test scripts.      |


## 🧪 Features Tested

1. **Login Functionality**  
   - Validated successful login and logout for various user roles.  
   - Ensured appropriate error messages for invalid credentials.  

2. **User Management**  
   - Tested the addition, editing, and deletion of employee records.  
   - Verified proper role-based access and permissions.  

3. **Leave Management**  
   - Validated workflows for leave requests, approvals, and rejections.  
   - Ensured accurate updates to leave balances and proper data in leave history.  

4. **Attendance Tracking**  
   - Tested employee clock-in and clock-out functionality.  
   - Verified data accuracy in attendance reports.  

5. **Reporting and Analytics**  
   - Checked the generation of reports across different modules.  
   - Ensured data export functionality works correctly.  

6. **UI and Cross-Browser Testing**  
   - Verified responsiveness on desktop, tablet, and mobile devices.  
   - Tested compatibility across Chrome, Firefox, and Edge.  

---

## 📂 Artifacts Included

1. **Feature Files**  
   - Written in Gherkin syntax, covering scenarios for modules like login, user management, and leave management.  

2. **Page Object Model (POM)**  
   - Contains modular and reusable page classes for each application section.  
   - Follows best practices to separate logic from test scripts.  

3. **Test Runner**  
   - Configured for executing specific feature files or scenarios using tags.  
   - Supports parallel test execution for faster results.  

---

## 🚀 How to Run Tests in Eclipse

### **Prerequisites**

1. Install **Java** (JDK 8 or higher).  
2. Install **Eclipse IDE for Java Developers** from [Eclipse Downloads](https://www.eclipse.org/downloads/).  
3. Install **Maven** and configure it in your system.  
4. Install the **Cucumber Eclipse Plugin**:  
   - Go to **Help > Eclipse Marketplace**.  
   - Search for "Cucumber" and install the plugin for Gherkin syntax support.

### **Steps to Execute Tests**

1. **Import the Project**  
   - Open Eclipse.  
   - Go to **File > Import > Maven > Existing Maven Projects**.  
   - Browse to the project directory and click **Finish**.  

2. **Resolve Dependencies**  
   - Right-click the project in Eclipse.  
   - Select **Maven > Update Project** to download all required dependencies from the `pom.xml` file.  

3. **Run the Test Runner**  
   - Navigate to the test runner file in `src/test/java`. 
   - Right-click the runner file and select **Run As > JUnit Test**.  

4. **View Test Results**  
   - Check the **Console** tab in Eclipse for execution logs.  
   - Generated reports will be available in the `target/cucumber-reports` directory.
  
### Group Presentation video
 https://drive.google.com/file/d/1fpSJ4bRMtshxZVj7vEZrmWpUhOdrx0XU/view?usp=sharing 


## 📊 Conclusion

This project demonstrates a robust and scalable test automation framework for the OrangeHRM application, leveraging the best practices of Selenium, Cucumber, and POM design. It ensures comprehensive coverage, maintainability, and adaptability for real-world testing needs. The tools and methodologies used in this project aim to deliver efficient and effective test results with a focus on reliability and ease of use.

---

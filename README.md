A Patient Information Consultion System, completed by Du Chang 'an during his internship in Suzhou Minimally Invasive Orthopedics (Group) on June 2023.
This is a website that helps orthopedic surgeons manage information about their patients.

This website project uses java as the core language, using the idea editor. The website project uses SSM framework, which is generally divided into five layers: front-end 
page, servlet layer, service layer, mapper layer, and underlying database. The front-end page uses html, jsp, css, element-ui, vue and other tools; The servlet layer is used 
to communicate front-end data and service layer. service layer is used to interact with mapper layer; The mapper layer directly controls the database. The final back-end
database is developed using mysql and written using navicat. The process also includes the application of maven, session and other tools.

Surgeons can sign up and login the website as a user, it provides a verification code to avoid bot register and website cookies to remember account and passwords.

<img width="410" alt="login" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/2100cd2e-1160-4dbf-b0fc-08f1e158584d">
<img width="317" alt="signup" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/7bb7ebfb-ac62-451a-8dd0-ef6833e87dd9">

Then it shows a list of patients managed by surgeon. The system record each patient's id number, name, age, symptom description status(in progressor completed) and bone models.

<img width="960" alt="patientslist" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/2643ce1f-bda8-4879-aae8-08d538147b5d">

Users can delete or batch delete patient items; 

<img width="960" alt="delete" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/44d79b7f-4a18-4f53-a37e-2784ce00b9c1">

Users can update a patient's information;

<img width="960" alt="update" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/fda3fb49-583c-4fe7-8177-819781f9fce1">

Users can add a new patient item;

<img width="401" alt="add" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/d11d897a-2894-43fc-8374-918d7e9d7093">

User can search in keywords and sort patients in different conditions;

<img width="960" alt="search" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/23b3f370-722f-482d-887f-188a60a7ddd5">

User can view the 3D models of bones, and rotating and zooming later for details; User also can upload new 3d models of bones and select one of models for viewing;

<img width="960" alt="models" src="https://github.com/AndrewDu526/ChanganPersonalProject/assets/137496018/8252a5ab-0b14-4e4a-8e47-398552145513">

How to run:
download the project, run it by tomcay7 under maven, in IDEA platform 

<img width="166" alt="image" src="https://github.com/AndrewDu526/PatientsInfoMgmtSys/assets/137496018/e58686b8-bcaf-4c66-af21-bc668e95cc21">

login: http://localhost:8080/JavaWeb_last/homePage/login.jsp
sign up: http://localhost:8080/JavaWeb_last/homePage/register.jsp

Existing drawbacks:
1. cannot upload or delete 3d models by website, instead only works by directly managing database
2. cannot contains and show a list of 3d models under one patient, can only show one model
3. some variable in database and web are mixed up, eg input variable, like "name" in adding page will change the default value in search windows
4. some variables' name are not matched to the circumstance, eg "brand" should be "name"
5. wrong page redirection when login up from sign up page, redirecting to login.html instead of login.jsp
6. implements model viewing function by "strings", ineffectives
7. automatically check the "Select all" check box when taking batch delete
8. too lagre size of sign up page
9. need refresh after adding item
10. [planned new function]more functions in vewing models, eg comparing, color classification...
11. [planned new function]admin accounts which can mange other normal users 


#### CSV uploader program.<br>
Program for uploading csv file and write extracted information to MySQL DB.<br>

Technologies/Frameworks: 
- Spring Boot, OpenCSV, Maven.<br>
Database:
- MySQL.<br>

#### UploadController
POST - to upload CSV file and parse it to DB.<br>

#### InformationController
GET - get all employees<br> 
GET - get employees with the highest salary per department<br>
GET - get all departments where each department contains employees sorted by salary descending<br>

Start the project:
Download project from Github.<br>
Open it in your IDE.<br>
Connect to DB MySQL<br>

For tests, please install [POSTMAN](https://www.postman.com)

# CraftProject
Application Module for driver onboarding in Ride Management System

Tech Stack Used:
1. Java - Spring Boot
2. Mysql DB

APIs for driver onboarding:
1. For adding driver profile: POST /driver 
2. For getting driver details based on id - GET /driver/{id}
3. For uploading documents - POST /uploadFile
4. Documents Verified - PUT /driver/{driverId}/documentsVerified
5. Mark driver ready for taking rides - PUT /driver/{driverId}/markActive

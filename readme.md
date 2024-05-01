# Campsite Reviewer

### Problem Statement
When planning a camping trip to a state park with kids and dogs, there are a lot of factors  to consider when deciding on a campsite. 
Is the site  shaded? Is the site large enough to fit you tent or camper as well as your canopy? How easy is it to access the bathrooms? Will your dogs be bothered by people nearby because the site is not very private? Is the site next to a busy road or cliff that could be dangerous to kids?
When looking at the state park website, you are provided with one or two pictures of campsites, a driveway length/grade  and very little other  information. You could spend time searching social media groups or random blog posts for more information about different state parks and campsites within them.
The goal of my project would be to provide a centralized place  where people can review the sites they have stayed at so that others can get helpful information and people’s opinions about specific campsites or campgrounds in the state park system.


### Project Technologies/Techniques

* Security/Authentication
    * AWS Cognito
* Database
    * MySQL 8.x
* ORM Framework
    * Hibernate Version TBD
* Dependency Management
    * Maven
* Web Services consumed using Java
    * zipcodeapi
* CSS
    * template created with mobirise
* Logging
    * Log4J2
* Hosting
    * AWS
* Unit Testing
    * JUnit tests to cover all testable logic
* IDE: IntelliJ IDEA
* Generating Mock Data: Mockaroo

* Technologies I may want to implement
    * Hibernate validator
    * Hibernate search



### Version 2 tasks
* Improve Styling
* move all style tags our of jsps
* Add campground table
* Add campsite table
* update Cognito log in so that zipcode is required to create an account
* update Auth to get all user info from the login, not just the username and email
* add time stamp to reviews to make getting recent reviews easier
* add an option to add a photo to a review


#### [User Stories](DesignDocuments/UserStories.md)
#### [Screen Design](DesignDocuments/Screens.md)


#### [Project Plan](ProjectPlan.md)


#### [TimeLog](TimeLog.md)

#### [Video Demo](https://youtu.be/onlEQqG-i2w)

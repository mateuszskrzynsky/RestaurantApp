Design task: Seat reservation system in a restaurant

Objective:

Creation of a REST application enabling reservation of tables in restaurants. The application will allow users to browse available restaurants, 
view the table plan in a selected restaurant, make reservations, as well as manage reservations for restaurant owners.

Functionalities:

1.Restaurant management:
-Registration of restaurants by owners.
-Adding restaurant information such as name, address, opening hours, photos.
-Management of available tables and their arrangement in the restaurant.

2.Table reservation:
-Browse available restaurants with the option of filtering by location, type of cuisine, and ratings.
-Selecting a restaurant and viewing available tables along with a restaurant layout plan.
-Making a reservation for a selected date and time.
-Cancellation of the reservation by the user.

3.Reservation management (for restaurant owners):
-View all reservations for your restaurant.
-Confirm or reject a reservation.
-Table management and their availability.

4.Ratings and reviews system:
-Adding ratings and reviews by users after visiting a restaurant.
-View restaurant ratings and reviews.

Technical requirements:
1.Spring Boot for the backend.
2.Spring Data JPA with a SQL database (e.g. PostgreSQL) or Spring Data MongoDB for NoSQL.
3.Spring Security for user authentication and authorization.
4.JWT for stateless authentication.
5.JUnit and Mockito for unit and integration testing.
6.Swagger or SpringDoc OpenAPI for API documentation.

## Retail API

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast.
myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps.
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API,
which will aggregate product data from multiple sources and return it as JSON to the caller.
---
#### Objective:
* Your goal is to create a RESTful service that can retrieve product and price details by ID.
* The URL structure is up to you to define, but try to follow some sort of logical convention.
* Build an application that performs the following actions:
    - Responds to an HTTP GET request at `/products/{id}` and delivers product data as JSON (where `{id}` will be a number.
---

* Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793)
* Example response:
    `{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}`
* Performs an HTTP GET to retrieve the product name from an external API.
    - (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail)
* Example: [http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics]
* Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.
    - BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response,
        and updates the product’s price in the data store.


#### Tips:
* Use nouns in your URL not verbs.
* Use path elements to identify resources.
* Use lower snake_case (retail_api/products/{id})
* Create-Read-Update-Delete maps to POST, GET, PUT, DELETE (HTTP verbs)


#### Status codes:
* 200 - Ok, Success.
* 201 - Created. (usually used for HTTP POST)
* 202 - Request accepted. (usually used for Async calls)
* 204 - Request successful, no content returned (usually used for Deletes)
* 400 - Bad request. (accompanied with error message)
* 401 - Unauthorized.
* 403 - Forbidden
* 404 - Resource not found.
* 405 - Method not allowed.
* 413 - Payload too large.
* 500 - Internal server error.
* 503 - Service unavailable.
* 504 - Gateway timed-out


#### Pagination:
* `/user/repos?page=2&per_page=10`
    - get 2nd page and limit entries to 10.
* provide references to next page and last page in response headers.
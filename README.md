How to start the application:
    Start the main class: com.example.demo.CustomerApplication

Adding a new customer:
    POST /customer HTTP/1.1
    Host: localhost
    Content-Type: application/json
    cache-control: no-cache
    {
        "name": "David",
        "email": "test@test.com"
    }

Retriving a list of customers:
    GET /customer HTTP/1.1
    Host: localhost
    Content-Type: application/json
    cache-control: no-cache

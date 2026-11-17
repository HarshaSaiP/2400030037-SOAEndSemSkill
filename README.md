# Spring Boot + MySQL Docker Compose Experiment

This project runs two containers:
- `app-service`: Spring Boot REST API on port 8080
- `app-db`: MySQL database on port 3306

## Requirements
- Docker Desktop (or Docker Engine)
- Docker Compose v2 (`docker compose`)

## Run
Open a terminal in this project folder and run:

```bash
docker compose up -d --build
```

Check containers:

```bash
docker compose ps
```

Test the API:

```bash
curl http://localhost:8080/api/data
```

Open this URL in a browser if preferred:

`http://localhost:8080/api/data`

Expected response:

```json
{
  "status": "success",
  "message": "Data retrieved successfully",
  "data": [
    {"id": 1, "name": "Harsha"},
    {"id": 2, "name": "Sai"}
  ]
}
```

The exact IDs/order can differ if the database volume already contains data.

Health endpoint:

`http://localhost:8080/api/health`

View logs:

```bash
docker compose logs -f app-service
docker compose logs -f app-db
```

Stop containers:

```bash
docker compose down
```

Stop containers and delete the database volume (this permanently removes stored database data):

```bash
docker compose down -v
```

## How it works
Docker Compose creates a shared network. The Spring Boot application connects to MySQL using
the service hostname `app-db`, not `localhost`. The database health check ensures MySQL is ready
before the application container starts.

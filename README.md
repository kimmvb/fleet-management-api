
# Fleet Management API 🚖

**Rest API** for a taxi fleet management system in Beijing, China 🇨🇳. Query the locations of nearly **2 thousand taxis** in real-time and ensure an optimal user experience.

    > This project was developed with Java and Spring Boot 🍵




## API Reference ⛓️

### Taxis 🚖

#### Get all taxis 🚕

```http
  GET /api/v1/taxi
```

| Parameter    | Type     | Description               | Example |
|:-------------|:---------|:--------------------------|:--------|
| `pageNumber` | `string` | **Required**. Page Number | *0*     |
| `pageSize`   | `string` | **Required**. Page Size   | *10*    |

### Trajectories 🗺️

#### Get all trajectories from a taxi 🚖🗺️

```http
  GET /api/v1/trajectory/${taxi_id}
```
| Parameter    | Type     | Description               | Example |
|:-------------|:---------|:--------------------------|:--------|
| `taxi_id`    | `string` | **Required**. Taxi's id   | *6418*  |
| `pageNumber` | `string` | **Required**. Page Number | *0*     |
| `pageSize`   | `string` | **Required**. Page Size   | *10*    |

#### Get all trajectories from a taxi on a specific date 🚖🗺️📅

```http
  GET /api/v1/trajectory/${taxi_id}/${date}
```
| Parameter    | Type     | Description                          | Example      |
|:-------------|:---------|:-------------------------------------|:-------------|
| `taxi_id`    | `string` | **Required**. Taxi's id              | *6418*       |
| `date`       | `string` | **Required**. Specific date to fetch | *02-02-2008* |
| `pageNumber` | `string` | **Required**. Page Number            | *0*          |
| `pageSize`   | `string` | **Required**. Page Size              | *10*         |

#### Get all last trajectories from all taxis 🚖🚖🚖🗺️📌

```http
  GET /api/v1/trajectory/last_locations
```
| Parameter    | Type     | Description               | Example |
|:-------------|:---------|:--------------------------|:--------|
| `pageNumber` | `string` | **Required**. Page Number | *0*     |
| `pageSize`   | `string` | **Required**. Page Size   | *10*    |



## Tests 🛠️

To ensure our project functionalities were working properly, they were conducted using **JUnit** and **Mockito**.


https://github.com/kimmvb/fleet-management-api/assets/137528066/8e07f66d-53f3-4667-a3e0-0fcb7b8df303


    > There were e2e tests and unit tests. 




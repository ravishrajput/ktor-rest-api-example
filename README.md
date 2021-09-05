# ktor-rest-api-example
[![ravishrajput](https://img.shields.io/badge/ravishrajput-androiddeveloper-green.svg)](http://ravishrajput.com/)
[![Coroutines](https://img.shields.io/badge/Ktor-APIs-blue.svg)](https://kotlinlang.org/docs/reference/coroutines.html)

<p align="center">
  <img src="/docs/ktor-rest-apis.png">
</p>

In this example you will learn how Ktor has provided a Simple way of developing your own REST API client with Kotlin and Coroutines with Exposed SQL Framework. 

### Endpoints

| Endpoint | Request | Description |
| --- | --- | --- |
| `/v1/user` | GET | Response of All Users |
| `/v1/user/{id}` | GET | Get Specific User by Id |
| `/v1/user/{id}` | DELETE | Delete the user data |
| `/v1/user` | POST | Add new User data |

GET `/v1/user` : get all users list

Response:

    {
        "users": [
            {
                "id": 1,
                "name": "ravish",
                "username": "ravishraj",
                "email": "ravishraj@abc.com",
                "imageUrl": "none"
            },
            {
                "id": 2,
                "name": "Anil",
                "username": "anilraj",
                "email": "anilraj@abc.com",
                "imageUrl": "none"
            }
        ]
    }

GET `/v1/user/{id}` : get user by id

Response:

    {
        "id": 2,
        "name": "Anil",
        "username": "anilraj",
        "email": "anilraj@abc.com",
        "imageUrl": "none"
    }

DELETE `/v1/user/{id}` : delete a user details by id

Response:

    {
        "code": 200,
        "message": "Record deleted!"
    }

POST `/v1/user` : Add new User Data

Request: 

| Key | Type |
| --- | --- |
| name | String |
| username | String |
| email | String |
| imageUrl | String |

Response:


    {
        "code": 200,
        "message": "User Added Successfully!"
    }



### License
```
   Copyright (C) 2021 ravishrajput.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
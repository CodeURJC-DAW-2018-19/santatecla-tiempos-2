

# santatecla-tiempos-2 - API REST Documentation
--------

## About our API
Our API REST is about categories, events, times and intervals in them. If you want to use it just
follow these rules, either way you will probably recieve error messages.

## API requests

### Resources
The resource API has GET, POST, PUT and DELETE methods.
http: // localhost: 8080 followed by the containt request URL.

**All API queries have been preceded by /api**
## **Every operation as addition, modification or deleting is only available for admin role.**

#### LOGIN
Resource to log in the application.

* ##### URL

	< /login/ >

* ##### Method:

	`GET`

* ##### Login Role Used: Admin
	

* ##### Success Response:
	
	```
	{
    		"id": 66,
    		"username": "admin",
    		"password": "$2a$10$GfiWtkcdbkyVnUonmXYMEOK9vDSQ9llPEKj1T6kbYc8QUKWw7VBAa",
    		"rol": [
				"ROLE_USER",
				"ROLE_ADMIN"
    		]
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED


* ##### Login Role Used: User
	

* ##### Success Response:
	
	```
	{
   	 	"id": 65,
    	 	"username": "Marcos",
   	 	"password": "$2a$10$icXSuiXsow7atuSbRfTH..BhU4cQnAdC2QFXsM/VBpOre5sJuowM6",
    	 	"rol": [
     	   		"ROLE_USER"
   	 	]
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED

#### LOGOUT
Resource to log out the application.

* ##### URL

	< /logout/ >

* ##### Method:

	`GET`

* ##### Login Role Used: Admin
	

* ##### Success Response:
	
	```
	true
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED

#### Pagination
Resource to search a specific page in the application.
For example searching first page after the default one in categories.

* ##### URL

	< /categories/ >

* ##### Method:

	`GET`

* ##### Example of query:

	* URL
		
		`/api/categories/?page=1`

* ##### Success Response:
	
	```
	{
    		"content": [
				{
            			"id": 6,
            			"nameCategory": "Categoria12"
				},
				{
            			"id": 7,
            			"nameCategory": "Categoria13"
				},
				{
            			"id": 8,
            			"nameCategory": "Categoria14"
				},
				{
           			"id": 9,
           			"nameCategory": "Categoria15"
				},
				{
            			"id": 10,
            			"nameCategory": "Categoria16"
				}
			]
	}
	```
	
* ##### Error Response:

	**Code**: No errors available

## Show items
Available for every role.

#### Categories
Shows first five categories.

* ##### URL:

	< /categories/ >

* ##### Method:

	`GET`
	
* ##### Success Response:
  
  	```
	{
		"content":[
			{
	    			"id": 1,
	    			"nameCategory": "Examenes"
			},
			{
	    			"id": 2,
	    			"nameCategory": "Prácticas"
			},
			{
	    			"id": 3,
	    			"nameCategory": "Apuntes"
			},
			{
	    			"id": 4,
	    			"nameCategory": "Categoria10"
			},
			{
	    			"id": 5,
	    			"nameCategory": "Categoria11"
			},
		]	    		
	}
	```
  
* ##### Error response:

	**Code**: 401 UNAUTHORIZED
	
#### Events  
Shows first five events.

* ##### URL:

	< /events/ >

* ##### Method:

	`GET`

* ##### Success Response:

	```
	{
    		"content": [
				{
            			"id": 41,
            			"nameEvent": "DAW",
            			"date": "7-7-2019",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [
					{
                    				"id": 1,
                    				"nameCategory": "Examenes"
					}
					],
            			"photo": null,
            			"encodedImage": null
				},
				{
            			"id": 42,
            			"nameEvent": "Seguridad",
            			"date": "20-12-18",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
				},
				{
            			"id": 43,
            			"nameEvent": "Java",
            			"date": "1-1-19",
            			"location": "Aulario 2",
            			"wiki": "Aulario 2",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
				},
				{
            			"id": 44,
            			"nameEvent": "DAW",
            			"date": "7-7-2019",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
				},
				{
            			"id": 45,
            			"nameEvent": "Seguridad",
            			"date": "20-12-18",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
				}
			]
	}
	```

  * ##### Error Response:

	**Code**: 401 UNAUTHORIZED OR 404 NOT FOUND

#### Times
Shows first five times.

* ##### URL:

	< /times/ >

* ##### Method:

	`GET`

* ##### Success Response:

	```
	{
		"content": [
			{
            		"id": 52,
            		"nameInterval": "Intervalo 1",
            		"startDate": "5-7-2018",
            		"endDate": "1-1-2020",
            		"events": [
			{
                    	"id": 41,
                    	"nameEvent": "DAW",
                    	"date": "7-7-2019",
                    	"location": "Aulario 1",
                    	"wiki": "Aulario 1",
                    	"hasImage": false,
                    	"categories": [
			{
                            "id": 1,
                            "nameCategory": "Examenes"
			}
			],
                    	"photo": null,
                    	"encodedImage": null
			},
			{
                    	"id": 42,
                    	"nameEvent": "Seguridad",
                    	"date": "20-12-18",
                    	"location": "Aulario 1",
                    	"wiki": "Aulario 1",
                    	"hasImage": false,
                    	"categories": [],
                    	"photo": null,
                    	"encodedImage": null
			},
			{
                    	"id": 43,
                    	"nameEvent": "Java",
                    	"date": "1-1-19",
                    	"location": "Aulario 2",
                    	"wiki": "Aulario 2",
                    	"hasImage": false,
                    	"categories": [],
                    	"photo": null,
                    	"encodedImage": null
			}
			],
            		"subIntervals": [
                		{
                    		"nameSubTime": "2018",
                    		"startDate": "8-9-2018",
                   		"endDate": "10-10-2018",
                    		"subTimes": []
                		},
                		{
                    		"nameSubTime": "2019",
                    		"startDate": "10-1-2019",
                    		"endDate": "20-11-2019",
                    		"subTimes": []
				}
				]
			},
			{
            		"id": 55,
            		"nameInterval": "Intervalo 2",
            		"startDate": "2-1-2020",
            		"endDate": "1-3-2020",
            		"events": [],
            		"subIntervals": []
			},
			{
            		"id": 56,
            		"nameInterval": "Intervalo 3",
            		"startDate": "2-4-2021",
            		"endDate": "2-5-2021",
            		"events": [],
            		"subIntervals": []
			},
			{
           		"id": 57,
            		"nameInterval": "Intervalo 4",
            		"startDate": "5-7-2018",
            		"endDate": "1-1-2020",
            		"events": [],
            		"subIntervals": []
			},
			{
            		"id": 58,
            		"nameInterval": "Intervalo 5",
            		"startDate": "2-1-2020",
            		"endDate": "1-3-2020",
            		"events": [],
            		"subIntervals": []
			}
    			]
	}
	```

  * ##### Error Response:

	**Code**: 401 UNAUTHORIZED OR 404 NOT FOUND

### Search Category by name
Resource to show categories with a given name.

* ##### URL

	< /categories/{name} >

* ##### Method:

	`GET`
	
* ##### Example of query:

	* URL
		
		`/api/categories/Examenes`
  
* ##### Success Response:

  	```
	[
    	{
			"id": 1,
			"nameCategory": "Examenes"
    	}
	]		
	```
  
* ##### Error Response:

	**Code**: NO ERRORS AVAILABLE.

### Search Event by name
Resource to show events with a given name.

* ##### URL

	< /categories/{event} >

* ##### Method:

	`GET`
	
* ##### Example of query:

	* URL
		
		`/api/events/DAW`
  
* ##### Success Response:

  	```
	[
    		{
        			"id": 41,
        			"nameEvent": "DAW",
        			"date": "7-7-2019",
        			"location": "Aulario 1",
        			"wiki": "Aulario 1",
        			"hasImage": false,
        			"categories": [
            			{
                			"id": 1,
                			"nameCategory": "Examenes"
            			}
        			],
        			"photo": null,
        			"encodedImage": null
    		},
    		{
        			"id": 44,
        			"nameEvent": "DAW",
        			"date": "7-7-2019",
        			"location": "Aulario 1",
        			"wiki": "Aulario 1",
        			"hasImage": false,
        			"categories": [],
        			"photo": null,
        			"encodedImage": null
    		}
	]	
	```
  
* ##### Error Response:

	**Code**: NO ERRORS AVAILABLE. 

### Search Times by ID
Resource to show times with a given ID

* ##### URL

	< /times/{ID} >

* ##### Method:

	`GET`
	
* ##### Example of query:

	* URL
		
		`/api/times/55`
  
* ##### Success Response:

  	```
	{
    		"id": 55,
    		"nameInterval": "Intervalo 2",
    		"startDate": "2-1-2020",
    		"endDate": "1-3-2020",
    		"events": [],
    		"subIntervals": []
	}
	```
  
* ##### Error Response:

	**Code**: RESOURCE NOT FOUND


#### Add a category
Resource to add a category.

* ##### URL

	< /categories/ >

* ##### Method:

	`POST`

* ##### Body:
	```
	{
		"nameCategory": "nueva"
	}
	```

* ##### Success Response:
	
	```
	{
    		"id": 67,
    		"nameCategory": "nueva"
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED


#### Add an event
Resource to add an event

* ##### URL

	< /events/ >

* ##### Method:

	`POST`

* ##### Body:
	```
	{
            "nameEvent": "special",
            "date": "20-12-18",
            "location": "Aulario 1",
            "wiki": "Aulario 1",
            "hasImage": false,
            "categories": [],
            "photo": null,
            "encodedImage": null
	}
	```

* ##### Success Response:
	
	```
	{
    		"id": 69,
    		"nameEvent": "special",
    		"date": "20-12-18",
    		"location": "Aulario 1",
    		"wiki": "Aulario 1",
    		"hasImage": false,
    		"categories": [],
    		"photo": null,
    		"encodedImage": null
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED



#### Add an image to an event
Resource asigne a selected image to an event given a certain event ID.

* ##### URL

	< /events/{ID}/image >

* ##### Method:

	`POST`

* ##### Settings:
Unset everything in params, in headers key insert Content-Type with no value,
select form-data, in key write "file" and in value click to select an image.

* ##### Success Response:
	
	```
	{
    		"content": [
			{
            			"id": 41,
            			"nameEvent": "DAW",
            			"date": "7-7-2019",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": true,
            			"categories": [
			{
                    		"id": 1,
                    		"nameCategory": "Examenes"
			}
			],
            			"photo": "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",
					"encodedImage": "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"
			},
        		{
            			"id": 42,
            			"nameEvent": "Seguridad",
            			"date": "20-12-18",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
        		},
        		{
            			"id": 43,
            			"nameEvent": "Java",
            			"date": "1-1-19",
            			"location": "Aulario 2",
            			"wiki": "Aulario 2",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
        		},
        		{
            			"id": 44,
            			"nameEvent": "DAW",
            			"date": "7-7-2019",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
			},
			{
            			"id": 45,
            			"nameEvent": "Seguridad",
            			"date": "20-12-18",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
			}
			]
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED OR 500 INTERNAL ERROR(If any of the settings is not correct).


#### Add a time
Resource to add a time.

* ##### URL

	< /times/ >

* ##### Method:

	`POST`

* ##### Body:
	```
	{
		"nameInterval": "newTime",
		"startDate": "2-1-2020",
		"endDate": "1-3-2020",
		"events": [],
		"subIntervals": []
	}
	```

* ##### Success Response:
	
	```
	{
    		"id": 72,
    		"nameInterval": "newTime",
    		"startDate": "2-1-2020",
    		"endDate": "1-3-2020",
    		"events": [],
    		"subIntervals": []
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED


#### Deleting a category
Resource to delete a category with a given ID.

* ##### URL

	< /categories/ >

* ##### Method:

	`DELETE`

* ##### Example of query:

	* URL
		
		`/api/categories/1`

* ##### Success Response:
	
	```
	{
   		"id": 1,
    		"nameCategory": "Examenes"
	}
	```

* ##### Result after delete:
	
	```
	{
		"content": [
			{
            		"id": 2,
            		"nameCategory": "Practicas"
			},
			{
            		"id": 3,
            		"nameCategory": "Apuntes"
			},
			{
            		"id": 4,
            		"nameCategory": "Categoria10"
			},
			{
            		"id": 5,
            		"nameCategory": "Categoria11"
			},
			{
            		"id": 6,
            		"nameCategory": "Categoria12"
			}
    		]
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED

#### Deleting an event
Resource to delete an event with a given ID.

* ##### URL

	< /events/ >

* ##### Method:

	`DELETE`

* ##### Example of query:

	* URL
		
		`/api/events/41`

* ##### Success Response:
	
	```
	{
    		"id": 41,
    		"nameEvent": "DAW",
    		"date": "7-7-2019",
    		"location": "Aulario 1",
   		"wiki": "Aulario 1",
    		"hasImage": false,
    		"categories": [],
    		"photo": null,
    		"encodedImage": null
	}
	```

* ##### Result after delete:
	
	```
	{
		"content": [
			{
            			"id": 42,
           			"nameEvent": "Seguridad",
            			"date": "20-12-18",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
			},
			{
            			"id": 43,
            			"nameEvent": "Java",
            			"date": "1-1-19",
            			"location": "Aulario 2",
            			"wiki": "Aulario 2",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
			},
			{
            			"id": 44,
            			"nameEvent": "DAW",
            			"date": "7-7-2019",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
			},
			{
            			"id": 45,
            			"nameEvent": "Seguridad",
            			"date": "20-12-18",
            			"location": "Aulario 1",
            			"wiki": "Aulario 1",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
			},
			{
            			"id": 46,
            			"nameEvent": "Java",
            			"date": "1-1-19",
            			"location": "Aulario 2",
            			"wiki": "Aulario 2",
            			"hasImage": false,
            			"categories": [],
            			"photo": null,
            			"encodedImage": null
        		}
    	]
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED

#### Deleting a time
Resource to delete a time with a given ID.

* ##### URL

	< /times/ >

* ##### Method:

	`DELETE`

* ##### Example of query:

	* URL
		
		`/api/times/56`

* ##### Success Response:
	
	```
	{
    		"id": 56,
    		"nameInterval": "Intervalo 3",
    		"startDate": "2-4-2021",
    		"endDate": "2-5-2021",
    		"events": [],
    		"subIntervals": []
	}
	```

* ##### Result after delete:
	
	```
	{
		"content": [
			{
            			"id": 55,
            			"nameInterval": "Intervalo 2",
            			"startDate": "2-1-2020",
            			"endDate": "1-3-2020",
            			"events": [],
            			"subIntervals": []
			},
			{
            			"id": 57,
            			"nameInterval": "Intervalo 4",
            			"startDate": "5-7-2018",
            			"endDate": "1-1-2020",
            			"events": [],
            			"subIntervals": []
			},
			{
            			"id": 58,
            			"nameInterval": "Intervalo 5",
            			"startDate": "2-1-2020",
            			"endDate": "1-3-2020",
            			"events": [],
            			"subIntervals": []
			},
			{
            			"id": 59,
            			"nameInterval": "Intervalo 6",
            			"startDate": "2-4-2021",
           			"endDate": "2-5-2021",
           			"events": [],
            			"subIntervals": []
			},
			{
            			"id": 60,
            			"nameInterval": "Intervalo 7",
            			"startDate": "2-4-2021",
            			"endDate": "2-5-2021",
            			"events": [],
            			"subIntervals": []
			}
		]
	}
	```
	
* ##### Error Response:

	**Code**: 401 UNAUTHORIZED


# That's it! Thanks for using our API.
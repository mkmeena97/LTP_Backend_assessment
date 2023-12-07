# LTP_Backend_assessment



# API Documentation

## Client Controller

### Get Client Details by Client ID

**Endpoint:** `/getclient`

**Method:** `GET`

**Parameters:**
- `client_id` (int): ID of the client

**Response:**
- 200 OK: Returns the details of the client with the specified ID.
- 404 Not Found: If no client is found with the provided ID.

### Get Client Details by Client by Name

**Endpoint:** `/getclientbyname/{client_name}`

**Method:** `GET`

**Parameters:**
- `client_name` (String): Name of the client

**Response:**
- 200 OK: Returns the details of the client with the specified name.
- 404 Not Found: If no client is found with the provided name.

## Slot Controller

### Get Slot Details By Slot ID

**Endpoint:** `/getslotdetails/{slot_id}`

**Method:** `GET`

**Parameters:**
- `slot_id` (int): ID of the slot

**Response:**
- 200 OK: Returns the details of the slot with the specified ID.
- 404 Not Found: If no slot is found with the provided ID.

### Get Available Slots

**Endpoint:** `/getavailableslots`

**Method:** `GET`

**Response:**
- 200 OK: Returns a list of available slots.
- 404 Not Found: If no available slots are found.

### Book Slot

**Endpoint:** `/bookslot`

**Method:** `POST`

**Parameters:**
- `slot_id` (int): ID of the slot to be booked
- `client_id` (int): ID of the client making the booking

**Response:**
- 200 OK: Returns true if the slot is successfully booked.
- 400 Bad Request: If the booking request is invalid.

## Booking Controller

### Get Booking Details by Booking ID

**Endpoint:** `/getdetailsbybookingid/{booking_id}`

**Method:** `GET`

**Parameters:**
- `booking_id` (int): ID of the booking

**Response:**
- 200 OK: Returns the details of the booking with the specified ID.
- 404 Not Found: If no booking is found with the provided ID.

### Get Client Booking Details

**Endpoint:** `/getclientbookingdetails/{client_id}`

**Method:** `GET`

**Parameters:**
- `client_id` (int): ID of the client

**Response:**
- 200 OK: Returns a list of bookings made by the specified client.
- 404 Not Found: If no bookings are found for the client.

### Get Consultant Booking Details

**Endpoint:** `/getconsultantbookingdetails/{consultant_id}`

**Method:** `GET`

**Parameters:**
- `consultant_id` (int): ID of the consultant

**Response:**
- 200 OK: Returns a list of bookings associated with the specified consultant.
- 404 Not Found: If no bookings are found for the consultant.

## Session History Controller

### Get Session History by Client ID

**Endpoint:** `/getsessionhistorybyclient/{client_id}`

**Method:** `GET`

**Parameters:**
- `client_id` (int): ID of the client

**Response:**
- 200 OK: Returns the session history for the specified client.
- 404 Not Found: If no session history is found for the client.

### Get Session History by Consultant ID

**Endpoint:** `/getsessionhistorybyconsultant/{consultant_id}`

**Method:** `GET`

**Parameters:**
- `consultant_id` (int): ID of the consultant

**Response:**
- 200 OK: Returns the session history for the specified consultant.
- 404 Not Found: If no session history is found for the consultant.




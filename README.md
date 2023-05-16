## Event API Documentation

### Get Event by ID
```
GET /api/v3/app/events?id=:event_id
```
Returns an event based on its unique ID.

### Get Latest Events
```
GET /api/v3/app/events?type=latest&limit=5&page=1
```
Returns the latest events, paginated by page number and limit of events per page.

### Create Event
```
POST /api/v3/app/events
```
Creates a new event and returns the ID of the created event. Requires the following payload parameters:
- `name`: Name of the event
- `tagline`: A proper tag-line for the event
- `schedule`: Date and time of the event
- `description`: Description of the event
- `moderator`: User who is hosting the event
- `category`: Category of the event
- `sub_category`: Subcategory of the event
- `rigor_rank`: Integer value representing the rigor level of the event
- `files[image]`: Image file for the event (file upload)

### Update Event
```
PUT /api/v3/app/events/:id
```
Updates an existing event based on its ID. Requires the same payload parameters as the Create Event endpoint.

### Delete Event
```
DELETE /api/v3/app/events/:id
```
Deletes an event based on its unique ID.

#### Event Object Data Model
- `type`: "event"
- `uid`: User ID (integer)
- `name`: Name of the event (string)
- `tagline`: A proper tag-line for the event (string)
- `schedule`: Date and time of the event (timestamp)
- `description`: Description of the event (string)
- `files[image]`: Image file for the event (file upload)
- `moderator`: User who is hosting the event (string)
- `category`: Category of the event (string)
- `sub_category`: Subcategory of the event (string)
- `rigor_rank`: Integer value representing the rigor level of the event
- `attendees`: Array of user IDs who are attending the event

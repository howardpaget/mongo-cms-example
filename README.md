

```bash
curl -H "Content-Type: application/json"  http://localhost:8080/authors --data '{ "name": "Joe Bloggs", "bio": "..." }'

# returns { "id": "6485b5b263bc71798283bbb4", "name": "Joe Bloggs", "bio": "..." }
```

```bash
curl -H "Content-Type: application/json"  http://localhost:8080/posts --data '{ "title": "A Post", "authorId": "6485b5b263bc71798283bbb4", "publishedDateTime": "2023-06-10T09:00:00", "tags": ["computing", "mathematics"], "body": "..." }'

# returns { "id": "6485b60e63bc71798283bbb5", "titla": "A Post", ... }
```
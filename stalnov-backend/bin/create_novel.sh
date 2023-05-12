### API 
# Scripts for basic api operations
###
curl -v -H "Content-Type: application/json" -X POST -d '{"title":"The Book of the new Dawn", "description": "This is just a mock novel", "genre": "0"}' http://localhost:8080/api/novels | jq


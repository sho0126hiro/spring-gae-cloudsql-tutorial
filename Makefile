
docker/up/d:
	docker-compose -f docker/docker-compose.yml up -d

docker/up/app:
	docker-compose -f docker/docker-compose.yml up app

docker/db:
	docker-compose -f docker/docker-compose.yml up -d db
docker/stop:
	docker-compose -f docker/docker-compose.yml stop

docker/prod/up:
	docker-compose -f docker/docker-compose.prod.yml up

docker/prod/stop:
	docker-compose -f docker/docker-compose.prod.yml stop

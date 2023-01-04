# YOUR DOCKER IMAGE MIGHT BE BROKEN
Without you knowing it.
Learn the right way to build your Dockerfile.

## So you're building a Docker image. What might be wrong with it?
Dockerを知ったらDockerfileが作りたくなるだろう。

```dockerfile
FROM ubuntu:16.04

RUN apt-get install all_my_dependencies
ADD my_app_files /my_app

CMD ["/my_app/start.sh"]
```

これで動く。簡単だね。

いや、実はそうではない。

コンテナ内では指定したアプリしか動いてない。適切なUnixシステムは複数の重要なシステムを動かさなくてはならず、それができてない。

### "What do you mean? I'm just using Ubuntu in Docker. Doesn't the OS inside the container take care of everything automatically?"

### "What important system services am I missing?"

### "Does all this apply too if I'm using CentOS inside the container, or another Linux distribution?"

### "But I thought Docker is about running a single process in a container?"

# Reference
- [YOUR DOCKER IMAGE MIGHT BE BROKEN](https://phusion.github.io/baseimage-docker/)

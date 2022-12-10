# Learning Docker
These are memorandoms to capture points about Docker.

## How to set up Docker environment on mac
By using multipass, and executing commands bellow.
- `multipass launch docker --name docker-on-ubuntu --mem 8G --disk 40G --cpus 2`
    - Create Ubuntu22.04 instance.
- `multipass shell docker-on-ubuntu`
    - Login to the instance.

## Reference
- [Multipass Tutorial - macOS](https://multipass.run/docs/mac-tutorial)
    - [Launch from a Blueprint to run Docker containers](https://multipass.run/docs/mac-tutorial#heading--launch-from-a-blueprint-to-run-docker-containers)

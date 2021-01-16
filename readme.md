![Java CI with Maven](https://github.com/HarddriveManoj/WestwingNow/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)

(If the build status is failing, it is due to non-existence of the password in properties file. Please get in touch for further details.)

# WestwingNow

WestwingNow is a Java Automation project for automating tests using Cucumber BDD framework.


## Prerequisites

This project requires docker to be installed with at least 1 Chrome instance running on it.

## Setup Docker

````
#run with WSL prompt
docker-compose -f docker-grid.yml up -d
````

## Usage

To run this project via command line:

```bash
mvn -U clean test
```

Configure Local vs Remote(Docker) mode

Navigate to src -> test -> resources -> user.properties
```bash
#values: local, remote
mode=local
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
NA

## Developer Contact

Please click on [email](mailto:manojgkolhe@gmail.com) to contact Manoj Kolhe.

```bash
manojgkolhe@gmail.com
```

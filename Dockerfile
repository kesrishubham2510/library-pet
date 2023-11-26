# This docker file should get executed to setup the local nexus server
FROM ubuntu

RUN apt-get update;

# add the git and wget utility
RUN apt install -y wget
RUN apt install -y git

# using openJDK because jdk installation requires account signOut/signIn, hence using openJDKs
RUN apt install -y openjdk-17-jre

# add a nexus user with specific credentials
RUN apt install -y curl

# make a directory /home/developer
WORKDIR /
RUN mkdir -p /home/developer

# changing working dir
WORKDIR /home/developer

# clone the repo from github
RUN git clone https://github.com/kesrishubham2510/library-pet.git


# navigate to the library-pet and execute the build
WORKDIR ./library-pet

RUN git pull

# change to branch dockerization
RUN git checkout dockerization

RUN ./gradlew build

# change workDir and add user
ENTRYPOINT ["./gradlew","publish"]
FROM ubuntu:20.04

RUN apt-get update && apt-get install -y \
    cmake \
    build-essential \
    libarchive13 \
    libcurl4 \
    libuv1

WORKDIR /project

COPY . /project

CMD ["bash"]



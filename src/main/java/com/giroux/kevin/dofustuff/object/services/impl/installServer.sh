#!/usr/bin/env bash
#Installation de Docker

sudo yum remove docker docker-common docker-selinux docker-engine
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
yum-config-manager --enable extras
sudo yum install docker-ce

sudo curl -L https://github.com/docker/compose/releases/download/1.16.1/docker-compose-`uname -s`- `uname -m` -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
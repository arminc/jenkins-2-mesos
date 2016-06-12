FROM arminc/jenkins:2.8

RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion

RUN install-plugins.sh metrics mesos

COPY jenkins-mesos.groovy /usr/share/jenkins/ref/init.groovy.d/jenkins-mesos.groovy
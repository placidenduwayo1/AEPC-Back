pipeline {
    agent any //we tell jenkins to use any available agent
    tools {
        maven 'Maven-3.8.8'
        jdk 'Java-17'
    }
    stages {
                
        stage ('Build-config-service') {
            steps {
                dir('./ms-config-service'){ //enter in folder to locate pom.xml
                    bat 'mvn -B -DskipTests clean verify'
                }
            }
        }
        stage ('Build-ms-registration-service') {
            steps {
                dir('./ms-registration-service'){
                    bat 'mvn -B -DskipTests clean verify'
                }
            }
        }
        stage ('Build-gateway-service') {
            steps {
                dir ('./back-front-gateway-service'){
                     bat 'mvn -B -DskipTests clean verify'
                }
                
            }
         }

        stage ('Build-bs-ms-adrress') {
            steps {
                dir('./clean-archi-ms-address/'){
                      bat 'mvn -B -DskipTests clean verify'
                }
            }
         }
        stage ('Build-bs-ms-company'){
            steps {
                dir('./clean-archi-ms-company/'){
                     bat 'mvn -B -DskipTests clean verify'
                }
                
            }
          }
        stage ('Build-bs-ms-employee'){
            steps{
                dir('./clean-archi-ms-employee/'){
                     bat 'mvn -B -DskipTests clean verify'
                }
            }
           }
        stage ('Build-bs-ms-project'){
            steps {
                dir('./clean-archi-ms-project/'){
                    bat 'mvn -B -DskipTests clean verify'
                }
            }
        }
    }
}
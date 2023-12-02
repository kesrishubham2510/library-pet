pipeline{
  agent any

  stages{

     stage('Clean'){
        steps{
          sh './gradlew clean'
        }
     }

     stage('Test'){
        steps{
          sh './gradlew test'
        }
     }

     stage('Build'){
        steps{
            sh './gradlew build'
        }
     }

     stage('Sonar analysis'){
        steps{
            sh './gradlew sonar'
        }
     }

     stage('Publish'){
        steps{
            sh './gradlew publish'
        }
     }
  }
}
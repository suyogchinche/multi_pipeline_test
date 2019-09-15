pipeline{
    agent {
        label 'master'
    }
    
    environment {

    VERSION_NUMBER = VersionNumber([
        versionNumberString :'${BUILD_MONTH}.${BUILDS_TODAY}.${BUILD_NUMBER}',
        projectStartDate : '2019-02-09',
        versionPrefix : 'v'
        ])

    }

    libraries {
       lib('my-shared-library@master')
    }

    stages {
       stage('Checkout') {
          steps {
              sh 'printenv'
              script {
                  scmVars = checkout scm // won't cost much as the data is already here, simply gives us some more information
              }
          }
       }
       stage('Tag repo') {
           steps {
               echo show_BuildId()
           }
       }
    }
}


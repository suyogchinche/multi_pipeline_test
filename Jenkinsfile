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
       stage('Tag repo') {
           steps {
               script {
                 env.BUILD_ID = show_BuildId()
               }
               echo 'Suyog:::::::::::::::::::'
               sh 'printenv'
               
           }
       }
    }
}


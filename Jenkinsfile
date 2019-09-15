pipeline{
    agent {
        label 'master'
    }

    libraries {
       lib('my-shared-library@master')
    }

    stages {
       stage('Checkout') {
          steps {
              script {
                  scmVars = checkout scm // won't cost much as the data is already here, simply gives us some more information
              }
          }
       }
       stage('Tag repo') {
           environment {
               NEW_VERSION = '0.1.1'
            }
           steps {
               gitRemoteConfigByUrl(scmVars.GIT_URL, 'githubtoken')
               sh '''git config --global user.email "jenkins@jenkins.io"
               git config --global user.name "Jenkins"
               '''
               // Directly passing in the var will give you an error
               gitTag("v${NEW_VERSION}")
           }
       }
    }
}


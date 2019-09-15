pipeline{
    agent {
        label 'master'
    }
    
    libraries {
       lib('my-shared-library@master')
    }

    environment {
       //application metadata related variables
       APP_NAME = "shared_lib"
       APP_AUTHOR = "Suyog Chinche"

    } 
    stages{
        stage('Preparation'){
            
            steps{
                hello 'Sachin'
                show_BuildId()
            }
        }
        
    }
}

pipeline {
  agent any
  stages {
    stage('Deliver for development') {
            when {
                branch 'master'
            }
            steps {
 		sh 'echo Building master ${BRANCH_NAME}...'
            }
        }
        stage('Deploy for production') {
            when {
                branch 'feature-*'
            }
            steps {
		sh 'echo Building ${BRANCH_NAME}...'
		sh 'printenv'
		
            }
        }
   }
}


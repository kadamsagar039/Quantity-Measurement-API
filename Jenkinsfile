pipeline {
	agent any
    environment {
        CI = 'true'
    }
   stages {
        stage('Code Analysis') {
		steps {
			withSonarQubeEnv('sonarcube') {
                        sh './jenkins/scripts/codequality.sh'
			timeout(time: 1, unit: 'HOURS') {
                        waitForQualityGate abortPipeline: true
              }
		      }
	}
	
	   /*
        stage('Test') {
            steps {
                sh './jenkins/scripts/test.sh'
            }
        }
        stage('Deliver for development') {
            when {
                branch 'development'
            }
            steps {
                sh './jenkins/scripts/deliver-for-development.sh'
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh './jenkins/scripts/kill.sh'
            }
        }
        stage('Deploy for production') {
            when {
                branch 'production'
            }
            steps {
                sh './jenkins/scripts/deploy-for-production.sh'
            }
        }
	*/
    }
}

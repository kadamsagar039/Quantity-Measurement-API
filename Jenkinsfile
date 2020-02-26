pipeline {
	agent any
    environment {
        CI = 'true'
	    /*
	JAVA_HOME = '/usr/lib/jvm/java-8-openjdk-amd64/jre'
        M2_HOME = '/var/jenkins_home/maven/apache-maven-3.6.3'
        MAVEN_HOME = '/var/jenkins_home/maven/apache-maven-3.6.3'
        PATH = '${M2_HOME}/bin:${PATH}'
	*/
	
    }
   stages {
        stage('Code Analysis') {
		steps {
			withSonarQubeEnv('sonarcube') {
			sh 'printenv'
                        sh '/var/jenkins_home/maven/apache-maven-3.6.3/bin/mvn clean package sonar:sonar'
			     }
			withSonarQubeEnv('quality gate') {
			timeout(time: 1, unit: 'HOURS') {
                        waitForQualityGate abortPipeline: true
                                                        }
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

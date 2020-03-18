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
				               }
	                       }
   
	
	stage ("QualityGate") {
                 steps {
                      script {
                              
        
              def qualitygate = waitForQualityGate()
              if (qualitygate.status != "OK") {
                 error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
	
	
		      	      
			      
          } 
	      }
     }
  }     
	   
        stage('Build') {
            steps {
                sh '/var/jenkins_home/maven/apache-maven-3.6.3/bin/mvn package -Dmaven.test.skip=true'
            }
        }
	
        stage('Deliver for development') {
          sh label: '', script: '''fuser -k 8080/tcp
          scp /home/workspace/Quantity-Measurement/target/quantitymeasurement-0.0.1-SNAPSHOT.jar ubuntu@13.235.9.40:/home/ubuntu
          java -jar quantitymeasurement-0.0.1-SNAPSHOT.jar --httpPort=8080'''
        }
	   
        /*stage('Deploy for production') {
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

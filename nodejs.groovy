pipeline {
  agent any
 
  tools {nodejs "node"}
 
  stages {
  
   try{
    stage('Example') {
        
      steps {
        sh 'npm config ls'
        
      }
        
    }
      stage('check out') {
      steps {
        git 'https://github.com/Viks303/node-hello.git'
      }
    }
        
    stage('Install dependencies') {
      steps {
        sh 'npm install'
      }
    }
    
    stage('Test') {
      steps {
         sh 'npm test'
      }
    }

catch (err) {

emailext body: 'Please validate either source code or build pipeline as Jenkins job thrown error.', 
recipientProviders: [developers(), requestor()], subject: 'Jenkins job alert', to: 'vignesh.munindrababu@gmail.com'	

  }
}

}

}

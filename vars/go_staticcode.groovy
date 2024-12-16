def call() {
         withSonarQubeEnv('SonarQube') {
                    sh """
                      
                       -Dsonar.projectKey=employee-api \
                       -Dsonar.sources=. \
                       -Dsonar.host.url=http://65.2.175.160:9000/
                       """
                }
}

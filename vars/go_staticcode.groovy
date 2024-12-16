def call() {
         withSonarQubeEnv('SonarQube') {
                    sh """
                       sonar-scanner \
                       -Dsonar.projectKey=employee-api \
                       -Dsonar.sources=. \
                       -Dsonar.host.url=http://65.2.175.160:9000/
                       """
                }
}

def call(){
{
        sh 'go mod tidy'
    }
{
        sh '''
                export PATH=$(go env GOPATH)/bin:$PATH
                golangci-lint run ./... || true
                '''
    }
 {
        withSonarQubeEnv('SonarQube') {
                    sh """
                        ${SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectKey=$SONARQUBE_PROJECT_KEY \
                        -Dsonar.sources=. \
                        -Dsonar.host.url=${env.SONAR_HOST_URL}
                    """
                }
    }
}

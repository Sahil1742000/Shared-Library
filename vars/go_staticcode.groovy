def call() {
        sh 'go mod tidy'
    }
def call() {
        sh '''
                export PATH=$(go env GOPATH)/bin:$PATH
                golangci-lint run ./... || true
                '''
    }
def call() {
        withSonarQubeEnv('SonarQube') {
                    sh """
                        ${SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectKey=$SONARQUBE_PROJECT_KEY \
                        -Dsonar.sources=. \
                        -Dsonar.host.url=${env.SONAR_HOST_URL}
                    """
                }
    }

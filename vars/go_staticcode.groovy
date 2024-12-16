

// Function for cleaning the workspace
def clean_workspace() {
    cleanWs()  // Cleans the workspace before starting the build
}

// Function for installing Go dependencies
def install_dependencies() {
    sh 'go mod tidy'
}

// Function for code linting
def code_linting() {
    sh '''
    export PATH=$(go env GOPATH)/bin:$PATH
    golangci-lint run ./... || true
    '''
}

// Function for SonarQube analysis
def sonar_analysis(SCANNER_HOME, SONARQUBE_PROJECT_KEY) {
    withSonarQubeEnv('SonarQube') {
        sh """
            ${SCANNER_HOME}/bin/sonar-scanner \
            -Dsonar.projectKey=$SONARQUBE_PROJECT_KEY \
            -Dsonar.sources=. \
            -Dsonar.host.url=${env.SONAR_HOST_URL}
        """
    }
}

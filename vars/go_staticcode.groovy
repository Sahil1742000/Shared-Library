def call() {
    withSonarQubeEnv('SonarQube') {
        def scannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=employee-api \
            -Dsonar.sources=. \
            -Dsonar.host.url=http://65.2.175.160:9000
        """
    }
}

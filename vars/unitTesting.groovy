def call() {
    
        sh """
            go test -v ./... | /var/lib/jenkins/go/bin/go-junit-report > report.xml
            junit '**/report.xml' 
        """
    }
}

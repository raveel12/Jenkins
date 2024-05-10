pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building code with Gradle'
                
            }
        }    
        stage('Unit and Integration Tests') {
            steps {
                echo 'Testing will be done by: '
                echo 'SELENIUM'
                echo 'LambdaTest'
                echo 'Cucumber'
                echo 'Protractor'
            }
            post{
                success{
                  
                    emailext(
                        to: 'raveelkashif10@gmail.com',
                        subject: "Unit and Integration Tests status Email",
                        body: """Tests were successful. Check console output ${env.BUILD_URL}</p>""",
                        attachLog: true
                    )
                }
                 failure{
                 
                     emailext(
                            to: 'raveelkashif10@gmail.com',
                            subject: "Units and Integration Tests status Email",
                            body: """Tests failed. Check console output ${env.BUILD_URL}</p>""",
                            attachLog: true
                        )
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'SonarQube for maintaining code'
                echo 'ReSharper for refactoring code'
                
            }
        }
        stage('Security Scan') {
            steps {
                echo "Scan code with Codiga to identify any vulnerabilities"
                
            }
            post{
                success{
                
                     emailext(
                        to: 'raveelkashif10@gmail.com',
                        subject: "Security Scan status Email",
                        body: """Scan was successful. Check console output ${env.BUILD_URL}</p>""",
                        attachLog: true
                    )
                }
                
                 failure{
                
                     emailext(
                        to: 'raveelkashif10@gmail.com',
                        subject: "Security Scan status Email",
                        body: """Scan failed. Check console output ${env.BUILD_URL}</p>""",
                        attachLog: true
                    )
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo "Deploy the application to AWS EC2 instance"
                
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo"run integration tests on AWS EC2 instance"
                
            }
            post{
                success{
                
                     emailext(
                        to: 'raveelkashif10@gmail.com',
                        subject: "Integration Tests on Staging status Email",
                        body: """Tests were successful. Check console output ${env.BUILD_URL}</p>""",
                        attachLog: true
                    )
                }
                 failure{
               
                     emailext(
                        to: 'raveelkashif10@gmail.com',
                        subject: "Integration Tests on Staging status Email",
                        body: """Tests failed. Check console output ${env.BUILD_URL}</p>""",
                        attachLog: true
                    )
                }
            }
        }
        stage('Deploy To Production') {
            steps {
                echo "Deploy the application to AWS EC2 instance"
                
            }
        }  
    }
}
